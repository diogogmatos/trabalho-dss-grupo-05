import java.time.LocalDateTime;
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
	void alterarPalavraPasse(String palavraPasse, String novaPalavraPasse);

	/**
	 * 
	 * @param abertura
	 * @param fecho
	 * @param postosTrabalho
	 * @param servicosDisponiveis
	 * @param funcionarios
	 */
	void configurarSistema(LocalDateTime abertura, LocalDateTime fecho, List<PostoTrabalho> postosTrabalho, List<Servico> servicosDisponiveis, List<Funcionario> funcionarios);

}