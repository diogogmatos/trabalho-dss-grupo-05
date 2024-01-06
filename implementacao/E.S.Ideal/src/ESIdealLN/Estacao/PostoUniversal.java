package ESIdealLN.Estacao;

public class PostoUniversal extends PostoTrabalho {
	public PostoUniversal(int nrPosto) {
		super(nrPosto);
	}

	public String getTipo() {
		return "universal";
	}
}