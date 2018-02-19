package Mode.dao;

import Model.bean.Aluno;
import Model.bean.Escola;
import Model.bean.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlunoDao {

    private Connection con = null;//contrutor do conector

    public AlunoDao() {
        con = Conection.ConectionFactory.getConection();//invocando o conector do DB
    }

    public boolean save(Aluno user, String esc, String turm) {//Classe que insere e salva os dados
        String sql = "INSERT INTO aluno (nome,turma_nome, turma_Escola_nome) VALUES (?,?,?);";
        
        PreparedStatement stmt = null;
        try {
           stmt = con.prepareStatement(sql);// preparando o DB para inserção
           stmt.setNString(1, user.getNome());//inserindo o objeto aluno
           stmt.setNString(2,esc);
           stmt.setNString(3,turm);

            stmt.executeUpdate();// update
            return true;
        }
        
        catch (SQLException ex) {
            System.out.println("Erro, dont save!" + ex);
            return false;
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt);
        }

    }

    public List<Aluno> findAll() {// array do tipo aluno
        String sql = "SELECT *FROM aluno";//selecionando todos os componentes da tabela
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> user = new ArrayList();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();// executando o select from 

            while (rs.next()) {// while para adicionar o objeto aluno na arraylist do tipo aluno
                Aluno us = new Aluno();
                us.setId(rs.getInt("idAluno"));
                us.setNome(rs.getString("nome"));
                us.turma.setNome(rs.getNString("turma_nome"));
                us.turma.escola.setNome(rs.getNString("turma_escola_nome"));
                user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO FIND");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);// fechando conecção 
        }
        return user;
    }
    
     public List<Aluno> buscaporNome(String a) {// array do tipo aluno
        String sql = "SELECT *FROM aluno WHERE nome LIKE ?";//selecionando todos os componentes da tabela
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> user = new ArrayList();

        try {
            stmt = con.prepareStatement(sql);
             stmt.setNString(1, "%"+a+"%");
            rs = stmt.executeQuery();// executando o select from 

            while (rs.next()) {// while para adicionar o objeto aluno na arraylist do tipo aluno
                Aluno us = new Aluno();
                us.setId(rs.getInt("idAluno"));
                us.setNome(rs.getString("nome"));
                 us.turma.escola.setNome(rs.getNString("turma_Escola_nome"));
                us.turma.setNome(rs.getNString("turma_nome"));
                 user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO FIND Allgum");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);// fechando conecção 
        }
        return user;
    }
     public List<Aluno> buscaporTurma(String a) {// array do tipo aluno
        String sql = "SELECT *FROM aluno WHERE turma_nome LIKE ?";//selecionando todos os componentes da tabela
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> user = new ArrayList();

        try {
            stmt = con.prepareStatement(sql);
             stmt.setNString(1, "%"+a+"%");
            rs = stmt.executeQuery();// executando o select from 

            while (rs.next()) {// while para adicionar o objeto aluno na arraylist do tipo aluno
                Aluno us = new Aluno();
                us.setId(rs.getInt("idAluno"));
                us.setNome(rs.getString("nome"));
                 us.turma.escola.setNome(rs.getNString("turma_Escola_nome"));
                us.turma.setNome(rs.getNString("turma_nome"));
                 user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO FIND Allgum");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);// fechando conecção 
        }
        return user;
    }
     public List<Aluno> buscaporEscola(String a) {// array do tipo aluno
        String sql = "SELECT *FROM aluno WHERE turma_Escola_nome LIKE ?";//selecionando todos os componentes da tabela
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> user = new ArrayList();

        try {
            stmt = con.prepareStatement(sql);
             stmt.setNString(1, "%"+a+"%");
            rs = stmt.executeQuery();// executando o select from 

            while (rs.next()) {// while para adicionar o objeto aluno na arraylist do tipo aluno
                Aluno us = new Aluno();
                us.setId(rs.getInt("idAluno"));
                us.setNome(rs.getString("nome"));
                 us.turma.escola.setNome(rs.getNString("turma_Escola_nome"));
                us.turma.setNome(rs.getNString("turma_nome"));
                 user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO FIND Allgum");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);// fechando conecção 
        }
        return user;
    }
     public List<Aluno> findEspecifico(Aluno a) {// array do tipo aluno
        String sql = "SELECT *FROM aluno WHERE nome LIKE ?";//selecionando todos os componentes da tabela com o nome = a 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> user = new ArrayList();

        try {
            stmt = con.prepareStatement(sql);
             stmt.setNString(1, "%"+ a.getNome() +"%");
            rs = stmt.executeQuery();// executando o select from 

            while (rs.next()) {// while para adicionar o objeto aluno na arraylist do tipo aluno
                Aluno us = new Aluno();
                us.setNome(rs.getString("nome"));
                 us.turma.escola.setNome(rs.getNString("escola_nome"));
                user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO FIND Allgum");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);// fechando conecção 
        }
        return user;
    }

    public boolean update(Aluno user) {
        
        String sql3 = "UPDATE aluno SET nome = ? WHERE nome = ?";// atualiza o aluno onde o nome é igual ao inserido
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql3);
            stmt.setNString(1, user.getNome());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro, dont save!" + ex);
            return false;
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt);
        }

    }

    public boolean delete(int id) {
        String sql3 = "DELETE FROM aluno WHERE idAluno = ?"; // deleta aluno onde o nome é igual ao inserido
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql3);
            stmt.setInt(1, id); // id
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("NÃO EXCLUIU" + ex);
            return false;
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt);
        }

    }

}
