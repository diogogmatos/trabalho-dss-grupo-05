package ESIdealLN.Funcionarios;

import java.util.List;

public class Funcionario {

	private int nrCartao;
	private List<String> competencias;

	public Funcionario(int nrCartao, List<String> competencias) {
		this.nrCartao = nrCartao;
		this.competencias = competencias;
	}

	public int getNrCartao() {
		return this.nrCartao;
	}

	public List<String> getCompetencias() {
		return this.competencias;
	}

	/**
	 * 
	 * @param nrPosto
	 */
	public boolean verificaCompetencia(int nrPosto) {
		// TODO - implement ESIdealLN.Funcionarios.Funcionario.verificaCompetencia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param competencia
	 */
	public void adicionarCompetencia(String competencia) {
		// TODO - implement ESIdealLN.Funcionarios.Funcionario.adicionarCompetencia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param competencia
	 */
	public void removerCompetencia(String competencia) {
		// TODO - implement ESIdealLN.Funcionarios.Funcionario.removerCompetencia
		throw new UnsupportedOperationException();
	}

	public String toString() {
		return """
				Funcionário %d
					Competências: %s
				""".formatted(nrCartao, competencias);
	}
}