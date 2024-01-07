package ESIdealLN.Estacao;

import java.time.LocalTime;
import java.util.List;

public interface IGesEstacao {
    /**
     * @param nrPosto
     * @param tipoPosto
     * @return
     */
    public boolean verificaTipo(int nrPosto, String tipoPosto) throws Exception;

    /**
     * @param tipoPosto
     */
    public void adicionarPostoTrabalho(String tipoPosto) throws Exception;

    public List<PostoTrabalho> getPostosTrabalho() throws Exception;

    public boolean validaPostoTrabalho(int nrPosto) throws Exception;

    public LocalTime getAbertura() throws Exception;

    public LocalTime getFecho() throws Exception;

    /**
     * @param abertura
     */
    void definirAbertura(LocalTime abertura) throws Exception;

    /**
     * @param fecho
     */
    void definirFecho(LocalTime fecho) throws Exception;
}