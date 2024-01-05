public class GesClientesFacade implements IGesClientes {

	private ClienteDAO clientes;

	/**
	 * 
	 * @param nome
	 * @param nif
	 * @param morada
	 * @param telefone
	 * @param email
	 */
	private boolean validaDados(String nome, String nif, String morada, String telefone, String email) {
		// TODO - implement GesClientesFacade.validaDados
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nif
	 */
	private void enviarSms(String nif) {
		// TODO - implement GesClientesFacade.enviarSms
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nif
	 */
	private void enviarEmail(String nif) {
		// TODO - implement GesClientesFacade.enviarEmail
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nome
	 * @param nif
	 * @param morada
	 * @param telefone
	 * @param email
	 */
	public void registarCliente(String nome, String nif, String morada, String telefone, String email) {
		// TODO - implement GesClientesFacade.registarCliente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nif
	 */
	public boolean verificarRegistoCliente(String nif) {
		// TODO - implement GesClientesFacade.verificarRegistoCliente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nif
	 * @param mensagem
	 */
	public boolean notificarCliente(String nif, String mensagem) {
		// TODO - implement GesClientesFacade.notificarCliente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nif
	 * @param sms
	 * @param email
	 */
	public void registarPreferenciaNotificacao(String nif, boolean sms, boolean email) {
		// TODO - implement GesClientesFacade.registarPreferenciaNotificacao
		throw new UnsupportedOperationException();
	}

}