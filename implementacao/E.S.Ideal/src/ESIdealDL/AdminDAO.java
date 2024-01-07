package ESIdealDL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    public void definirPassowordMestra(String password) throws Exception {
        try (PreparedStatement stm = Conexao.conexao.prepareStatement("UPDATE Administrador SET password = ?")) {
            stm.setString(1, password);
            stm.executeUpdate();
        }
        catch (SQLException e) {
            throw new Exception("Erro ao definir password mestra: " + e.getMessage());
        }
    }

    public String getPasswordMestra() throws Exception {
        try (PreparedStatement stm = Conexao.conexao.prepareStatement("SELECT password FROM Administrador")) {
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getString("password");
        }
        catch (SQLException e) {
            throw new Exception("Erro ao obter password mestra: " + e.getMessage());
        }
    }
}
