public abstract class Veiculo {

	private String matricula;
	private String nifCliente;

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
	public abstract boolean validarCompatibilidade(String tipoServico);

}