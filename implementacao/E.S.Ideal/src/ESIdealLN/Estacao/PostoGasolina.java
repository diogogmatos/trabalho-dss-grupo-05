package ESIdealLN.Estacao;

public class PostoGasolina extends PostoTrabalho {
	public PostoGasolina(int nrPosto) {
		super(nrPosto);
	}

	public String getTipo() {
		return "gasolina";
	}
}