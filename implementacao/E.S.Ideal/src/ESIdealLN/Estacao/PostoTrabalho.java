package ESIdealLN.Estacao;

public abstract class PostoTrabalho {
	private int nrPosto;

	public PostoTrabalho(int nrPosto) {
		this.nrPosto = nrPosto;
	}

	public int getNrPosto() {
		return this.nrPosto;
	}

	public abstract String getTipo();

}