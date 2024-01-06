package ESIdealLN.Estacao;

public class PostoEletrico extends PostoTrabalho {
	public PostoEletrico(int nrPosto) {
		super(nrPosto);
	}

	public String getTipo() {
		return "eletrico";
	}
}