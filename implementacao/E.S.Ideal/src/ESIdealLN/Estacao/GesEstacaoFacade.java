package ESIdealLN.Estacao;

import ESIdealDL.PostoTrabalhoDAO;

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
		// TODO - implement ESIdealLN.Estacao.GesEstacaoFacade.verificaTipo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tipoPosto
	 */
	public void adicionarPostoTrabalho(String tipoPosto) {
		// TODO - implement ESIdealLN.Estacao.GesEstacaoFacade.adicionarPostoTrabalho
		throw new UnsupportedOperationException();
	}

	public LocalDateTime getAbertura() {
		// TODO - implement ESIdealLN.Estacao.GesEstacaoFacade.getAbertura
		throw new UnsupportedOperationException();
	}

	public LocalDateTime getFecho() {
		// TODO - implement ESIdealLN.Estacao.GesEstacaoFacade.getFecho
		throw new UnsupportedOperationException();
	}

}