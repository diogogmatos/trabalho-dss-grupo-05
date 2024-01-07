package ESIdealDL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class EstacaoDAO {
    public LocalTime getAbertura() throws Exception {
        try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT abertura FROM Estacao")) {
            ResultSet rs = stm.executeQuery();
            rs.next();
            return LocalTime.parse(rs.getString("abertura"));
        }
        catch (SQLException e) {
            throw new Exception("Erro ao obter hora de abertura: " + e.getMessage());
        }
    }

    public LocalTime getFecho() throws Exception {
        try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT fecho FROM Estacao")) {
            ResultSet rs = stm.executeQuery();
            rs.next();
            return LocalTime.parse(rs.getString("fecho"));
        }
        catch (SQLException e) {
            throw new Exception("Erro ao obter hora de fecho: " + e.getMessage());
        }
    }

    public void definirAbertura(LocalTime abertura) throws Exception {
        try (PreparedStatement stm = Conexao.conexao.prepareStatement("UPDATE Estacao SET abertura = ?")) {
            stm.setString(1, abertura.toString());
            stm.executeUpdate();
        }
        catch (SQLException e) {
            throw new Exception("Erro ao definir hora de abertura: " + e.getMessage());
        }
    }

    public void definirFecho(LocalTime fecho) throws Exception {
        try (PreparedStatement stm = Conexao.conexao.prepareStatement("UPDATE Estacao SET fecho = ?")) {
            stm.setString(1, fecho.toString());
            stm.executeUpdate();
        }
        catch (SQLException e) {
            throw new Exception("Erro ao definir hora de fecho: " + e.getMessage());
        }
    }
}
