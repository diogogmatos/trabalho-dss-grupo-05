package ESIdealLN.Servicos;

public class ServicoEletrico extends Servico {
	public ServicoEletrico(int id, String designacao, int tempoNecessario) {
		super(id, designacao, tempoNecessario);
	}

	public String getTipo() {
		return "eletrico";
	}
}