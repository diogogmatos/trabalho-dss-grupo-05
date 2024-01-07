package ESIdealLN.Servicos;

import ESIdealDL.ServicoDAO;
import ESIdealDL.ServicoAgendadoDAO;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GesServicosFacade implements IGesServicos {

	private final ServicoAgendadoDAO servicosAgendados;
	private final ServicoDAO servicosDisponiveis;

	public GesServicosFacade() {
		this.servicosAgendados = new ServicoAgendadoDAO();
		this.servicosDisponiveis = new ServicoDAO();
	}

	/**
	 *
	 * @param tipoServico
	 */
	public List<Servico> obterServicosDeTipo(String tipoServico) throws Exception {
		return servicosDisponiveis.getServicosPorTipo(tipoServico);
	}

	/**
	 * 
	 * @param idServico
	 * @param matricula
	 */
	public int adicionarServicoPendente(int idServico, String matricula, int funcionarioOtimo) throws Exception {
		return servicosAgendados.adicionarServicoPendente(idServico, matricula, funcionarioOtimo);
	}

	/**
	 *
	 * @param nrMarcacao
	 */
	public void removerServicoPendente(int nrMarcacao) throws Exception {
		servicosAgendados.removerServicoPendente(nrMarcacao);
	}

	/**
	 * Verifica se a hora de conlcusão do dado serviço pelo dado funcionário não ultrapassa a hora de fecho
	 * @param funcionarioOtimo
	 * @param servico
	 * @param fecho
	 */
	public boolean analisarDisponibilidade(int funcionarioOtimo, Servico servico, LocalTime fecho) throws Exception {
		int tempoNecessario = servicosAgendados.tempoNecessarioAcabarServicosFuncionario(funcionarioOtimo);
		LocalDateTime dataAtual = LocalDateTime.now();
		LocalDateTime dataFecho = LocalDateTime.of(dataAtual.toLocalDate(), fecho);
		// hora atual + tempo para acabar serviços pendentes do funcionário + tempo do serviço a agendar
        return !dataAtual.plusMinutes(tempoNecessario).plusMinutes(servico.getTempoNecessario()).isAfter(dataFecho);
	}

	/**
	 * Calcula funcionario cujos serviços pendentes demorem menos tempo a concluir
	 * @param funcionariosCompativeis
	 */
	public int calcularFuncionarioOtimo(List<Integer> funcionariosCompativeis) throws Exception {
		int funcionarioOtimo = funcionariosCompativeis.get(0);
		int tempoNecessario = servicosAgendados.tempoNecessarioAcabarServicosFuncionario(funcionarioOtimo);
		for (int i = 1; i < funcionariosCompativeis.size(); i++) {
			int tempoNecessarioFuncionario = servicosAgendados.tempoNecessarioAcabarServicosFuncionario(funcionariosCompativeis.get(i));
			if (tempoNecessarioFuncionario < tempoNecessario) {
				funcionarioOtimo = funcionariosCompativeis.get(i);
				tempoNecessario = tempoNecessarioFuncionario;
			}
		}
		return funcionarioOtimo;
	}

	/**
	 * 
	 * @param designacaoServicos
	 */
	public List<Servico> designacaoParaServicos(List<String> designacaoServicos) throws Exception {
		List<Servico> servicos = new ArrayList<>();
		for (String designacao : designacaoServicos) {
			Servico s = servicosDisponiveis.getServicoPorDesignacao(designacao);
			servicos.add(s);
		}
		return servicos;
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public boolean temServicosAtribuidos(int nrCartao) throws Exception {
		return servicosAgendados.existemServicosPendentesParaFuncionario(nrCartao);
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public ServicoAgendado getServicoPendente(int nrCartao) throws Exception {
		return servicosAgendados.getServicoPendente(nrCartao);
	}

	/**
	 * 
	 * @param designacao
	 * @param tipo
	 */
	public int adicionarServicoDisponivel(String designacao, int tempoNecessario, String tipo) throws Exception {
		return servicosDisponiveis.adicionarServico(designacao, tempoNecessario, tipo);
	}

	/**
	 * 
	 * @param designacao
	 */
	public void removerServicoDisponivel(String designacao) throws Exception {
		Servico s = servicosDisponiveis.getServicoPorDesignacao(designacao);
		servicosDisponiveis.removerServico(s.getId());
	}

	/**
	 *
	 * @param idServico
	 */
	public Servico getServicoDisponivel(int idServico) throws Exception {
		return servicosDisponiveis.getServico(idServico);
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean veiculoTemServicosPendentes(String matricula) throws Exception {
		return servicosAgendados.existemServicosPendentesParaVeiculo(matricula);
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean veiculoTemServicosConcluidos(String matricula) throws Exception {
		return servicosAgendados.existemServicosConcluidosParaVeiculo(matricula);
	}

	/**
	 * 
	 * @param nrMarcacao
	 */
	public void concluirServico(int nrMarcacao) throws Exception {
		servicosAgendados.marcarComoConcluido(nrMarcacao);
	}

	/**
	 *
	 * @param nrMarcacao
	 * @param motivo
	 */
	public void marcarComoIncompleto(int nrMarcacao, String motivo) throws Exception {
		servicosAgendados.marcarComoIncompleto(nrMarcacao, motivo);
	}

	/**
	 * 
	 * @param nrsMarcacao
	 */
	public LocalTime calcularHoraConclusao(List<Integer> nrsMarcacao) throws Exception {
		LocalTime horaAtual = LocalTime.now();
		LocalTime horaMaxima = LocalTime.now();
		for (int nrMarcacao : nrsMarcacao) {
			ServicoAgendado sa = servicosAgendados.getServicoAgendado(nrMarcacao);
			List<ServicoAgendado> servicosPendentes = servicosAgendados.getServicosPendentesFuncionario(sa.getFuncionario());
			int tempoNecessario = 0;
			for (ServicoAgendado servicoAgendado : servicosPendentes) {
				tempoNecessario += getServicoDisponivel(servicoAgendado.getIdServico()).getTempoNecessario();
			}
			LocalTime horaConclusao = horaAtual.plusMinutes(tempoNecessario);
			if (horaConclusao.isAfter(horaMaxima)) {
				horaMaxima = horaConclusao;
			}
		}
		return horaMaxima;
	}

	public List<ServicoAgendado> getServicosPendentes() throws Exception {
		return servicosAgendados.getServicosPendentes();
	}

	public List<ServicoAgendado> getServicosConcluidos() throws Exception {
		return servicosAgendados.getServicosConcluidos();
	}

	public List<Servico> getServicosDisponiveis() throws Exception {
		return servicosDisponiveis.getServicos();
	}

	public List<ServicoAgendadoIncompleto> getServicosIncompletos() throws Exception {
		return servicosAgendados.getServicosIncompletos();
	}
}