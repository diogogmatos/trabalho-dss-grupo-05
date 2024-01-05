import java.util.List;

public class ServicoAgendadoDAO {

	/**
	 * 
	 * @param idServico
	 * @param matricula
	 * @param nrCartaoFuncionario
	 */
	public int adicionarServicoPendente(int idServico, String matricula, int nrCartaoFuncionario) {
		// TODO - implement ServicoAgendadoDAO.adicionarServicoPendente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrMarcacao
	 */
	public void marcarComoConcluido(int nrMarcacao) {
		// TODO - implement ServicoAgendadoDAO.marcarComoConcluido
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrMarcacao
	 * @param motivo
	 */
	public void marcarComoIncompleto(int nrMarcacao, String motivo) {
		// TODO - implement ServicoAgendadoDAO.marcarComoIncompleto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartaoFuncionario
	 */
	public ServicoAgendado getServicoPendente(int nrCartaoFuncionario) {
		// TODO - implement ServicoAgendadoDAO.getServicoPendente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean existemServicosPendentesParaVeiculo(String matricula) {
		// TODO - implement ServicoAgendadoDAO.existemServicosPendentesParaVeiculo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean existemServicosConcluidosParaVeiculo(String matricula) {
		// TODO - implement ServicoAgendadoDAO.existemServicosConcluidosParaVeiculo
		throw new UnsupportedOperationException();
	}

	public List<ServicoAgendado> getServicosPendentes() {
		// TODO - implement ServicoAgendadoDAO.getServicosPendentes
		throw new UnsupportedOperationException();
	}

	public List<ServicoAgendado> getServicosConcluidos() {
		// TODO - implement ServicoAgendadoDAO.getServicosConcluidos
		throw new UnsupportedOperationException();
	}

	public List<ServicoAgendadoIncompleto> getServicosIncompletos() {
		// TODO - implement ServicoAgendadoDAO.getServicosIncompletos
		throw new UnsupportedOperationException();
	}

}