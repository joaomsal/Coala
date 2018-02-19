package Mode.dao;

import Model.bean.Escola;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RG 295 Inserção de novas escolas ok exclusão ok
 */
public class EscolaDao {

    private Connection con = null;

    public EscolaDao() {
        con = Conection.ConectionFactory.getConection();
    }

    public boolean save(Escola user) {

        String sql = "INSERT INTO escola (nome,media) VALUES (?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setNString(1, user.getNome());
            stmt.setDouble(2, user.getMedia());
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro, Aluno não salvo" + ex);
            return false;
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt);
        }

    }

    public List<Escola> findAll() {
        String sql = "SELECT *FROM escola";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Escola> user = new ArrayList();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Escola us = new Escola();
                us.setNome(rs.getString("nome"));
                user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO, não encontrado");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);
        }
        return user;
    }

    public List<Escola> findAlgum(String a) {// array do tipo aluno
        String sql = "SELECT *FROM escola WHERE nome LIKE ?";//selecionando todos os componentes da tabela
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Escola> user = new ArrayList();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setNString(1, "%" + a + "%");
            rs = stmt.executeQuery();// executando o select from 

            while (rs.next()) {// while para adicionar o objeto aluno na arraylist do tipo aluno
                Escola us = new Escola();
                us.setNome(rs.getString("nome"));
                us.setMedia(Double.parseDouble(rs.getNString("media")));
                user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO, Não encontrado");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);// fechando conecção 
        }
        return user;
    }

    public boolean update(Escola user, int id) {
        String sql3 = "UPDATE escola SET nome = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql3);
            stmt.setNString(1, user.getNome());
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro, Não Atualizado" + ex);
            return false;
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt);
        }

    }

    public boolean delete(int id) {
        String sql3 = "DELETE FROM escola WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql3);
            stmt.setInt(1, id); // id
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro, Não Excluido" + ex);
            return false;
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt);
        }

    }

}
