package ESIdealLN.Admin;

import ESIdealLN.Estacao.PostoTrabalho;
import ESIdealLN.Funcionarios.Funcionario;
import ESIdealLN.Servicos.Servico;

import java.time.LocalTime;
import java.util.List;

public interface IGesAdmin {
	/**
	 * 
	 * @param palavraPasse
	 */
	boolean autenticarAdmin(String palavraPasse) throws Exception;

	/**
	 *
	 * @param novaPalavraPasse
	 */
	void alterarPalavraPasse(String novaPalavraPasse) throws Exception;
}