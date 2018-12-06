package poo.biblioteca.dao;

import poo.biblioteca.model.Book;
import poo.biblioteca.model.Loan;
import poo.biblioteca.util.ConnectionBibliotecaFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {

    public void insert(Loan loan) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "INSERT INTO EMPRESTIMO (id, id_livro, id_usuario, data_emprestimo, data_devolocao) " +
                    "VALUES (?, ?, ?, ?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, loan.getId());
            ps.setInt(2, loan.getBookId());
            ps.setInt(3, loan.getUserId());
            ps.setDate(4, new java.sql.Date(loan.getBeginDate().getTime()));
            ps.setDate(5, new java.sql.Date(loan.getEndDate().getTime()));

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
        finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    
    public void delete(int id) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "DELETE FROM EMPRESTIMO WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }

    public void update(Loan loan) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE EMPRESTIMO SET " +
                    "id_livro = ?, id_usuario = ?, id_administrador = ?, data_emprestimo = ?, data_devolucao = ?" +
                    "WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, loan.getBookId());
            ps.setInt(2, loan.getUserId());
            ps.setInt(3, loan.getAuthorId());
            ps.setDate(4, new java.sql.Date(loan.getBeginDate().getTime()));
            ps.setDate(5, new java.sql.Date(loan.getEndDate().getTime()));
            ps.setInt(6, loan.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    public Boolean listId(int id) {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM emprestimo WHERE id = ?  ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Loan loans = new Loan();

            while (rs.next()) {
                Loan loan = new Loan();
                loan.setId(rs.getInt(1));
                loan.setBookId(rs.getInt(2));
                loan.setUserId(rs.getInt(3));
                loan.setAuthorId(rs.getInt(4));
                loan.setBeginDate(rs.getDate(5));
                loan.setEndDate(rs.getDate(6));
                loans = (loan);
            }
            ConnectionBibliotecaFactory.close(conn);
            if (loans.getId() == 0) 
            	return false;
            else 
            	return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Loan listIds(int id) {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM emprestimo WHERE id = ?  ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Loan loans = new Loan();
            Loan loan = new Loan();
            while (rs.next()) {
                
                loan.setId(rs.getInt(1));
                loan.setBookId(rs.getInt(2));
                loan.setUserId(rs.getInt(3));
                loan.setBeginDate(rs.getDate(4));
                loan.setEndDate(rs.getDate(5));
                loans = (loan);
            }
            ConnectionBibliotecaFactory.close(conn);
            if (loan.getId() == 0) 
            	return null;
            else 
            	return loan;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public List<Loan> listAll() {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM EMPRESTIMO";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Loan> loans = new ArrayList<Loan>();

            while (rs.next()) {
                Loan loan = new Loan();
                loan.setId(rs.getInt(1));
                loan.setBookId(rs.getInt(2));
                loan.setUserId(rs.getInt(3));
                loan.setAuthorId(rs.getInt(4));
                loan.setBeginDate(rs.getDate(5));
                loan.setEndDate(rs.getDate(6));

                loans.add(loan);
            }

            ConnectionBibliotecaFactory.close(conn);

            return loans;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
