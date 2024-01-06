package ESIdealLN.Veiculos;

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
	public boolean validarCompatibilidade(String tipoServico) {
		return switch (tipoServico) {
			case "universal", "combustao", "gasoleo" -> true;
			default -> false;
		};
	}
}