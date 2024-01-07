package ESIdealLN.Veiculos;

import java.util.List;

public class VeiculoEletrico extends Veiculo {
	public VeiculoEletrico(String matricula, String nifCliente) {
		super(matricula, nifCliente);
	}

	public String getTipoMotor() {
		return "eletrico";
	}

	/**
	 * 
	 * @param tipoServico
	 */

	public List<String> obterTipoServicosCompativeis() {
		return List.of("universal", "eletrico");
	}
}