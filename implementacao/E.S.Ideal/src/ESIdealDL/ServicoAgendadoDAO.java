package ESIdealDL;

import ESIdealLN.Servicos.ServicoAgendado;
import ESIdealLN.Servicos.ServicoAgendadoIncompleto;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ServicoAgendadoDAO {
	/**
	 * 
	 * @param idServico
	 * @param matricula
	 * @param nrCartaoFuncionario
	 */
	public int adicionarServicoPendente(int idServico, String matricula, int nrCartaoFuncionario) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("INSERT INTO ServicoAgendado (idServico, matricula, nrCartaoFuncionario, tipo) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
			stm.setInt(1, idServico);
			stm.setString(2, matricula);
			stm.setInt(3, nrCartaoFuncionario);
			stm.setString(4, "pendente");
			stm.executeUpdate();

			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		}
		catch (SQLException e) {
			throw new Exception("Erro ao adicionar serviço agendado: " + e.getMessage());
		}
	}

	public void removerServicoPendente(int nrMarcacao) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("DELETE FROM ServicoAgendado WHERE nrMarcacao = ?")) {
			stm.setInt(1, nrMarcacao);
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao remover serviço agendado: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrMarcacao
	 */
	public void marcarComoConcluido(int nrMarcacao) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("UPDATE ServicoAgendado SET tipo = 'concluido' WHERE nrMarcacao = ?")) {
			stm.setInt(1, nrMarcacao);
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao marcar serviço como concluído: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrMarcacao
	 * @param motivo
	 */
	public void marcarComoIncompleto(int nrMarcacao, String motivo) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("UPDATE ServicoAgendado SET tipo = 'incompleto' WHERE nrMarcacao = ?")) {
			stm.setInt(1, nrMarcacao);
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao marcar serviço como incompleto: " + e.getMessage());
		}
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("INSERT INTO ServicoAgendadoIncompleto (nrMarcacao, motivo) VALUES (?, ?)")) {
			stm.setInt(1, nrMarcacao);
			stm.setString(2, motivo);
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao adicionar o motivo: " + e.getMessage());
		}
	}

	public List<ServicoAgendado> getServicosPendentesFuncionario(int nrCartaoFuncionario) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM ServicoAgendado WHERE nrCartaoFuncionario = ? AND tipo = 'pendente'")) {
			stm.setInt(1, nrCartaoFuncionario);
			ResultSet rs = stm.executeQuery();
			List<ServicoAgendado> servicos = new ArrayList<>();
			while (rs.next()) {
				servicos.add(new ServicoAgendado(rs.getInt("idServico"), rs.getInt("nrMarcacao"), rs.getString("matricula"), rs.getInt("nrCartaoFuncionario")));
			}
			if (servicos.isEmpty()) {
				throw new Exception("Não existem serviços pendentes para o funcionário " + nrCartaoFuncionario + ".");
			}
			return servicos;
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviços pendentes: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrCartaoFuncionario
	 */
	public ServicoAgendado getServicoPendente(int nrCartaoFuncionario) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM ServicoAgendado WHERE nrCartaoFuncionario = ? AND tipo = 'pendente' ORDER BY nrMarcacao ASC LIMIT 1")) {
			stm.setInt(1, nrCartaoFuncionario);
			ResultSet rs = stm.executeQuery();
			if (!rs.next()) {
				throw new Exception("Não existem serviços pendentes para o funcionário " + nrCartaoFuncionario + ".");
			}
			return new ServicoAgendado(rs.getInt("idServico"), rs.getInt("nrMarcacao"), rs.getString("matricula"), rs.getInt("nrCartaoFuncionario"));
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviço pendente: " + e.getMessage());
		}
	}

	/**
	 *
	 * @param nrCartaoFuncionario
	 */
	public boolean existemServicosPendentesParaFuncionario(int nrCartaoFuncionario) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM ServicoAgendado WHERE nrCartaoFuncionario = ? AND tipo = 'pendente'")) {
			stm.setInt(1, nrCartaoFuncionario);
			ResultSet rs = stm.executeQuery();
			return rs.next();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao verificar se existem serviços pendentes para o funcionário " + nrCartaoFuncionario + ": " + e.getMessage());
		}
	}

	public int tempoNecessarioAcabarServicosFuncionario(int nrCartaoFuncionario) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement(("SELECT SUM(tempoNecessario) FROM ServicoAgendado INNER JOIN Servico ON ServicoAgendado.idServico = Servico.idServico WHERE nrCartaoFuncionario = ? AND ServicoAgendado.tipo = 'pendente'"))) {
			stm.setInt(1, nrCartaoFuncionario);
			ResultSet rs = stm.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter o tempo necessário para acabar os serviços pendentes do funcionário " + nrCartaoFuncionario + ": " + e.getMessage());
		}
	}

	public ServicoAgendado getServicoAgendado(int nrMarcacao) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM ServicoAgendado WHERE nrMarcacao = ?")) {
			stm.setInt(1, nrMarcacao);
			ResultSet rs = stm.executeQuery();
			if (!rs.next()) {
				throw new Exception("Não existe serviço agendado com o número de marcação " + nrMarcacao + ".");
			}
			return new ServicoAgendado(rs.getInt("idServico"), rs.getInt("nrMarcacao"), rs.getString("matricula"), rs.getInt("nrCartaoFuncionario"));
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviço agendado: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean existemServicosPendentesParaVeiculo(String matricula) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM ServicoAgendado WHERE matricula = ? AND tipo = 'pendente'")) {
			stm.setString(1, matricula);
			ResultSet rs = stm.executeQuery();
			return rs.next();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao verificar se existem serviços pendentes para o veículo " + matricula + ": " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param matricula
	 */
	public boolean existemServicosConcluidosParaVeiculo(String matricula) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM ServicoAgendado WHERE matricula = ? AND tipo = 'concluido'")) {
			stm.setString(1, matricula);
			ResultSet rs = stm.executeQuery();
			return rs.next();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao verificar se existem serviços concluídos para o veículo " + matricula + ": " + e.getMessage());
		}
	}

	public List<ServicoAgendado> getServicosPendentes() throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM ServicoAgendado WHERE tipo = 'pendente'")) {
			ResultSet rs = stm.executeQuery();
			List<ServicoAgendado> servicos = new ArrayList<>();
			while (rs.next()) {
				servicos.add(new ServicoAgendado(rs.getInt("idServico"), rs.getInt("nrMarcacao"), rs.getString("matricula"), rs.getInt("nrCartaoFuncionario")));
			}
			if (servicos.isEmpty()) {
				throw new Exception("Não existem serviços pendentes.");
			}
			return servicos;
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviços pendentes: " + e.getMessage());
		}
	}

	public List<ServicoAgendado> getServicosConcluidos() throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM ServicoAgendado WHERE tipo = 'concluido'")) {
			ResultSet rs = stm.executeQuery();
			List<ServicoAgendado> servicos = new ArrayList<>();
			while (rs.next()) {
				servicos.add(new ServicoAgendado(rs.getInt("idServico"), rs.getInt("nrMarcacao"), rs.getString("matricula"), rs.getInt("nrCartaoFuncionario")));
			}
			if (servicos.isEmpty()) {
				throw new Exception("Não existem serviços concluídos.");
			}
			return servicos;
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviços concluídos: " + e.getMessage());
		}
	}

	public List<ServicoAgendadoIncompleto> getServicosIncompletos() throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM ServicoAgendado INNER JOIN ServicoAgendadoIncompleto ON ServicoAgendado.nrMarcacao = ServicoAgendadoIncompleto.nrMarcacao ORDER BY ServicoAgendado.nrMarcacao ASC")) {
			ResultSet rs = stm.executeQuery();
			List<ServicoAgendadoIncompleto> servicos = new ArrayList<>();
			while (rs.next()) {
				servicos.add(new ServicoAgendadoIncompleto(rs.getInt("idServico"), rs.getInt("nrMarcacao"), rs.getString("matricula"), rs.getInt("nrCartaoFuncionario"), rs.getString("motivo")));
			}
			if (servicos.isEmpty()) {
				throw new Exception("Não existem serviços incompletos.");
			}
			return servicos;
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviços incompletos: " + e.getMessage());
		}
	}
}