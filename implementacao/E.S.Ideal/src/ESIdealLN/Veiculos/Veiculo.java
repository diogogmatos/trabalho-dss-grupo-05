package ESIdealLN.Veiculos;

import java.util.List;

public abstract class Veiculo {

	private String matricula;
	private String nifCliente;

	public Veiculo(String matricula, String nifCliente) {
		this.matricula = matricula;
		this.nifCliente = nifCliente;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public String getNifCliente() {
		return this.nifCliente;
	}

	public abstract String getTipoMotor();

	/**
	 * 
	 * @param tipoServico
	 */
	public boolean validarCompatibilidade(String tipoServico) {
		return obterTipoServicosCompativeis().contains(tipoServico);
	}

	public abstract List<String> obterTipoServicosCompativeis();

	public String toString() {
		return """
				Veículo %s
					NIF Cliente: %s
					Tipo de Motor: %s
					Serviços compatíveis: %s
				""".formatted(matricula, nifCliente, getTipoMotor(), obterTipoServicosCompativeis());
	}
}