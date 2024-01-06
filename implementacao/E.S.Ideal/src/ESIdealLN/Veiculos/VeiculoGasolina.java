package ESIdealLN.Veiculos;

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
	public boolean validarCompatibilidade(String tipoServico) {
		return switch (tipoServico) {
			case "universal", "combustao", "gasolina" -> true;
			default -> false;
		};
	}
}