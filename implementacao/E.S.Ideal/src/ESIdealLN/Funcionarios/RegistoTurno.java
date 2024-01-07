package ESIdealLN.Funcionarios;

import java.time.LocalDateTime;

public class RegistoTurno {

	private int nrTurno;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private int funcionario;

	public RegistoTurno(int nrTurno, LocalDateTime inicio, LocalDateTime fim, int funcionario) {
		this.nrTurno = nrTurno;
		this.inicio = inicio;
		this.fim = fim;
		this.funcionario = funcionario;
	}

	public int getNrTurno() {
		return this.nrTurno;
	}

	public int getFuncionario() {
		return this.funcionario;
	}

	public LocalDateTime getInicio() {
		return this.inicio;
	}

	public LocalDateTime getFim() {
		return this.fim;
	}

	public String toString() {
		return """
				Turno Número: %d
					- Inicio: %s
					- Fim: %s
					- Funcionario: %d
				""".formatted(nrTurno, inicio, fim, funcionario);
	}
}