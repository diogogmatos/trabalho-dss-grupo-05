package ESIdealLN.Estacao;

import java.time.LocalTime;

public interface IGesEstacao {
    /**
     * @param nrPosto
     * @param tipoPosto
     * @return
     */
    public boolean verificaTipo(int nrPosto, String tipoPosto);

    /**
     * @param tipoPosto
     */
    public void adicionarPostoTrabalho(String tipoPosto);

    public boolean validaPostoTrabalho(int nrPosto);

    public LocalTime getAbertura();

    public LocalTime getFecho();

    /**
     * @param abertura
     */
    void definirAbertura(LocalTime abertura);

    /**
     * @param fecho
     */
    void definirFecho(LocalTime fecho);
}