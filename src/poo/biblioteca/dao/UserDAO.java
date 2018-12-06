package poo.biblioteca.dao;

import poo.biblioteca.model.Book;
import poo.biblioteca.model.User;
import poo.biblioteca.util.ConnectionBibliotecaFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void insert(User user) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "INSERT INTO USUARIO (id, nome, categoria, sexo, endereco, telefone) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getCategory());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPhone());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    public User listId(int id) {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM usuario WHERE id = ?  ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
           User users = new User();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setCategory(rs.getString(3));
                user.setGender(rs.getString(4));
                user.setAddress(rs.getString(5));
                user.setPhone(rs.getString(6));

                users = (user);
            }

            ConnectionBibliotecaFactory.close(conn);
            

            ConnectionBibliotecaFactory.close(conn);
            if (users.getId() == 0) 
            	return null;
            else 
            	return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "DELETE FROM USUARIO WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }

    public void update(User user) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE USUARIO SET " +
                    "nome = ?, categoria = ?, sexo = ?, endereco = ?, telefone = ?" +
                    "WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getCategory());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getPhone());
            ps.setInt(6, user.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    
    public void updateName(String orginal, String modificado) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE USUARIO SET nome = ? WHERE nome = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,modificado);
            ps.setString(2,orginal);
            
            

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    public void updateEndereco(String orginal, String modificado) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE USUARIO SET endereco = ? WHERE endereco = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,modificado);
            ps.setString(2,orginal);
            
            

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    
    public void updateTelefone(String orginal, String modificado) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE USUARIO SET telefone = ? WHERE telefone = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,modificado);
            ps.setString(2,orginal);
            
            

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    
    
    public void updatezz(User user) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE USUARIO SET " +
                    "nome = ?, categoria = ?, sexo = ?, endereco = ?, telefone = ?" +
                    "WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getCategory());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getPhone());
            ps.setInt(6, user.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    
    public void updateKK(User user) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE USUARIO SET " +
                    "nome = ?, categoria = ?, sexo = ?, endereco = ?, telefone = ?" +
                    "WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getCategory());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getPhone());
            ps.setInt(6, user.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }

    public List<User> listAll() {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM USUARIO";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<User> users = new ArrayList<User>();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setCategory(rs.getString(3));
                user.setGender(rs.getString(4));
                user.setAddress(rs.getString(5));
                user.setPhone(rs.getString(6));

                users.add(user);
            }

            ConnectionBibliotecaFactory.close(conn);

            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
