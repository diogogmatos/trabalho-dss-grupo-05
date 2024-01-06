package ESIdealLN.Servicos;

import ESIdealDL.ServicoDAO;
import ESIdealDL.ServicoAgendadoDAO;

import java.time.LocalTime;
import java.util.List;

public class GesServicosFacade implements IGesServicos {

	private ServicoAgendadoDAO servicosAgendados;
	private ServicoDAO servicosDisponiveis;

	/**
	 * 
	 * @param tipoServico
	 */
	public List<Servico> obterServicosDeTipo(String tipoServico) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.validarCompatibilidadeServico
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param servico
	 * @param matricula
	 */
	private int adicionarServicoPendente(Servico servico, String matricula) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.adicionarServicoPendente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param designacao
	 */
	private boolean analisarDisponibilidade(String designacao) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.analisarDisponibilidade
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param servico
	 */
	private int calcularFuncionarioOtimo(Servico servico) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.calcularFuncionarioOtimo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param designacaoServicos
	 */
	private List<Servico> designacaoParaServicos(List<String> designacaoServicos) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.designacaoParaServicos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public boolean temServicosAtribuidos(int nrCartao) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.temServicosAtribuidos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public ServicoAgendado getServicoPendente(int nrCartao) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.getServicoPendente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param designacao
	 * @param tipo
	 */
	public boolean adicionarServicoDisponivel(String designacao, String tipo) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.adicionarServicoDisponivel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param designacao
	 */
	public boolean removerServicoDisponivel(String designacao) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.removerServicoDisponivel
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param idServico
	 */
	public Servico getServicoDisponivel(int idServico) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.getServicoDisponivel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 * @param designacaoServicos
	 */
	public List<Integer> agendarServicos(String matricula, List<String> designacaoServicos) throws Exception {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.agendarServicos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean veiculoTemServicosPendentes(String matricula) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.veiculoTemServicosPendentes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean veiculoTemServicosConcluidos(String matricula) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.veiculoTemServicosConcluidos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrMarcacao
	 */
	public void concluirServico(int nrMarcacao) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.concluirServico
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param nrMarcacao
	 * @param motivo
	 */
	public void marcarComoIncompleto(int nrMarcacao, String motivo) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.marcarComoIncompleto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param servicos
	 */
	public LocalTime calcularHoraConclusao(List<Integer> servicos) {
		// TODO - implement ESIdealLN.Servicos.GesServicosFacade.calcularHoraConclusao
		throw new UnsupportedOperationException();
	}
}