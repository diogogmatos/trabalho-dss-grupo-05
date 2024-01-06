package ESIdealLN.Estacao;

public class PostoGasoleo extends PostoTrabalho {
	public PostoGasoleo(int nrPosto) {
		super(nrPosto);
	}

	public String getTipo() {
		return "gasoleo";
	}
}