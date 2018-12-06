package poo.biblioteca.dao;

import poo.biblioteca.model.Book;
import poo.biblioteca.util.ConnectionBibliotecaFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void insert(Book book) {
        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "INSERT INTO LIVRO (id, autor, titulo, categoria, prioridade, disponibilidade, ano) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, book.getId());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getTitle());
            ps.setString(4, book.getCategory());
            ps.setString(5, book.getPriority());
            ps.setBoolean(6, book.isAvailable());
            ps.setInt(7, book.getYear());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }

    public void delete(int id) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "DELETE FROM LIVRO WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }

    public void UpdateName(String book,String book2) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE LIVRO SET titulo = ? where titulo = ?" ;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, book2);
            ps.setString(2, book);
            
           

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    
    public void UpdateAutor(String book,String book2) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE LIVRO SET autor = ? where autor = ?" ;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, book2);
            ps.setString(2, book);
            
           

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    
    
    public void UpdateCategoria(String book,String book2) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE LIVRO SET categoria = ? where categoria = ?" ;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, book2);
            ps.setString(2, book);
            
           

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    
    public List<Book> listName(String nome) {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM LIVRO WHERE titulo = ?  ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            List<Book> books = new ArrayList<Book>();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setAuthor(rs.getString(2));
                book.setTitle(rs.getString(3));
                book.setCategory(rs.getString(4));
                book.setPriority(rs.getString(5));
                book.setAvailable(rs.getBoolean(6));
                book.setYear(rs.getInt(7));

                books.add(book);
            }

            ConnectionBibliotecaFactory.close(conn);

            return books;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Boolean listId(int id) {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM LIVRO WHERE id = ?  ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Book books = new Book();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setAuthor(rs.getString(2));
                book.setTitle(rs.getString(3));
                book.setCategory(rs.getString(4));
                book.setPriority(rs.getString(5));
                book.setAvailable(rs.getBoolean(6));
                book.setYear(rs.getInt(7));
                books=(book);
            }
            

            ConnectionBibliotecaFactory.close(conn);
            if (books.getId() == 0 || books.getAvailable() == false) 
            	return false;
            else 
            	return true;
            

            

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public List<Book> listAll() {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM LIVRO";

            PreparedStatement ps = conn.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();

            List<Book> books = new ArrayList<Book>();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setAuthor(rs.getString(2));
                book.setTitle(rs.getString(3));
                book.setCategory(rs.getString(4));
                book.setPriority(rs.getString(5));
                book.setAvailable(rs.getBoolean(6));
                book.setYear(rs.getInt(7));

                books.add(book);
            }

            ConnectionBibliotecaFactory.close(conn);

            return books;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void updateDisponibilidade(int book) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE LIVRO SET disponibilidade = false " +
                    "WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, book);
    

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    
    
    
    public List<Book> listAutor(String nome) {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM LIVRO WHERE autor = ?  ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            List<Book> books = new ArrayList<Book>();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setAuthor(rs.getString(2));
                book.setTitle(rs.getString(3));
                book.setCategory(rs.getString(4));
                book.setPriority(rs.getString(5));
                book.setAvailable(rs.getBoolean(6));
                book.setYear(rs.getInt(7));

                books.add(book);
            }

            ConnectionBibliotecaFactory.close(conn);

            return books;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Book> listCategoria(String nome) {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM LIVRO WHERE categoria = ?  ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            List<Book> books = new ArrayList<Book>();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setAuthor(rs.getString(2));
                book.setTitle(rs.getString(3));
                book.setCategory(rs.getString(4));
                book.setPriority(rs.getString(5));
                book.setAvailable(rs.getBoolean(6));
                book.setYear(rs.getInt(7));

                books.add(book);
            }

            ConnectionBibliotecaFactory.close(conn);

            return books;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Book> listDisponibilidade(String nome) {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM LIVRO WHERE disponibilidade = ?  ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            List<Book> books = new ArrayList<Book>();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setAuthor(rs.getString(2));
                book.setTitle(rs.getString(3));
                book.setCategory(rs.getString(4));
                book.setPriority(rs.getString(5));
                book.setAvailable(rs.getBoolean(6));
                book.setYear(rs.getInt(7));

                books.add(book);
            }

            ConnectionBibliotecaFactory.close(conn);

            return books;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
