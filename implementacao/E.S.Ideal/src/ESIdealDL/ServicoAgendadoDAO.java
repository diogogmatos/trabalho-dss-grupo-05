package ESIdealDL;

import ESIdealLN.Servicos.ServicoAgendado;
import ESIdealLN.Servicos.ServicoAgendadoIncompleto;

import java.util.List;

public class ServicoAgendadoDAO {

	/**
	 * 
	 * @param idServico
	 * @param matricula
	 * @param nrCartaoFuncionario
	 */
	public int adicionarServicoPendente(int idServico, String matricula, int nrCartaoFuncionario) {
		// TODO - implement ESIdealDL.ServicoAgendadoDAO.adicionarServicoPendente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrMarcacao
	 */
	public void marcarComoConcluido(int nrMarcacao) {
		// TODO - implement ESIdealDL.ServicoAgendadoDAO.marcarComoConcluido
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrMarcacao
	 * @param motivo
	 */
	public void marcarComoIncompleto(int nrMarcacao, String motivo) {
		// TODO - implement ESIdealDL.ServicoAgendadoDAO.marcarComoIncompleto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartaoFuncionario
	 */
	public ServicoAgendado getServicoPendente(int nrCartaoFuncionario) {
		// TODO - implement ESIdealDL.ServicoAgendadoDAO.getServicoPendente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean existemServicosPendentesParaVeiculo(String matricula) {
		// TODO - implement ESIdealDL.ServicoAgendadoDAO.existemServicosPendentesParaVeiculo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean existemServicosConcluidosParaVeiculo(String matricula) {
		// TODO - implement ESIdealDL.ServicoAgendadoDAO.existemServicosConcluidosParaVeiculo
		throw new UnsupportedOperationException();
	}

	public List<ServicoAgendado> getServicosPendentes() {
		// TODO - implement ESIdealDL.ServicoAgendadoDAO.getServicosPendentes
		throw new UnsupportedOperationException();
	}

	public List<ServicoAgendado> getServicosConcluidos() {
		// TODO - implement ESIdealDL.ServicoAgendadoDAO.getServicosConcluidos
		throw new UnsupportedOperationException();
	}

	public List<ServicoAgendadoIncompleto> getServicosIncompletos() {
		// TODO - implement ESIdealDL.ServicoAgendadoDAO.getServicosIncompletos
		throw new UnsupportedOperationException();
	}

}