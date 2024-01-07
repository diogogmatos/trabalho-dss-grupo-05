package ESIdealLN.Veiculos;

import java.util.List;

public class VeiculoHibridoGasolina extends Veiculo {
	public VeiculoHibridoGasolina(String matricula, String nifCliente) {
		super(matricula, nifCliente);
	}

	public String getTipoMotor() {
		return "hibridogla";
	}

	/**
	 * 
	 * @param tipoServico
	 */

	public List<String> obterTipoServicosCompativeis() {
		return List.of("universal", "combustao", "gasolina", "eletrico");
	}
}