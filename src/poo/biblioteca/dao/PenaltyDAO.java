package poo.biblioteca.dao;

import poo.biblioteca.model.Book;
import poo.biblioteca.model.Penalty;
import poo.biblioteca.util.ConnectionBibliotecaFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PenaltyDAO {

    public void insert(Penalty penalty) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "INSERT INTO MULTA (id, id_emprestimo, descricao, valor) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, penalty.getId());
            ps.setInt(2, penalty.getLoanId());
            ps.setString(3, penalty.getDescription());
            ps.setDouble(4, penalty.getValue());

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

            String sql = "DELETE FROM MULTA WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }

    public void update(Penalty penalty) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE MULTA SET " +
                    "id_emprestimo = ?, descricao = ?, valor = ?" +
                    "WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, penalty.getLoanId());
            ps.setString(2, penalty.getDescription());
            ps.setDouble(3, penalty.getValue());
            ps.setInt(4, penalty.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }
    

    public List<Penalty> listAll() {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM MULTA";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Penalty> penalties = new ArrayList<Penalty>();

            while (rs.next()) {
                Penalty penalty = new Penalty();
                penalty.setId(rs.getInt(1));
                penalty.setLoanId(rs.getInt(2));
                penalty.setDescription(rs.getString(3));
                penalty.setValue(rs.getDouble(4));

                penalties.add(penalty);
            }

            ConnectionBibliotecaFactory.close(conn);

            return penalties;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
