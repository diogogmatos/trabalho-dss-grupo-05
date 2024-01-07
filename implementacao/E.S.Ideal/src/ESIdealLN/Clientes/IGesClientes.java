package ESIdealLN.Clientes;

import java.util.List;

public interface IGesClientes {
    /**
     *
     * @param nome
     * @param nif
     * @param morada
     * @param telefone
     * @param email
     */
    public void registarCliente(String nome, String nif, String morada, String telefone, String email) throws Exception;

    /**
     *
     * @param nif
     */
    public boolean verificarRegistoCliente(String nif) throws Exception;

    /**
     *
     * @param nif
     * @param sms
     * @param email
     */
    public void registarPreferenciaNotificacao(String nif, boolean sms, boolean email) throws Exception;

    public List<Cliente> getClientes() throws Exception;
}