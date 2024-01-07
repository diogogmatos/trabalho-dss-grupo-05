package ESIdealLN.Funcionarios;

import ESIdealDL.FuncionarioDAO;
import ESIdealDL.RegistoServicoDAO;
import ESIdealDL.RegistoTurnoDAO;

import java.util.List;

public class GesFuncionariosFacade implements IGesFuncionarios {

	private final RegistoTurnoDAO turnos;
	private final RegistoServicoDAO servicosEfetuados;
	private final FuncionarioDAO funcionarios;

	public GesFuncionariosFacade() {
		this.turnos = new RegistoTurnoDAO();
		this.servicosEfetuados = new RegistoServicoDAO();
		this.funcionarios = new FuncionarioDAO();
	}

	/**
	 * 
	 * @param competencias
	 */
	public void registarFuncionario(List<String> competencias) throws Exception {
		funcionarios.adicionarFuncionario(competencias);
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public void removerFuncionario(int nrCartao) throws Exception {
		funcionarios.removerFuncionario(nrCartao);
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public boolean validaFuncionario(int nrCartao) throws Exception {
		return funcionarios.existeFuncionario(nrCartao);
	}

	/**
	 * 
	 * @param competencias
	 */
	public void adicionarCompetencias(int nrCartao, List<String> competencias) throws Exception {
		for (String competencia : competencias) {
			funcionarios.adicionarCompetencia(nrCartao, competencia);
		}
	}

	/**
	 * 
	 * @param competencias
	 */
	public void removerCompetencias(int nrCartao, List<String> competencias) throws Exception {
		for (String competencia : competencias) {
			funcionarios.removerCompetencia(nrCartao, competencia);
		}
	}

	/**
	 *
	 * @param nrCartao
	 */
	public List<String> getCompetencias(int nrCartao) throws Exception {
		return funcionarios.getFuncionario(nrCartao).getCompetencias();
	}

	/**
	 *
	 * @param competencia
	 */
	public List<Integer> getFuncionariosComCompetencia(String competencia) throws Exception {
		return funcionarios.funcionariosComCompetencia(competencia);
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public int iniciarTurno(int nrCartao) throws Exception {
		return turnos.iniciarTurno(nrCartao);
	}

	/**
	 *
	 * @param nrTurno
	 */
	public void terminarTurno(int nrTurno) throws Exception {
		turnos.terminarTurno(nrTurno);
	}

	/**
	 *
	 * @param nrTurno
	 * @param nrMarcacao
	 */
	public void iniciarServico(int nrTurno, int nrMarcacao) throws Exception {
		servicosEfetuados.iniciarServico(nrTurno, nrMarcacao);
	}

	/**
	 *
	 * @param nrMarcacao
	 */
	public void terminarServico(int nrMarcacao) throws Exception {
		servicosEfetuados.terminarServico(nrMarcacao);
	}

	public List<Funcionario> getFuncionarios() throws Exception {
		return funcionarios.getFuncionarios();
	}

	public List<RegistoTurno> getTurnos() throws Exception {
		return turnos.getTurnos();
	}

	public List<RegistoServico> getRegistoServicos() throws Exception {
		return servicosEfetuados.getServicos();
	}
}