
package Mode.dao;

import Model.bean.Escola;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author RG 295
 */
public class EscolaDao {
   
 private Connection con= null;
 
 public EscolaDao (){
     con = Conection.ConectionFactory.getConection();
}
 
 public boolean save (Escola user){
   
     String sql = "INSERT INTO escola (nome,media) VALUES (?,?)";
      PreparedStatement stmt = null;
     try {
         stmt= con.prepareStatement(sql);
         stmt.setNString(1, user.getNome());
         stmt.setDouble(2, user.getMedia());
                    stmt.executeUpdate();
                    

        return true;
     } catch (SQLException ex) {
      System.out.println("Erro, dont save!"+ ex);
        return false;
     } finally{
         Conection.ConectionFactory.CloseConnection(con, stmt);
     }
     
 }
    public List <Escola> findAll(){
        String sql = "SELECT *FROM tb";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Escola> user = new ArrayList();
        
     try {
         stmt= con.prepareStatement(sql);
         rs =stmt.executeQuery();
         
         while(rs.next()){
             Escola us = new Escola ();
             us.setNome(rs.getString("nome"));
             user.add(us);
         }
     } catch (SQLException ex) {
         System.out.println("ERRO FIND");
     }finally{
         Conection.ConectionFactory.CloseConnection(con, stmt, rs);
     }
     return user;   
    } 
 
    public boolean update (Escola user){
     String sql= "INSERT INTO usuario (`Cpf_user`, `Nome_user`, `Rg_user`, `email_user`, `telefone_user`, `dataNac_user`, `Reside_em_id_reside`) VALUES (?,?,?,?,?,?,?);";
      String sql2= "INSERT INTO endereco (`Logradouro`, `num`, `bairro`, `cidade`, `estado`, `cep`) VALUES (?, ?, ?, ?, ?, ?);";
     String sql3 = "UPDATE tb SET nome = ? WHERE id = ?";
      PreparedStatement stmt = null;
     try {
         stmt= con.prepareStatement(sql3);
         stmt.setNString(1, user.getNome());
         stmt.setInt(2, 25);
         stmt.executeUpdate();
        return true;
     } catch (SQLException ex) {
      System.out.println("Erro, dont save!"+ ex);
        return false;
     } finally{
         Conection.ConectionFactory.CloseConnection(con, stmt);
     }
     
 }
    public boolean delete (Escola user){
     String sql3 = "DELETE FROM tb WHERE id = ?";
      PreparedStatement stmt = null;
     try {
         stmt= con.prepareStatement(sql3);
         stmt.setInt(1, 25); // id
         stmt.executeUpdate();
        return true;
     } catch (SQLException ex) {
      System.out.println("Erro, dont save!"+ ex);
        return false;
     } finally{
         Conection.ConectionFactory.CloseConnection(con, stmt);
     }
     
 }
    
}
