package ESIdealLN.Servicos;

public class ServicoAgendadoIncompleto extends ServicoAgendado {
	private String motivo;

	public ServicoAgendadoIncompleto(int idServico, int nrMarcacao, String matricula, int funcionarioAtribuido, String motivo) {
		super(idServico, nrMarcacao, matricula, funcionarioAtribuido);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return this.motivo;
	}

	@Override
	public String toString() {
		return """
				Marcação Número: %d
					- Matricula Veiculo: %s
					- Funcionario Atribuido: %s
					- Motivo de Insucesso: %s
				""".formatted(super.getNrMarcacao(), super.getMatricula(), super.getFuncionario(), motivo);
	}
}