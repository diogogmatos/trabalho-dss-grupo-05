package ESIdealLN.Servicos;

public class ServicoAgendado {

	private int idServico;
	private int nrMarcacao;
	private String matricula;
	private int funcionarioAtribuido;

	public ServicoAgendado(int idServico, int nrMarcacao, String matricula, int funcionarioAtribuido) {
		this.idServico = idServico;
		this.nrMarcacao = nrMarcacao;
		this.matricula = matricula;
		this.funcionarioAtribuido = funcionarioAtribuido;
	}

	public int getIdServico() {
		return this.idServico;
	}

	public int getNrMarcacao() {
		return this.nrMarcacao;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public int getFuncionario() {
		return this.funcionarioAtribuido;
	}

	@Override
	public String toString() {
		return """
				Marcação Número: %d
					- Matricula Veiculo: %s
					- Funcionario Atribuido: %s
				""".formatted(nrMarcacao, matricula, funcionarioAtribuido);
	}
}