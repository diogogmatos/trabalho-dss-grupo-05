package ESIdealLN.Funcionarios;

import ESIdealDL.FuncionarioDAO;
import ESIdealDL.RegistoServicoDAO;
import ESIdealDL.RegistoTurnoDAO;

import java.util.List;

public class GesFuncionariosFacade implements IGesFuncionarios {

	private FuncionarioDAO funcionarios;

	/**
	 * 
	 * @param competencias
	 */
	public void registarFuncionario(List<String> competencias) {
		// TODO - implement ESIdealLN.Funcionarios.GesFuncionariosFacade.registarFuncionario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public boolean removerFuncionario(int nrCartao) {
		// TODO - implement ESIdealLN.Funcionarios.GesFuncionariosFacade.removerFuncionario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 * @param nrPosto
	 */
	public boolean autenticarFuncionario(int nrCartao, int nrPosto) {
		// TODO - implement ESIdealLN.Funcionarios.GesFuncionariosFacade.autenticarFuncionario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param competencias
	 */
	public void adicionarCompetencias(List<String> competencias) {
		// TODO - implement ESIdealLN.Funcionarios.GesFuncionariosFacade.adicionarCompetencias
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param competencias
	 */
	public void removerCompetencias(List<String> competencias) {
		// TODO - implement ESIdealLN.Funcionarios.GesFuncionariosFacade.removerCompetencias
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public void iniciarTurno(int nrCartao) {
		// TODO - implement ESIdealLN.Funcionarios.GesFuncionariosFacade.iniciarTurno
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 * @param nrTurno
	 */
	public void terminarTurno(int nrCartao, int nrTurno) {
		// TODO - implement ESIdealLN.Funcionarios.GesFuncionariosFacade.terminarTurno
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 * @param nrMarcacao
	 */
	public void iniciarServico(int nrCartao, int nrMarcacao) {
		// TODO - implement ESIdealLN.Funcionarios.GesFuncionariosFacade.iniciarServico
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrCartao
	 * @param nrMarcacao
	 */
	public void terminarServico(int nrCartao, int nrMarcacao) {
		// TODO - implement ESIdealLN.Funcionarios.GesFuncionariosFacade.terminarServico
		throw new UnsupportedOperationException();
	}

	public RegistoTurnoDAO getTurnos() {
		// TODO - implement ESIdealLN.Funcionarios.GesFuncionariosFacade.getTurnos
		throw new UnsupportedOperationException();
	}

	public RegistoServicoDAO getServicosEfetuados() {
		// TODO - implement ESIdealLN.Funcionarios.GesFuncionariosFacade.getServicosEfetuados
		throw new UnsupportedOperationException();
	}

}