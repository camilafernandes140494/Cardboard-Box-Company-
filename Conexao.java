package conexao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bancocardboard";
    private static final String USER = "root";
    private static final String PASSWORD = "";
        
    public static Connection getConnection() throws SQLException
    {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro na conexao");
        }
    }
    public static void closeConnection(Connection con)
    {
        if(con != null) 
        {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro" + ex);

            }
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt)
    {
        
        if(stmt != null) 
        {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro" + ex);
            }
        }
        closeConnection(con);
    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs)
    {
        if(rs != null) 
        {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro" + ex);
            }
        }
        closeConnection(con, stmt);
    }
    
}
