package ESIdealLN.Funcionarios;

import java.time.LocalDateTime;

public class RegistoServico {
	private int nrMarcacao;
	private LocalDateTime inicio;
	private LocalDateTime fim;

	public RegistoServico(int nrMarcacao, LocalDateTime inicio, LocalDateTime fim) {
		this.nrMarcacao = nrMarcacao;
		this.inicio = inicio;
		this.fim = fim;
	}

	public String toString() {
		return """
				Marcação Número: %d
					- Inicio: %s
					- Fim: %s
				""".formatted(nrMarcacao, inicio, fim);
	}
}