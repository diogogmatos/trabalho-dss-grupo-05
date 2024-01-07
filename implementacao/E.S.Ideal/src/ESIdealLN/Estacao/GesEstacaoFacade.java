package ESIdealLN.Estacao;

import ESIdealDL.EstacaoDAO;
import ESIdealDL.PostoTrabalhoDAO;

import java.time.LocalTime;
import java.util.List;

public class GesEstacaoFacade implements IGesEstacao {

	private final PostoTrabalhoDAO postosTrabalho;
	private final EstacaoDAO estacao;

	public GesEstacaoFacade() {
		this.postosTrabalho = new PostoTrabalhoDAO();
		this.estacao = new EstacaoDAO();
	}

	/**
	 * 
	 * @param nrPosto
	 * @param tipoPosto
	 */
	public boolean verificaTipo(int nrPosto, String tipoPosto) throws Exception {
		return postosTrabalho.getPostoTrabalho(nrPosto).getTipo().equals(tipoPosto);
	}

	/**
	 * 
	 * @param tipoPosto
	 */
	public void adicionarPostoTrabalho(String tipoPosto) throws Exception {
		postosTrabalho.adicionarPostoTrabalho(tipoPosto);
	}

	public List<PostoTrabalho> getPostosTrabalho() throws Exception {
		return postosTrabalho.getPostosTrabalho();
	}

	/**
	 *
	 * @param nrPosto
	 */
	public boolean validaPostoTrabalho(int nrPosto) throws Exception {
		return postosTrabalho.existePostoTrabalho(nrPosto);
	}

	public LocalTime getAbertura() throws Exception {
		return estacao.getAbertura();
	}

	public LocalTime getFecho() throws Exception {
		return estacao.getFecho();
	}

	public void definirAbertura(LocalTime abertura) throws Exception {
		estacao.definirAbertura(abertura);
	}

	public void definirFecho(LocalTime fecho) throws Exception {
		estacao.definirFecho(fecho);
	}
}
