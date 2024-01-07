package ESIdealDL;
import ESIdealLN.Clientes.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	/**
	 * 
	 * @param nome
	 * @param nif
	 * @param morada
	 * @param telefone
	 * @param email
	 */
	public void adicionarCliente(String nome, String nif, String morada, String telefone, String email) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("INSERT INTO Cliente (nome, nif, morada, telefone, email) VALUES (?, ?, ?, ?, ?)")) {
			stm.setString(1, nif);
			stm.setString(2, nome);
			stm.setString(3, morada);
			stm.setString(4, telefone);
			stm.setString(5, email);
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new Exception("Erro ao adicionar cliente: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nif
	 */
	public void removerCliente(String nif) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("DELETE FROM Cliente WHERE nif = ?")) {
			stm.setString(1, nif);
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new Exception("Erro ao remover cliente: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nif
	 * @param sms
	 * @param email
	 */
	public void registarPreferenciaNotificacao(String nif, boolean sms, boolean email) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("UPDATE Cliente SET notSMS = ?, notEmail = ? WHERE nif = ?")) {
			stm.setBoolean(1, sms);
			stm.setBoolean(2, email);
			stm.setString(3, nif);
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new Exception("Erro ao registar preferência de notificação: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nif
	 */
	public Cliente getCliente(String nif) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Cliente WHERE nif = ?")) {
			stm.setString(1, nif);
			ResultSet rs = stm.executeQuery();
			if (!rs.next()) {
				throw new Exception("Cliente não encontrado.");
			}
			return new Cliente(rs.getString("nome"), rs.getString("nif"), rs.getString("morada"), rs.getString("telefone"), rs.getString("email"), rs.getBoolean("notSMS"), rs.getBoolean("notEmail"));
		} catch (SQLException e) {
			throw new Exception("Erro ao obter cliente: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nif
	 */
	public boolean existeCliente(String nif) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Cliente WHERE nif = ?")) {
			stm.setString(1, nif);
			ResultSet rs = stm.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new Exception("Erro ao verificar se existe cliente: " + e.getMessage());
		}
	}

	public List<Cliente> getClientes() throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM Cliente")) {
			ResultSet rs = stm.executeQuery();
			List<Cliente> clientes = new ArrayList<>();
			while (rs.next()) {
				clientes.add(new Cliente(rs.getString("nome"), rs.getString("nif"), rs.getString("morada"), rs.getString("telefone"), rs.getString("email"), rs.getBoolean("notSMS"), rs.getBoolean("notEmail")));
			}
			if (clientes.isEmpty()) {
				throw new Exception("Não existem clientes.");
			}
			return clientes;
		} catch (SQLException e) {
			throw new Exception("Erro ao obter clientes: " + e.getMessage());
		}
	}
}