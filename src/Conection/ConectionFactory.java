
package Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RG 295
 */
public class ConectionFactory {
     private static final String DRIVER = "com.mysql.jdbc.Driver"; 
    private static final String URL = "jdbc:mysql://localhost:3306/mydb"; 
    private static final String USER = "root"; 
    private static final String PASS = ""; 
    
    public static Connection getConection(){
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na Conexão", ex);
        }
    }
    public static void CloseConnection(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Conexão encerrada", ex);
            }
        }
    }
    
    public static void CloseConnection(Connection con, PreparedStatement stmt){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Conexão encerrada", ex);
            }
            CloseConnection(con);
        }
    }
    public static void CloseConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Conexão encerrada", ex);
            }
            CloseConnection(con,stmt);
        }
    }
}
