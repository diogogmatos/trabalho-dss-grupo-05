import java.util.List;

public class GesFuncionariosFacade implements IGesFuncionarios {

	private FuncionarioDAO funcionarios;
	private int nrTotalFuncionarios;
	private int nrTotalTurnos;

	/**
	 * 
	 * @param competencias
	 */
	public void registarFuncionario(List<String> competencias) {
		// TODO - implement GesFuncionariosFacade.registarFuncionario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public boolean removerFuncionario(int nrCartao) {
		// TODO - implement GesFuncionariosFacade.removerFuncionario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 * @param nrPosto
	 */
	public boolean autenticarFuncionario(int nrCartao, int nrPosto) {
		// TODO - implement GesFuncionariosFacade.autenticarFuncionario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param competencias
	 */
	public void adicionarCompetencias(List<String> competencias) {
		// TODO - implement GesFuncionariosFacade.adicionarCompetencias
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param competencias
	 */
	public void removerCompetencias(List<String> competencias) {
		// TODO - implement GesFuncionariosFacade.removerCompetencias
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public void iniciarTurno(int nrCartao) {
		// TODO - implement GesFuncionariosFacade.iniciarTurno
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 * @param nrTurno
	 */
	public void terminarTurno(int nrCartao, int nrTurno) {
		// TODO - implement GesFuncionariosFacade.terminarTurno
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 * @param nrMarcacao
	 */
	public void iniciarServico(int nrCartao, int nrMarcacao) {
		// TODO - implement GesFuncionariosFacade.iniciarServico
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 * @param nrMarcacao
	 */
	public void terminarServico(int nrCartao, int nrMarcacao) {
		// TODO - implement GesFuncionariosFacade.terminarServico
		throw new UnsupportedOperationException();
	}

	public RegistoTurnoDAO getTurnos() {
		// TODO - implement GesFuncionariosFacade.getTurnos
		throw new UnsupportedOperationException();
	}

	public RegistoServicoDAO getServicosEfetuados() {
		// TODO - implement GesFuncionariosFacade.getServicosEfetuados
		throw new UnsupportedOperationException();
	}

}