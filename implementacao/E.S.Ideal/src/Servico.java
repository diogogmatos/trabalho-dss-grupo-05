public abstract class Servico {

	private int id;
	private String designacao;
	private int tempoNecessario;

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

}