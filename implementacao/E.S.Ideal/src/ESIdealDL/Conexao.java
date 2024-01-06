package ESIdealDL;

import java.sql.*;

public class Conexao {
    private static final String url = "jdbc:mariadb://localhost:3306/ESIdeal";
    private static final String usr = "diogo";
    private static final String pwd = "1234";
    public static final Connection conexao = connect();

    private static Connection connect() {
        try {
            System.out.println("Connecting to database...");
            return DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException e) {
            System.out.println("Connection failed!" + e.getMessage());
            System.exit(1);
            return null;
        }
    }
}
