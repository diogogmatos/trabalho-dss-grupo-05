package ESIdealLN.Funcionarios;

import java.time.LocalDateTime;

public class RegistoTurno {

	private int nrTurno;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private int funcionario;

	/**
	 * 
	 * @param nrMarcacao
	 */
	public void iniciarServico(int nrMarcacao) {
		// TODO - implement ESIdealLN.Funcionarios.RegistoTurno.iniciarServico
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrMarcacao
	 */
	public void terminarServico(int nrMarcacao) {
		// TODO - implement ESIdealLN.Funcionarios.RegistoTurno.terminarServico
		throw new UnsupportedOperationException();
	}

	public int getNrTurno() {
		return this.nrTurno;
	}

	public int getFuncionario() {
		return this.funcionario;
	}

}