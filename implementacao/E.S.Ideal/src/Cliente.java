public class Cliente {

	private String nome;
	private String nif;
	private String morada;
	private String telefone;
	private String email;
	private boolean notSMS;
	private boolean notEmail;

	public String getNome() {
		return this.nome;
	}

	public String getNif() {
		return this.nif;
	}

	public String getMorada() {
		return this.morada;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public String getEmail() {
		return this.email;
	}

	public boolean getNotSMS() {
		return this.notSMS;
	}

	public boolean getNotEmail() {
		return this.notEmail;
	}

}