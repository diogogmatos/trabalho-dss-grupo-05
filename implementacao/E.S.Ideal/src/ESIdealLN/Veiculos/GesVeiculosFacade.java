package ESIdealLN.Veiculos;

import ESIdealDL.VeiculoDAO;

import java.util.List;

public class GesVeiculosFacade implements IGesVeiculos {

	private final VeiculoDAO veiculos;

	public GesVeiculosFacade() {
		this.veiculos = new VeiculoDAO();
	}

	/**
	 * 
	 * @param nif
	 * @param matricula
	 * @param tipo
	 */
	public void adicionarVeiculo(String nif, String matricula, String tipo) throws Exception {
		veiculos.adicionarVeiculo(nif, matricula, tipo);
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean verificarRegistoVeiculo(String matricula) throws Exception {
		return veiculos.existeVeiculo(matricula);
	}

	/**
	 * 
	 * @param nif
	 * @param matricula
	 */
	public boolean validarDonoVeiculo(String nif, String matricula) throws Exception {
		return veiculos.validarDono(matricula, nif);
	}

	/**
	 * 
	 * @param matricula
	 */
	public Veiculo getVeiculo(String matricula) throws Exception {
		return veiculos.getVeiculo(matricula);
	}

	/**
	 * 
	 * @param matricula
	 * @param tipoServico
	 */
	public boolean validarCompatibilidadeVeiculo(String matricula, String tipoServico) throws Exception {
		return veiculos.getVeiculo(matricula).validarCompatibilidade(tipoServico);
	}

	/**
	 *
	 * @param matricula
	 */
	public List<String> obterTipoServicosCompativeis(String matricula) throws Exception {
		return veiculos.getVeiculo(matricula).obterTipoServicosCompativeis();
	}

	public List<Veiculo> getVeiculos() throws Exception {
		return veiculos.getVeiculos();
	}
}