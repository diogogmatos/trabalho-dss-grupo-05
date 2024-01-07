package ESIdealLN.Servicos;

public abstract class Servico {
	private int id;
	private String designacao;
	private int tempoNecessario;

	public Servico(int id, String designacao, int tempoNecessario) {
		this.id = id;
		this.designacao = designacao;
		this.tempoNecessario = tempoNecessario;
	}

	public int getId() {
		return this.id;
	}

	public String getDesignacao() {
		return this.designacao;
	}

	public int getTempoNecessario() {
		return this.tempoNecessario;
	}

	public abstract String getTipo();

	@Override
	public String toString() {
		return """
				Designação: %s
					- Serviço Número: %d
					- Tempo Necessário Estimado: %d min
					- Tipo: %s
				""".formatted(designacao, id, tempoNecessario, getTipo());
	}
}