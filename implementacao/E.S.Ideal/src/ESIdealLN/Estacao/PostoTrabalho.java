package ESIdealLN.Estacao;

public abstract class PostoTrabalho {

	private int nrPosto;

	public int getNrPosto() {
		return this.nrPosto;
	}

	public abstract String getTipo();

}