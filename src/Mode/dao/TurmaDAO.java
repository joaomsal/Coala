
package Mode.dao;

import Model.bean.Aluno;
import Model.bean.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
Mudar o banco para o nome da escola ser a chave da tabela escola
adaptar os demais métodos para que isso ocorra 
*/

public class TurmaDAO {
    private Connection con= null;
 
 public TurmaDAO (){
     con = Conection.ConectionFactory.getConection();
}
 
 public boolean save (Turma user,String esc){   //ok 
   
     String sql = "INSERT INTO turma (nome,escola_nome) VALUES (?,?)"; // alteração feita, nome da escola é a nova chave
      PreparedStatement stmt = null;
     try {
         stmt= con.prepareStatement(sql);
         stmt.setNString(1, user.getNome());
         stmt.setNString(2, esc);
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
             //us.escola.setNome(rs.getString("escola_idescola"));
             user.add(us);
         }
     } catch (SQLException ex) {
         System.out.println("ERRO FIND");
     }finally{
         Conection.ConectionFactory.CloseConnection(con, stmt, rs);
     }
     return user;   
    } 
 
    
     public List<Turma> findAlgum(String a) {// array do tipo aluno
        String sql = "SELECT *FROM turma WHERE nome LIKE ?";//selecionando todos os componentes da tabela
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Turma> user = new ArrayList();

        try {
            stmt = con.prepareStatement(sql);
             stmt.setNString(1, "%"+a+"%");
            rs = stmt.executeQuery();// executando o select from 

            while (rs.next()) {// while para adicionar o objeto aluno na arraylist do tipo aluno
                Turma us = new Turma();
                us.setNome(rs.getString("nome"));
                 us.escola.setNome(rs.getNString("escola_nome"));
                user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO FIND Allgum");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);// fechando conecção 
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
