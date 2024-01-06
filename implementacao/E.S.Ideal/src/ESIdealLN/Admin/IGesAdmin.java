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
	boolean autenticarAdmin(String palavraPasse);

	/**
	 * 
	 * @param palavraPasse
	 * @param novaPalavraPasse
	 */
	void alterarPalavraPasse(String novaPalavraPasse);

	/**
	 * 
	 * @param abertura
	 * @param fecho
	 * @param postosTrabalho
	 * @param servicosDisponiveis
	 * @param funcionarios
	 */
	void configurarSistema(LocalTime abertura, LocalTime fecho, List<PostoTrabalho> postosTrabalho, List<Servico> servicosDisponiveis, List<Funcionario> funcionarios);

}