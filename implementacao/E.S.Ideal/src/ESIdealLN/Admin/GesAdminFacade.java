package ESIdealLN.Admin;

import ESIdealLN.Estacao.PostoTrabalho;
import ESIdealLN.Funcionarios.Funcionario;
import ESIdealLN.Servicos.Servico;

import java.time.LocalDateTime;
import java.util.List;

public class GesAdminFacade implements IGesAdmin {

	private String palavraPasseMestra;

	/**
	 * 
	 * @param palavraPasse
	 */
	public boolean autenticarAdmin(String palavraPasse) {
		// TODO - implement ESIdealLN.Admin.GesAdminFacade.autenticarAdmin
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param palavraPasse
	 * @param novaPalavraPasse
	 */
	public void alterarPalavraPasse(String palavraPasse, String novaPalavraPasse) {
		// TODO - implement ESIdealLN.Admin.GesAdminFacade.alterarPalavraPasse
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
		// TODO - implement ESIdealLN.Admin.GesAdminFacade.configurarSistema
		throw new UnsupportedOperationException();
	}

}