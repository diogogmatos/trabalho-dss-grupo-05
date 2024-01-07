package ESIdealLN;

import ESIdealLN.Clientes.Cliente;
import ESIdealLN.Estacao.PostoTrabalho;
import ESIdealLN.Admin.GesAdminFacade;
import ESIdealLN.Clientes.GesClientesFacade;
import ESIdealLN.Funcionarios.Funcionario;
import ESIdealLN.Funcionarios.GesFuncionariosFacade;
import ESIdealLN.Funcionarios.RegistoServico;
import ESIdealLN.Funcionarios.RegistoTurno;
import ESIdealLN.Servicos.GesServicosFacade;
import ESIdealLN.Servicos.Servico;
import ESIdealLN.Servicos.ServicoAgendado;
import ESIdealLN.Servicos.ServicoAgendadoIncompleto;
import ESIdealLN.Veiculos.GesVeiculosFacade;
import ESIdealLN.Estacao.GesEstacaoFacade;
import ESIdealLN.Veiculos.Veiculo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LNFacade {
    private final GesAdminFacade gesAdminFacade = new GesAdminFacade("admin");
    private final GesClientesFacade gesClientesFacade = new GesClientesFacade();
    private final GesFuncionariosFacade gesFuncionariosFacade = new GesFuncionariosFacade();
    private final GesServicosFacade gesServicosFacade = new GesServicosFacade();
    private final GesVeiculosFacade gesVeiculosFacade = new GesVeiculosFacade();
    private final GesEstacaoFacade gesEstacaoFacade = new GesEstacaoFacade();

    private int turnoAtual;
    private int marcacaoAtual;

    // AUTENTICACAO

    public boolean autenticarAdmin(String palavraPasse) throws Exception {
        return gesAdminFacade.autenticarAdmin(palavraPasse);
    }

    public void alterarPalavraPasseAdmin(String novaPwdMestra) throws Exception {
        gesAdminFacade.alterarPalavraPasse(novaPwdMestra);
    }

    public boolean autenticarFuncionario(int nrCartao, int nrPosto) throws Exception {
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataFecho = LocalDateTime.of(dataAtual.toLocalDate(), gesEstacaoFacade.getFecho());
        if (LocalDateTime.now().isAfter(dataFecho))
            throw new Exception("A estação está fechada.\n\tHorário: " + gesEstacaoFacade.getAbertura() + " - " + gesEstacaoFacade.getFecho());

        if (!gesFuncionariosFacade.validaFuncionario(nrCartao))
            return false;

        List<String> competencias = gesFuncionariosFacade.getCompetencias(nrCartao);
        for (String competencia : competencias) {
            if (gesEstacaoFacade.verificaTipo(nrPosto, competencia))
                return true;
        }

        return false;
    }

    // ESTACAO

    public void definirAbertura(LocalTime abertura) throws Exception {
        gesEstacaoFacade.definirAbertura(abertura);
    }

    public void definirFecho(LocalTime fecho) throws Exception {
        gesEstacaoFacade.definirFecho(fecho);
    }

    public boolean validaPostoTrabalho(int nrPosto) throws Exception {
        return gesEstacaoFacade.validaPostoTrabalho(nrPosto);
    }

    // FUNCIONARIO

    public void iniciarTurnoTrabalho(int nrCartao) throws Exception {
        turnoAtual = gesFuncionariosFacade.iniciarTurno(nrCartao);
    }
    public void terminarTurnoTrabalho(int nrCartao) throws Exception {
        gesFuncionariosFacade.terminarTurno(turnoAtual);
    }
    public String obterServicoPendente(int nrCartao) throws Exception {
        ServicoAgendado sa = gesServicosFacade.getServicoPendente(nrCartao);
        Servico sd = gesServicosFacade.getServicoDisponivel(sa.getIdServico());

        marcacaoAtual = sa.getNrMarcacao();
        gesFuncionariosFacade.iniciarServico(turnoAtual, marcacaoAtual);

        return "=== Serviço ===\n" + sa + "=== Detalhes ===\n" + sd.toString();
    }
    public void terminarServico() throws Exception {
        gesServicosFacade.concluirServico(marcacaoAtual);
        gesFuncionariosFacade.terminarServico(marcacaoAtual);
    }
    public void terminarServico(String motivo) throws Exception {
        gesServicosFacade.marcarComoIncompleto(marcacaoAtual, motivo);
        gesFuncionariosFacade.terminarServico(marcacaoAtual);
    }
    public List<String> obterServicosDisponiveisVeiculo(String matricula) throws Exception {
        List<String> tiposServicoCompativeis = gesVeiculosFacade.obterTipoServicosCompativeis(matricula);
        List<String> designacaoServicosDisponiveis = new ArrayList<>();

        for (String tipoServico: tiposServicoCompativeis) {
            List<Servico> servicosDisponiveis = gesServicosFacade.obterServicosDeTipo(tipoServico);
            for (Servico servico: servicosDisponiveis) {
                designacaoServicosDisponiveis.add(servico.getDesignacao());
            }
        }

        return designacaoServicosDisponiveis;
    }
    public List<Integer> agendarServicos(String matricula, List<String> designacaoServicos) throws Exception {
        List<Servico> servicos = gesServicosFacade.designacaoParaServicos(designacaoServicos);
        List<Integer> nrsMarcacao = new ArrayList<>();
        for (Servico servico : servicos) {
            List<Integer> funcionariosCompativeis = gesFuncionariosFacade.getFuncionariosComCompetencia(servico.getTipo());
            int funcionarioOtimo = gesServicosFacade.calcularFuncionarioOtimo(funcionariosCompativeis);
            if (gesServicosFacade.analisarDisponibilidade(funcionarioOtimo, servico, gesEstacaoFacade.getFecho()))
                nrsMarcacao.add(gesServicosFacade.adicionarServicoPendente(servico.getId(), matricula, funcionarioOtimo));
        }
        return nrsMarcacao;
    }
    public String obterHoraConclusaoServicos(List<Integer> nrsMarcacao) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return gesServicosFacade.calcularHoraConclusao(nrsMarcacao).format(formatter);
    }

    // CLIENTE

    public boolean validarCliente(String nif) throws Exception {
        return gesClientesFacade.verificarRegistoCliente(nif);
    }
    public boolean validarVeiculoCliente(String nif, String matricula) throws Exception {
        return gesVeiculosFacade.validarDonoVeiculo(nif, matricula);
    }
    public void definirPreferenciasNotificacao(String nif, boolean notificacaoSMS, boolean notificacaoEmail) throws Exception {
        gesClientesFacade.registarPreferenciaNotificacao(nif, notificacaoSMS, notificacaoEmail);
    }

    // ADMIN

    public String consultarPostosTrabalho() throws Exception {
        List<PostoTrabalho> postosTrabalho = gesEstacaoFacade.getPostosTrabalho();
        StringBuilder sb = new StringBuilder();
        for (PostoTrabalho postoTrabalho : postosTrabalho) {
            sb.append(postoTrabalho.toString()).append("\n");
        }
        return sb.toString();
    }

    public String consultarServicosPendentes() throws Exception {
        List<ServicoAgendado> servicosPendentes = gesServicosFacade.getServicosPendentes();
        StringBuilder sb = new StringBuilder();
        for (ServicoAgendado servicoAgendado : servicosPendentes) {
            sb.append(servicoAgendado.toString()).append("\n");
        }
        return sb.toString();
    }

    public String consultarServicosDisponiveis() throws Exception {
        List<Servico> servicosDisponiveis = gesServicosFacade.getServicosDisponiveis();
        StringBuilder sb = new StringBuilder();
        for (Servico servico : servicosDisponiveis) {
            sb.append(servico.toString()).append("\n");
        }
        return sb.toString();
    }

    public String consultarServicosConcluidos() throws Exception {
        List<ServicoAgendado> servicosConcluidos = gesServicosFacade.getServicosConcluidos();
        StringBuilder sb = new StringBuilder();
        for (ServicoAgendado servicoAgendado : servicosConcluidos) {
            sb.append(servicoAgendado.toString()).append("\n");
        }
        return sb.toString();
    }

    public String consultarServicosIncompletos() throws Exception {
        List<ServicoAgendadoIncompleto> servicosIncompletos = gesServicosFacade.getServicosIncompletos();
        StringBuilder sb = new StringBuilder();
        for (ServicoAgendado servicoAgendado : servicosIncompletos) {
            sb.append(servicoAgendado.toString()).append("\n");
        }
        return sb.toString();
    }

    public String consultarFuncionarios() throws Exception {
        List<Funcionario> funcionarios = gesFuncionariosFacade.getFuncionarios();
        StringBuilder sb = new StringBuilder();
        for (Funcionario funcionario : funcionarios) {
            sb.append(funcionario.toString()).append("\n");
        }
        return sb.toString();
    }

    public String consultarTurnos() throws Exception {
        List<RegistoTurno> turnos = gesFuncionariosFacade.getTurnos();
        StringBuilder sb = new StringBuilder();
        for (RegistoTurno turno : turnos) {
            sb.append(turno.toString()).append("\n");
        }
        return sb.toString();
    }

    public String consultarRegistoServicos() throws Exception {
        List<RegistoServico> registoServicos = gesFuncionariosFacade.getRegistoServicos();
        StringBuilder sb = new StringBuilder();
        for (RegistoServico registoServico : registoServicos) {
            sb.append(registoServico.toString()).append("\n");
        }
        return sb.toString();
    }

    public String consultarClientes() throws Exception {
        List<Cliente> clientes = gesClientesFacade.getClientes();
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : clientes) {
            sb.append(cliente.toString()).append("\n");
        }
        return sb.toString();
    }

    public String consultarVeiculos() throws Exception {
        List<Veiculo> veiculos = gesVeiculosFacade.getVeiculos();
        StringBuilder sb = new StringBuilder();
        for (Veiculo veiculo : veiculos) {
            sb.append(veiculo.toString()).append("\n");
        }
        return sb.toString();
    }
}
