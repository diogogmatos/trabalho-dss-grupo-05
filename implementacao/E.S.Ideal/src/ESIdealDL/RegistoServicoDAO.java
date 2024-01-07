package ESIdealDL;

import ESIdealLN.Funcionarios.RegistoServico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class RegistoServicoDAO {

	/**
	 * 
	 * @param nrTurno
	 * @param nrMarcacao
	 */
	public void iniciarServico(int nrTurno, int nrMarcacao) throws Exception {
		LocalDateTime inicio = LocalDateTime.now();
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("INSERT INTO RegistoServico (nrTurno, nrMarcacao, inicio) VALUES (?, ?, ?)")) {
			stm.setInt(1, nrTurno);
			stm.setInt(2, nrMarcacao);
			stm.setTimestamp(3, Timestamp.valueOf(inicio));
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao iniciar serviço: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrMarcacao
	 */
	public void terminarServico(int nrMarcacao) throws Exception {
		LocalDateTime fim = LocalDateTime.now();
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("UPDATE RegistoServico SET fim = ? WHERE nrMarcacao = ?")) {
			stm.setTimestamp(1, Timestamp.valueOf(fim));
			stm.setInt(2, nrMarcacao);
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao terminar serviço: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrTurno
	 */
	public List<RegistoServico> getServicosTurno(int nrTurno) throws Exception {
		List<RegistoServico> servicos = new ArrayList<>();
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM RegistoServico WHERE nrTurno = ?")) {
			stm.setInt(1, nrTurno);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				servicos.add(new RegistoServico(rs.getInt("nrMarcacao"), rs.getTimestamp("inicio").toLocalDateTime(), rs.getTimestamp("fim").toLocalDateTime()));
			}
			if (servicos.isEmpty()) {
				throw new Exception("Não existem serviços para o turno " + nrTurno + ".");
			}
			return servicos;
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviços do turno: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrTurno
	 * @param nrMarcacao
	 */
	public RegistoServico getServico(int nrTurno, int nrMarcacao) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM RegistoServico WHERE nrTurno = ? AND nrMarcacao = ?")) {
			stm.setInt(1, nrTurno);
			stm.setInt(2, nrMarcacao);
			ResultSet rs = stm.executeQuery();

			if (!rs.next()) {
				throw new Exception("Serviço não encontrado.");
			}

			return new RegistoServico(rs.getInt("nrMarcacao"), rs.getTimestamp("inicio").toLocalDateTime(), rs.getTimestamp("fim").toLocalDateTime());
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviço: " + e.getMessage());
		}
	}

	public List<RegistoServico> getServicos() throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM RegistoServico")) {
			ResultSet rs = stm.executeQuery();
			List<RegistoServico> servicos = new ArrayList<>();
			while (rs.next()) {
				servicos.add(new RegistoServico(rs.getInt("nrMarcacao"), rs.getTimestamp("inicio").toLocalDateTime(), rs.getTimestamp("fim").toLocalDateTime()));
			}
			if (servicos.isEmpty()) {
				throw new Exception("Não existem serviços.");
			}
			return servicos;
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter serviços: " + e.getMessage());
		}
	}
}