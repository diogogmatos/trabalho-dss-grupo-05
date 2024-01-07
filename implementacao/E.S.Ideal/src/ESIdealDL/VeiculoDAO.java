package ESIdealDL;

import ESIdealLN.Veiculos.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
	private Veiculo createVeiculo(String tipo, String matricula, String nifCliente) throws Exception {
		return switch (tipo) {
			case "gasolina" -> new VeiculoGasolina(matricula, nifCliente);
			case "gasoleo" -> new VeiculoGasoleo(matricula, nifCliente);
			case "hibridogla" -> new VeiculoHibridoGasolina(matricula, nifCliente);
			case "hibridoglo" -> new VeiculoHibridoGasoleo(matricula, nifCliente);
			case "eletrico" -> new VeiculoEletrico(matricula, nifCliente);
			default -> throw new Exception("Tipo de veículo desconhecido.");
		};
	}

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
			return createVeiculo(rs.getString("tipo"), matricula, rs.getString("nifCliente"));
		}
	}

	public List<Veiculo> getVeiculos() throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Veiculo")) {
			ResultSet rs = stm.executeQuery();
			List<Veiculo> veiculos = new ArrayList<>();
			while (rs.next()) {
				veiculos.add(createVeiculo(rs.getString("tipo"), rs.getString("matricula"), rs.getString("nifCliente")));
			}
			if (veiculos.isEmpty()) {
				throw new Exception("Não existem veículos.");
			}
			return veiculos;
		} catch (SQLException e) {
			throw new Exception("Erro ao obter veículos: " + e.getMessage());
		}
	}
}