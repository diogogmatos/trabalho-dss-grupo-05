package ESIdealLN.Admin;

import ESIdealDL.AdminDAO;
import ESIdealLN.Estacao.PostoTrabalho;
import ESIdealLN.Funcionarios.Funcionario;
import ESIdealLN.Servicos.Servico;

import java.time.LocalTime;
import java.util.List;

public class GesAdminFacade implements IGesAdmin {

	private final AdminDAO admin;

	public GesAdminFacade(String palavraPasseMestra) {
		this.admin = new AdminDAO();
	}

	/**
	 *
	 * @param palavraPasse
	 */
	public boolean autenticarAdmin(String palavraPasse) throws Exception {
        return palavraPasse.equals(admin.getPasswordMestra());
    }

	/**
	 *
	 * @param novaPalavraPasse
	 */
	public void alterarPalavraPasse(String novaPalavraPasse) throws Exception {
		admin.definirPassowordMestra(novaPalavraPasse);
	}
}