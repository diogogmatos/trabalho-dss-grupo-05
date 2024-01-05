import java.time.LocalDateTime;
import java.util.List;

public class GesServicosFacade implements IGesServicos {

	private ServicoAgendadoDAO servicosAgendados;
	private ServicoDAO servicosDisponiveis;
	private int nrTotalMarcacoes;

	/**
	 * 
	 * @param servico
	 * @param matricula
	 */
	private boolean validarCompatibilidadeServico(Servico servico, String matricula) {
		// TODO - implement GesServicosFacade.validarCompatibilidadeServico
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param servico
	 * @param matricula
	 */
	private int adicionarServicoPendente(Servico servico, String matricula) {
		// TODO - implement GesServicosFacade.adicionarServicoPendente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param designacao
	 */
	private boolean analisarDisponibilidade(String designacao) {
		// TODO - implement GesServicosFacade.analisarDisponibilidade
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param servico
	 */
	private int calcularFuncionarioOtimo(Servico servico) {
		// TODO - implement GesServicosFacade.calcularFuncionarioOtimo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param designacaoServicos
	 */
	private List<Servico> designacaoParaServicos(List<String> designacaoServicos) {
		// TODO - implement GesServicosFacade.designacaoParaServicos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public boolean temServicosAtribuidos(int nrCartao) {
		// TODO - implement GesServicosFacade.temServicosAtribuidos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public ServicoAgendado getServicoPendente(int nrCartao) {
		// TODO - implement GesServicosFacade.getServicoPendente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param designacao
	 * @param tipo
	 */
	public boolean adicionarServicoDisponivel(String designacao, String tipo) {
		// TODO - implement GesServicosFacade.adicionarServicoDisponivel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param designacao
	 */
	public boolean removerServicoDisponivel(String designacao) {
		// TODO - implement GesServicosFacade.removerServicoDisponivel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 * @param designacaoServicos
	 */
	public List<Integer> agendarServicos(String matricula, List<String> designacaoServicos) {
		// TODO - implement GesServicosFacade.agendarServicos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean veiculoTemServicosPendentes(String matricula) {
		// TODO - implement GesServicosFacade.veiculoTemServicosPendentes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean veiculoTemServicosConcluidos(String matricula) {
		// TODO - implement GesServicosFacade.veiculoTemServicosConcluidos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrMarcacao
	 */
	public void concluirServico(int nrMarcacao) {
		// TODO - implement GesServicosFacade.concluirServico
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param servicos
	 */
	public LocalDateTime calcularHoraConclusao(List<Integer> servicos) {
		// TODO - implement GesServicosFacade.calcularHoraConclusao
		throw new UnsupportedOperationException();
	}

}