package ESIdealLN.Clientes;

public class Cliente {

	private String nome;
	private String nif;
	private String morada;
	private String telefone;
	private String email;
	private boolean notSMS;
	private boolean notEmail;

	public Cliente(String nome, String nif, String morada, String telefone, String email, boolean notSMS, boolean notEmail) {
		this.nome = nome;
		this.nif = nif;
		this.morada = morada;
		this.telefone = telefone;
		this.email = email;
		this.notSMS = notSMS;
		this.notEmail = notEmail;
	}

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

	public String toString() {
		return """
				NIF: %s
					Nome: %s
					Morada: %s
					Telefone: %s
					Email: %s
					Notificações por SMS: %s
					Notificações por email: %s
				""".formatted(nif, nome, morada, telefone, email, notSMS ? "Sim" : "Não", notEmail ? "Sim" : "Não");
	}
}