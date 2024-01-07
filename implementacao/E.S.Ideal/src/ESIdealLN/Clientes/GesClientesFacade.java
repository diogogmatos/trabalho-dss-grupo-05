package ESIdealLN.Clientes;

import ESIdealDL.ClienteDAO;

import java.util.List;

public class GesClientesFacade implements IGesClientes {

	private final ClienteDAO clientes;

	public GesClientesFacade() {
		this.clientes = new ClienteDAO();
	}

	/**
	 * 
	 * @param nome
	 * @param nif
	 * @param morada
	 * @param telefone
	 * @param email
	 */
	private boolean validaDados(String nome, String nif, String morada, String telefone, String email) throws Exception {
		boolean valid = true;

		if (nif.length() == 9 && telefone.length() == 12 && email.contains("@") && email.contains(".") && !clientes.existeCliente(nif)) {
			String validChars = "1234567890";
			for (int i = 0; i < nif.length(); i++) {
				if (!validChars.contains(nif.substring(i, i + 1))) {
					valid = false;
					break;
				}
			}
			for (int i = 0; i < telefone.length(); i++) {
				if (!validChars.contains(telefone.substring(i, i + 1))) {
					valid = false;
					break;
				}
			}
		}
		else
			valid = false;

		return valid;
	}

	/**
	 * 
	 * @param nome
	 * @param nif
	 * @param morada
	 * @param telefone
	 * @param email
	 */
	public void registarCliente(String nome, String nif, String morada, String telefone, String email) throws Exception {
		boolean valid = validaDados(nome, nif, morada, telefone, email);
		if (valid)
			clientes.adicionarCliente(nome, nif, morada, telefone, email);
		else
			throw new Exception("Dados inválidos!");
	}

	/**
	 * 
	 * @param nif
	 */
	public boolean verificarRegistoCliente(String nif) throws Exception {
		return clientes.existeCliente(nif);
	}

	/**
	 * 
	 * @param nif
	 * @param sms
	 * @param email
	 */
	public void registarPreferenciaNotificacao(String nif, boolean sms, boolean email) throws Exception {
		clientes.registarPreferenciaNotificacao(nif, sms, email);
	}

	public List<Cliente> getClientes() throws Exception {
		return clientes.getClientes();
	}
}