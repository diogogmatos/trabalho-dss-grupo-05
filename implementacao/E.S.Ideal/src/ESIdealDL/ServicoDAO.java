package ESIdealDL;

import ESIdealLN.Servicos.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

	private Servico createServico(String tipoServico, int idServico, String designacao, int tempoNecessario) throws Exception {
		return switch (tipoServico) {
			case "universal" -> new ServicoUniversal(idServico, designacao, tempoNecessario);
			case "eletrico" -> new ServicoEletrico(idServico, designacao, tempoNecessario);
			case "combustao" -> new ServicoCombustao(idServico, designacao, tempoNecessario);
			case "gasolina" -> new ServicoGasolina(idServico, designacao, tempoNecessario);
			case "gasoleo" -> new ServicoGasoleo(idServico, designacao, tempoNecessario);
			default -> throw new Exception("Tipo de serviço inválido!");
		};
	}

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

			return createServico(rs.getString("tipo"), rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviço: " + e.getMessage());
		}
	}

	public List<Servico> getServicosPorTipo(String tipoServico) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Servico WHERE tipo = ?")) {
			stm.setString(1, tipoServico);
			ResultSet rs = stm.executeQuery();

			List<Servico> servicos = new ArrayList<>();
			while (rs.next()) {
				servicos.add(createServico(rs.getString("tipo"), rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario")));
			}
			if (servicos.isEmpty()) {
				throw new Exception("Não existem serviços de tipo " + tipoServico + ".");
			}
			return servicos;
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

			return createServico(rs.getString("tipo"), rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario"));
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviço: " + e.getMessage());
		}
	}

	public List<Servico> getServicos() throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Servico")) {
			ResultSet rs = stm.executeQuery();

			List<Servico> servicos = new ArrayList<>();
			while (rs.next()) {
				servicos.add(createServico(rs.getString("tipo"), rs.getInt("idServico"), rs.getString("designacao"), rs.getInt("tempoNecessario")));
			}
			if (servicos.isEmpty()) {
				throw new Exception("Não existem serviços.");
			}
			return servicos;
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviço: " + e.getMessage());
		}
	}
}