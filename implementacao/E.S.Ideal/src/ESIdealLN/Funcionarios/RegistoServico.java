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
}