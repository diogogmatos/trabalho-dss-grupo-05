package ESIdealLN.Veiculos;

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
	public boolean validarCompatibilidade(String tipoServico) {
		return switch (tipoServico) {
			case "universal", "combustao", "gasolina", "eletrico", "hibrido" -> true;
			default -> false;
		};
	}
}