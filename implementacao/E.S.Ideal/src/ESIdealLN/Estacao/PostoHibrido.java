package ESIdealLN.Estacao;

public class PostoHibrido extends PostoTrabalho {
	public PostoHibrido(int nrPosto) {
		super(nrPosto);
	}

	public String getTipo() {
		return "hibrido";
	}
}