package ESIdealLN.Clientes;

public interface IGesClientes {
    /**
     *
     * @param nome
     * @param nif
     * @param morada
     * @param telefone
     * @param email
     */
    public void registarCliente(String nome, String nif, String morada, String telefone, String email);

    /**
     *
     * @param nif
     */
    public boolean verificarRegistoCliente(String nif);

    /**
     *
     * @param nif
     * @param mensagem
     */
    public boolean notificarCliente(String nif, String mensagem);

    /**
     *
     * @param nif
     * @param sms
     * @param email
     */
    public void registarPreferenciaNotificacao(String nif, boolean sms, boolean email);
}