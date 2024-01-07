package ESIdealDL;
import ESIdealLN.Funcionarios.Funcionario;

import java.util.List;
import java.util.ArrayList;

import java.sql.*;

public class FuncionarioDAO {
	/**
	 * 
	 * @param competencias
	 */
	public int adicionarFuncionario(List<String> competencias) throws Exception {
		int pk;
		// adicionar novo funcionário
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("INSERT INTO Funcionario (nrCartao) VALUES (NULL)", PreparedStatement.RETURN_GENERATED_KEYS)) {
			stm.executeUpdate();

			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			pk = rs.getInt(1);
		}
		catch (SQLException e) {
			throw new Exception("Erro ao adicionar funcionário: " + e.getMessage());
		}
		// adicionar competências
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("INSERT INTO Competencia (tipo, nrCartao) VALUES (?, ?)")) {
			for (String competencia : competencias) {
				stm.setString(1, competencia);
				stm.setInt(2, pk);
				stm.executeUpdate();
			}
		}
		catch (SQLException e) {
			throw new Exception("Erro ao adicionar competências: " + e.getMessage());
		}
		return pk;
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public void removerFuncionario(int nrCartao) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("DELETE FROM Funcionario WHERE nrCartao = ?")) {
			stm.setInt(1, nrCartao);
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao remover funcionário: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public Funcionario getFuncionario(int nrCartao) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Competencia WHERE nrCartao = ?")) {
			stm.setInt(1, nrCartao);
			ResultSet rs = stm.executeQuery();
			List<String> competencias = new ArrayList<>();

			while (rs.next()) {
				competencias.add(rs.getString("tipo"));
			}

			if (competencias.isEmpty())
				throw new Exception("Funcionário não encontrado.");

			return new Funcionario(nrCartao, competencias);
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter funcionário: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrCartao
	 * @param competencia
	 */
	public void adicionarCompetencia(int nrCartao, String competencia) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("INSERT INTO Competencia (tipo, nrCartao) VALUES (?, ?)")) {
			stm.setString(1, competencia);
			stm.setInt(2, nrCartao);
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao adicionar competência: " + e.getMessage());
		}
	}

	public List<Integer> funcionariosComCompetencia(String competencia) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Competencia WHERE tipo = ?")) {
			stm.setString(1, competencia);
			ResultSet rs = stm.executeQuery();
			List<Integer> funcionarios = new ArrayList<>();

			while (rs.next()) {
				funcionarios.add(rs.getInt("nrCartao"));
			}

			if (funcionarios.isEmpty())
				throw new Exception("Não existem funcionários com a competência " + competencia + ".");

			return funcionarios;
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter funcionários com competência: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrCartao
	 * @param competencia
	 */
	public void removerCompetencia(int nrCartao, String competencia) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("DELETE FROM Competencia WHERE nrCartao = ? AND tipo = ?")) {
			stm.setInt(1, nrCartao);
			stm.setString(2, competencia);
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao remover competência: " + e.getMessage());
		}
	}

	public List<Funcionario> getFuncionarios() throws Exception {
		List<Funcionario> funcionarios = new ArrayList<>();
		try (PreparedStatement stm1 = Conexao.conexao.prepareStatement("SELECT * FROM Funcionario")) {
			ResultSet rs1 = stm1.executeQuery();

			while (rs1.next()) {
				List<String> competencias = new ArrayList<>();
				try (PreparedStatement stm2 = Conexao.conexao.prepareStatement("SELECT * FROM Competencia WHERE nrCartao = ?")) {
					stm2.setInt(1, rs1.getInt("nrCartao"));
					ResultSet rs2 = stm2.executeQuery();
					while (rs2.next()) {
						competencias.add(rs2.getString("tipo"));
					}
				}
				catch (SQLException e) {
					throw new Exception("Erro ao obter competências: " + e.getMessage());
				}
				funcionarios.add(new Funcionario(rs1.getInt("nrCartao"), competencias));
			}

			if (funcionarios.isEmpty())
				throw new Exception("Não existem funcionários.");

			return funcionarios;
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter funcionários: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrCartao
	 */
	public boolean existeFuncionario(int nrCartao) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Funcionario WHERE nrCartao = ?")) {
			stm.setInt(1, nrCartao);
			ResultSet rs = stm.executeQuery();
			return rs.next();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao verificar existência de funcionário: " + e.getMessage());
		}
	}
}