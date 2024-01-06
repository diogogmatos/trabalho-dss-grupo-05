package ESIdealLN.Veiculos;

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
	public boolean validarCompatibilidade(String tipoServico) {
		return switch (tipoServico) {
			case "universal", "eletrico" -> true;
            default -> false;
		};
	}
}