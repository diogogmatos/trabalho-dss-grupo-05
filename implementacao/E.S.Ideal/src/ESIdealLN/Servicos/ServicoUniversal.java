package ESIdealLN.Servicos;

public class ServicoUniversal extends Servico {
	public ServicoUniversal(int id, String designacao, int tempoNecessario) {
		super(id, designacao, tempoNecessario);
	}

	public String getTipo() {
		return "universal";
	}
}