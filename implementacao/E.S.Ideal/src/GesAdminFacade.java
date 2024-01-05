import java.time.LocalDateTime;
import java.util.List;

public class GesAdminFacade implements IGesAdmin {

	private String palavraPasseMestra;

	/**
	 * 
	 * @param palavraPasse
	 */
	public boolean autenticarAdmin(String palavraPasse) {
		// TODO - implement GesAdminFacade.autenticarAdmin
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param palavraPasse
	 * @param novaPalavraPasse
	 */
	public void alterarPalavraPasse(String palavraPasse, String novaPalavraPasse) {
		// TODO - implement GesAdminFacade.alterarPalavraPasse
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param abertura
	 * @param fecho
	 * @param postosTrabalho
	 * @param servicosDisponiveis
	 * @param funcionarios
	 */
	public void configurarSistema(LocalDateTime abertura, LocalDateTime fecho, List<PostoTrabalho> postosTrabalho, List<Servico> servicosDisponiveis, List<Funcionario> funcionarios) {
		// TODO - implement GesAdminFacade.configurarSistema
		throw new UnsupportedOperationException();
	}

}