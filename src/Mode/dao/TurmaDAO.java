
package Mode.dao;

import Model.bean.Escola;
import Model.bean.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TurmaDAO {
    private Connection con= null;
 
 public TurmaDAO (){
     con = Conection.ConectionFactory.getConection();
}
 
 public boolean save (Turma user,Escola esc){   //ok 
   
     String sql = "INSERT INTO turma (nome,escola_idescola) VALUES (?,?)";
      PreparedStatement stmt = null;
     try {
         stmt= con.prepareStatement(sql);
         stmt.setNString(1, user.getNome());
         stmt.setNString(2, esc.getNome());
                    stmt.executeUpdate();
                    

        return true;
     } catch (SQLException ex) {
      System.out.println("Erro, dont save!"+ ex);
        return false;
     } finally{
         Conection.ConectionFactory.CloseConnection(con, stmt);
     }
     
 }
    public List <Turma> findAll(){  // ok
        String sql = "SELECT *FROM turma";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Turma> user = new ArrayList();
        
     try {
         stmt= con.prepareStatement(sql);
         rs =stmt.executeQuery();
         
         while(rs.next()){
             Turma us = new Turma ();
             us.setNome(rs.getString("nome"));
             us.escola.setNome(rs.getString("escola_idescola"));
             user.add(us);
         }
     } catch (SQLException ex) {
         System.out.println("ERRO FIND");
     }finally{
         Conection.ConectionFactory.CloseConnection(con, stmt, rs);
     }
     return user;   
    } 
 
    public boolean update (Turma user, int id){  //ok
     String sql3 = "UPDATE Turma SET nome = ? WHERE id = ?";
      PreparedStatement stmt = null;
     try {
         stmt= con.prepareStatement(sql3);
         stmt.setNString(1, user.getNome());
         stmt.setInt(2, id);
         stmt.executeUpdate();
        return true;
     } catch (SQLException ex) {
      System.out.println("Erro, dont save!"+ ex);
        return false;
     } finally{
         Conection.ConectionFactory.CloseConnection(con, stmt);
     }
     
 }
    public boolean delete (int id){ // ok
     String sql3 = "DELETE FROM escola WHERE id = ?";
      PreparedStatement stmt = null;
     try {
         stmt= con.prepareStatement(sql3);
         stmt.setInt(1, id); // id
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
