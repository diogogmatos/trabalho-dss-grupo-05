package ESIdealLN.Veiculos;

import ESIdealDL.VeiculoDAO;

public class GesVeiculosFacade implements IGesVeiculos {

	private VeiculoDAO veiculos;

	/**
	 * 
	 * @param nif
	 * @param matricula
	 * @param tipo
	 */
	public void adicionarVeiculo(String nif, String matricula, String tipo) {
		// TODO - implement ESIdealLN.Veiculos.GesVeiculosFacade.adicionarVeiculo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean verificarRegistoVeiculo(String matricula) {
		// TODO - implement ESIdealLN.Veiculos.GesVeiculosFacade.verificarRegistoVeiculo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nif
	 * @param matricula
	 */
	public boolean validarDonoVeiculo(String nif, String matricula) {
		// TODO - implement ESIdealLN.Veiculos.GesVeiculosFacade.validarDonoVeiculo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 */
	public Veiculo getVeiculo(String matricula) {
		// TODO - implement ESIdealLN.Veiculos.GesVeiculosFacade.getVeiculo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param matricula
	 * @param tipoServico
	 */
	public boolean validarCompatibilidadeVeiculo(String matricula, String tipoServico) {
		// TODO - implement ESIdealLN.Veiculos.GesVeiculosFacade.validarCompatibilidadeVeiculo
		throw new UnsupportedOperationException();
	}

}