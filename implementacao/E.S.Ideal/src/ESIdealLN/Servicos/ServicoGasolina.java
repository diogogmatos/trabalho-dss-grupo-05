package ESIdealLN.Servicos;

public class ServicoGasolina extends Servico {
	public ServicoGasolina(int id, String designacao, int tempoNecessario) {
		super(id, designacao, tempoNecessario);
	}

	public String getTipo() {
		return "gasolina";
	}
}