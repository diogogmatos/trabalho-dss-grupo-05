package ESIdealLN.Estacao;

public class PostoCombustao extends PostoTrabalho {
	public PostoCombustao(int nrPosto) {
		super(nrPosto);
	}

	public String getTipo() {
		return "combustao";
	}
}