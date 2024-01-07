package ESIdealLN.Veiculos;

import java.util.List;

public class VeiculoGasolina extends Veiculo {
	public VeiculoGasolina(String matricula, String nifCliente) {
		super(matricula, nifCliente);
	}

	public String getTipoMotor() {
		return "gasolina";
	}

	/**
	 * 
	 * @param tipoServico
	 */

	public List<String> obterTipoServicosCompativeis() {
		return List.of("universal", "combustao", "gasolina");
	}
}