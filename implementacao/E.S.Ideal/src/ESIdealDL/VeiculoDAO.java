package ESIdealDL;

import ESIdealLN.Veiculos.*;

import java.sql.*;

public class VeiculoDAO {

	/**
	 * 
	 * @param nifCliente
	 * @param matricula
	 * @param tipo
	 */
	public void adicionarVeiculo(String nifCliente, String matricula, String tipo) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("INSERT INTO Veiculo (matricula, nifCliente, tipo) VALUES (?, ?, ?)")) {
			stm.setString(1, matricula);
			stm.setString(2, nifCliente);
			stm.setString(3, tipo);
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new Exception("Erro ao adicionar veículo: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param matricula
	 */
	public void removerVeiculo(String matricula) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("DELETE FROM Veiculo WHERE matricula = ?")) {
			stm.setString(1, matricula);
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new Exception("Erro ao remover veículo: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean existeVeiculo(String matricula) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Veiculo WHERE matricula = ?")) {
			stm.setString(1, matricula);
			ResultSet rs = stm.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new Exception("Erro ao verificar se veículo existe: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param matricula
	 * @param nifCliente
	 */
	public boolean validarDono(String matricula, String nifCliente) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Veiculo WHERE matricula = ? AND nifCliente = ?")) {
			stm.setString(1, matricula);
			stm.setString(2, nifCliente);
			ResultSet rs = stm.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new Exception("Erro ao verificar se cliente é dono do veículo: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param matricula
	 */
	public Veiculo getVeiculo(String matricula) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Veiculo WHERE matricula = ?")) {
			stm.setString(1, matricula);
			ResultSet rs = stm.executeQuery();
			if (!rs.next()) {
				throw new Exception("Veículo não encontrado.");
			}
			return switch (rs.getString("tipo")) {
				case "gasolina" -> new VeiculoGasolina(matricula, rs.getString("nifCliente"));
				case "gasoleo" -> new VeiculoGasoleo(matricula, rs.getString("nifCliente"));
				case "hibridogla" -> new VeiculoHibridoGasolina(matricula, rs.getString("nifCliente"));
				case "hibridoglo" -> new VeiculoHibridoGasoleo(matricula, rs.getString("nifCliente"));
				case "eletrico" -> new VeiculoEletrico(matricula, rs.getString("nifCliente"));
				default -> throw new Exception("Tipo de veículo desconhecido.");
			};
		}
	}
}