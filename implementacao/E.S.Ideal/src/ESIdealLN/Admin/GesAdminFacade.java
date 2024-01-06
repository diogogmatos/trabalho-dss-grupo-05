package ESIdealLN.Admin;

import ESIdealLN.Estacao.PostoTrabalho;
import ESIdealLN.Funcionarios.Funcionario;
import ESIdealLN.Servicos.Servico;

import java.time.LocalTime;
import java.util.List;

public class GesAdminFacade implements IGesAdmin {

	private String palavraPasseMestra;

	public GesAdminFacade(String palavraPasseMestra) {
		this.palavraPasseMestra = palavraPasseMestra;
	}

	/**
	 *
	 * @param palavraPasse
	 */
	public boolean autenticarAdmin(String palavraPasse) {
		if (palavraPasse.equals(palavraPasseMestra))
			return true;
        return false;
    }

	/**
	 * 
	 * @param palavraPasse
	 * @param novaPalavraPasse
	 */
	public void alterarPalavraPasse(String novaPalavraPasse) {
		palavraPasseMestra = novaPalavraPasse;
	}

	/**
	 * 
	 * @param abertura
	 * @param fecho
	 * @param postosTrabalho
	 * @param servicosDisponiveis
	 * @param funcionarios
	 */
	public void configurarSistema(LocalTime abertura, LocalTime fecho, List<PostoTrabalho> postosTrabalho, List<Servico> servicosDisponiveis, List<Funcionario> funcionarios) {
		// TODO - implement ESIdealLN.Admin.GesAdminFacade.configurarSistema
		throw new UnsupportedOperationException();
	}

}