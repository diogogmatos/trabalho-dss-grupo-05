package ESIdealLN.Servicos;

public class ServicoGasoleo extends Servico {
	public ServicoGasoleo(int id, String designacao, int tempoNecessario) {
		super(id, designacao, tempoNecessario);
	}

	public String getTipo() {
		return "gasoleo";
	}
}