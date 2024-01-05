import java.time.LocalDateTime;

public class GesEstacaoFacade implements IGesEstacao {

	private PostoTrabalhoDAO postosTrabalho;
	private LocalDateTime abertura;
	private LocalDateTime fecho;
	private int nrTotalPostos;

	/**
	 * 
	 * @param nrPosto
	 * @param tipoPosto
	 */
	public boolean verificaTipo(int nrPosto, String tipoPosto) {
		// TODO - implement GesEstacaoFacade.verificaTipo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tipoPosto
	 */
	public void adicionarPostoTrabalho(String tipoPosto) {
		// TODO - implement GesEstacaoFacade.adicionarPostoTrabalho
		throw new UnsupportedOperationException();
	}

	public LocalDateTime getAbertura() {
		// TODO - implement GesEstacaoFacade.getAbertura
		throw new UnsupportedOperationException();
	}

	public LocalDateTime getFecho() {
		// TODO - implement GesEstacaoFacade.getFecho
		throw new UnsupportedOperationException();
	}

}