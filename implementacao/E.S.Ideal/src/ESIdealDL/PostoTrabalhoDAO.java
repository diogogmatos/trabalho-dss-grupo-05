package ESIdealDL;

import ESIdealLN.Estacao.PostoTrabalho;
import ESIdealLN.Estacao.PostoUniversal;
import ESIdealLN.Estacao.PostoEletrico;
import ESIdealLN.Estacao.PostoHibrido;
import ESIdealLN.Estacao.PostoCombustao;
import ESIdealLN.Estacao.PostoGasolina;
import ESIdealLN.Estacao.PostoGasoleo;

import java.sql.*;

public class PostoTrabalhoDAO {
	/**
	 * 
	 * @param tipoPosto
	 */
	public int adicionarPostoTrabalho(String tipoPosto) throws Exception {
		try (PreparedStatement stm1 = Conexao.conexao.prepareStatement("INSERT INTO PostoTrabalho (tipo) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
			stm1.setString(1, tipoPosto);
			stm1.executeUpdate();

			ResultSet rs1 = stm1.getGeneratedKeys();
			rs1.next();
			return rs1.getInt(1);
        }
		catch (SQLException e) {
			throw new Exception("Erro ao adicionar posto de trabalho: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrPosto
	 */
	public void removerPostoTrabalho(int nrPosto) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("DELETE FROM PostoTrabalho WHERE nrPosto = ?")) {
			stm.setInt(1, nrPosto);
			stm.executeUpdate();
		}
		catch (SQLException e) {
			throw new Exception("Erro ao remover posto de trabalho: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param nrPosto
	 */
	public PostoTrabalho getPostoTrabalho(int nrPosto) throws Exception {
		try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT * FROM PostoTrabalho WHERE nrPosto = ?")) {
			stm.setInt(1, nrPosto);
			ResultSet rs = stm.executeQuery();

			if (!rs.next()) {
				throw new Exception("Posto de trabalho não encontrado.");
			}

            return switch (rs.getString("tipo")) {
                case "universal" -> new PostoUniversal(nrPosto);
                case "eletrico" -> new PostoEletrico(nrPosto);
                case "hibrido" -> new PostoHibrido(nrPosto);
                case "combustao" -> new PostoCombustao(nrPosto);
                case "gasolina" -> new PostoGasolina(nrPosto);
                case "gasoleo" -> new PostoGasoleo(nrPosto);
                default -> throw new Exception("Tipo de posto de trabalho inválido!");
            };
		}
		catch (SQLException e) {
			throw new Exception("Erro ao obter posto de trabalho: " + e.getMessage());
		}
	}
}