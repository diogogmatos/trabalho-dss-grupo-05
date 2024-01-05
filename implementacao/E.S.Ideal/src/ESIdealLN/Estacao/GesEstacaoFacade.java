package ESIdealLN.Estacao;

import ESIdealDL.PostoTrabalhoDAO;

import java.time.LocalTime;

public class GesEstacaoFacade implements IGesEstacao {

	private PostoTrabalhoDAO postosTrabalho;
	private LocalTime abertura;
	private LocalTime fecho;
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

	public LocalTime getAbertura() {
		// TODO - implement ESIdealLN.Estacao.GesEstacaoFacade.getAbertura
		throw new UnsupportedOperationException();
	}

	public LocalTime getFecho() {
		// TODO - implement ESIdealLN.Estacao.GesEstacaoFacade.getFecho
		throw new UnsupportedOperationException();
	}

	public void definirAbertura(LocalTime abertura) {
		// TODO - implement ESIdealLN.Estacao.GesEstacaoFacade.definirAbertura
		throw new UnsupportedOperationException();
	}

	public void definirFecho(LocalTime fecho) {
		// TODO - implement ESIdealLN.Estacao.GesEstacaoFacade.definirFecho
		throw new UnsupportedOperationException();
	}

}
