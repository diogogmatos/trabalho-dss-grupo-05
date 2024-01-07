package ESIdealDL;

import ESIdealLN.Funcionarios.RegistoTurno;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class RegistoTurnoDAO {
	/**
	 * 
	 * @param nrCartao
	 */
	public List<RegistoTurno> getTurnosFuncionario(int nrCartao) throws Exception {
		List<RegistoTurno> turnos = new ArrayList<>();
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM RegistoTurno WHERE nrCartaoFuncionario = ?")) {
			stm.setInt(1, nrCartao);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				turnos.add(new RegistoTurno(rs.getInt("nrTurno"), rs.getTimestamp("inicio").toLocalDateTime(), rs.getTimestamp("fim").toLocalDateTime(), nrCartao));
			}
			if (turnos.isEmpty()) {
				throw new Exception("Não existem turnos para o funcionário " + nrCartao + ".");
			}
			return turnos;
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter turnos: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public int iniciarTurno(int nrCartao) throws Exception {
		LocalDateTime inicio = LocalDateTime.now();
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("INSERT INTO RegistoTurno (nrCartaoFuncionario, inicio) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
			stm.setInt(1, nrCartao);
			stm.setTimestamp(2, Timestamp.valueOf(inicio));
			stm.executeUpdate();

			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		}
		catch (SQLException e) {
			throw new Exception("Erro ao iniciar turno: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrTurno
	 */
	public void terminarTurno(int nrTurno) throws Exception {
		LocalDateTime fim = LocalDateTime.now();
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("UPDATE RegistoTurno SET fim = ? WHERE nrTurno = ?")) {
			stm.setTimestamp(1, Timestamp.valueOf(fim));
			stm.setInt(2, nrTurno);
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao terminar turno: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrTurno
	 */
	public RegistoTurno getTurno(int nrTurno) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM RegistoTurno WHERE nrTurno = ?")) {
			stm.setInt(1, nrTurno);
			ResultSet rs = stm.executeQuery();
			if (!rs.next()) {
				throw new Exception("Turno não encontrado.");
			}
			return new RegistoTurno(nrTurno, rs.getTimestamp("inicio").toLocalDateTime(), rs.getTimestamp("fim").toLocalDateTime(), rs.getInt("nrCartaoFuncionario"));
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter turno: " + e.getMessage());
		}
	}

	public List<RegistoTurno> getTurnos() throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM RegistoTurno")) {
			ResultSet rs = stm.executeQuery();
			List<RegistoTurno> turnos = new ArrayList<>();
			while (rs.next()) {
				turnos.add(new RegistoTurno(rs.getInt("nrTurno"), rs.getTimestamp("inicio").toLocalDateTime(), rs.getTimestamp("fim").toLocalDateTime(), rs.getInt("nrCartaoFuncionario")));
			}
			if (turnos.isEmpty()) {
				throw new Exception("Não existem turnos.");
			}
			return turnos;
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter turnos: " + e.getMessage());
		}
	}
}