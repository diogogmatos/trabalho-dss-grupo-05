package ESIdealDL;

import ESIdealLN.Servicos.*;

import java.sql.*;

public class ServicoDAO {

	/**
	 * 
	 * @param designacao
	 * @param tipo
	 */
	public int adicionarServico(String designacao, int tempoNecessario, String tipo) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("INSERT INTO Servico (designacao, tempoNecessario, tipo) VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
			stm.setString(1, designacao);
			stm.setInt(2, tempoNecessario);
			stm.setString(3, tipo);
			stm.executeUpdate();

			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		}
		catch (SQLException e) {
			throw new Exception("Erro ao adicionar serviço: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param idServico
	 */
	public void removerServico(int idServico) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("DELETE FROM Servico WHERE idServico = ?")) {
			stm.setInt(1, idServico);
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao remover serviço: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param designacao
	 */
	public Servico getServicoPorDesignacao(String designacao) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Servico WHERE designacao = ?")) {
			stm.setString(1, designacao);
			ResultSet rs = stm.executeQuery();

			if (!rs.next()) {
				throw new Exception("Serviço não encontrado.");
			}

			return switch (rs.getString("tipo")) {
				case "combustao" -> new ServicoCombustao(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
				case "eletrico" -> new ServicoEletrico(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
				case "hibrido" -> new ServicoHibrido(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
				case "gasolina" -> new ServicoGasolina(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
				case "gasoleo" -> new ServicoGasoleo(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
				default -> new ServicoUniversal(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
			};
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviço: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param idServico
	 */
	public Servico getServico(int idServico) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Servico WHERE idServico = ?")) {
			stm.setInt(1, idServico);
			ResultSet rs = stm.executeQuery();

			if (!rs.next()) {
				throw new Exception("Serviço não encontrado.");
			}

			return switch (rs.getString("tipo")) {
				case "combustao" -> new ServicoCombustao(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
				case "eletrico" -> new ServicoEletrico(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
				case "hibrido" -> new ServicoHibrido(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
				case "gasolina" -> new ServicoGasolina(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
				case "gasoleo" -> new ServicoGasoleo(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
				default -> new ServicoUniversal(rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
			};
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviço: " + e.getMessage());
		}
	}
}