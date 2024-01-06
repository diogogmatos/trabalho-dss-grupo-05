package ESIdealLN;

import ESIdealLN.Admin.GesAdminFacade;
import ESIdealLN.Clientes.GesClientesFacade;
import ESIdealLN.Funcionarios.GesFuncionariosFacade;
import ESIdealLN.Servicos.GesServicosFacade;
import ESIdealLN.Servicos.Servico;
import ESIdealLN.Servicos.ServicoAgendado;
import ESIdealLN.Veiculos.GesVeiculosFacade;
import ESIdealLN.Estacao.GesEstacaoFacade;

import java.time.LocalTime;
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

    public boolean autenticarAdmin(String palavraPasse) {
        return gesAdminFacade.autenticarAdmin(palavraPasse);
    }

    public void alterarPalavraPasseAdmin(String novaPwdMestra) {
        gesAdminFacade.alterarPalavraPasse(novaPwdMestra);
    }

    public boolean autenticarFuncionario(int nrCartao, int nrPosto) {
        return gesFuncionariosFacade.autenticarFuncionario(nrCartao, nrPosto);
    }

    // ESTACAO

    public void definirAbertura(LocalTime abertura) {
        gesEstacaoFacade.definirAbertura(abertura);
    }

    public void definirFecho(LocalTime fecho) {
        gesEstacaoFacade.definirFecho(fecho);
    }

    public boolean validaPostoTrabalho(int nrPosto) {
        return gesEstacaoFacade.validaPostoTrabalho(nrPosto);
    }

    // FUNCIONARIO

    public void iniciarTurnoTrabalho(int nrCartao) {
        turnoAtual = gesFuncionariosFacade.iniciarTurno(nrCartao);
    }
    public void terminarTurnoTrabalho(int nrCartao) {
        gesFuncionariosFacade.terminarTurno(nrCartao, turnoAtual);
    }
    public String obterServicoPendente(int nrCartao) {
        ServicoAgendado sa = gesServicosFacade.getServicoPendente(nrCartao);
        Servico sd = gesServicosFacade.getServicoDisponivel(sa.getIdServico());

        marcacaoAtual = sa.getNrMarcacao();
        gesFuncionariosFacade.iniciarServico(nrCartao, marcacaoAtual);

        return "=== Serviço ===\n" + sa.toString() + "\n=== Detalhes ===\n" + sd.toString();
    }
    public void terminarServico(int nrCartao) {
        gesServicosFacade.concluirServico(marcacaoAtual);
        gesFuncionariosFacade.terminarServico(nrCartao, marcacaoAtual);
    }
    public void terminarServico(int nrCartao, String motivo) {
        gesServicosFacade.marcarComoIncompleto(marcacaoAtual, motivo);
        gesFuncionariosFacade.terminarServico(nrCartao, marcacaoAtual);
    }
    public List<String> obterServicosDisponiveisVeiculo(String matricula) {
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
    public List<Integer> agendarServicos(String matricula, List<String> servicos) throws Exception {
        return gesServicosFacade.agendarServicos(matricula, servicos);
    }
    public String obterHoraConclusaoServicos(List<Integer> nrsMarcacao) {
        return gesServicosFacade.calcularHoraConclusao(nrsMarcacao).toString();
    }

    // CLIENTE

    public void definirPreferenciasNotificacao(String nif, boolean notificacaoSMS, boolean notificacaoEmail) {
        gesClientesFacade.registarPreferenciaNotificacao(nif, notificacaoSMS, notificacaoEmail);
    }
}
