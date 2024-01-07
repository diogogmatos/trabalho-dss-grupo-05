package ESIdealLN.Veiculos;

import java.util.List;

public class VeiculoGasoleo extends Veiculo {
	public VeiculoGasoleo(String matricula, String nifCliente) {
		super(matricula, nifCliente);
	}

	public String getTipoMotor() {
		return "gasoleo";
	}

	/**
	 * 
	 * @param tipoServico
	 */

	public List<String> obterTipoServicosCompativeis() {
		return List.of("universal", "combustao", "gasoleo");
	}
}