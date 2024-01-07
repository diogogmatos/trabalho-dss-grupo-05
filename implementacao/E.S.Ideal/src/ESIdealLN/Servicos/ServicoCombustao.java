package ESIdealLN.Servicos;

public class ServicoCombustao extends Servico {
	public ServicoCombustao(int id, String designacao, int tempoNecessario) {
		super(id, designacao, tempoNecessario);
	}

	public String getTipo() {
		return "combustao";
	}
}