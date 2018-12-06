package poo.biblioteca.dao;

import poo.biblioteca.model.Reservation;
import poo.biblioteca.util.ConnectionBibliotecaFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    public void insert(Reservation reservation) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "INSERT INTO RESERVA (id, id_livro, id_usuario, data) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reservation.getId());
            ps.setInt(2, reservation.getBookId());
            ps.setInt(3, reservation.getUserId());
            ps.setDate(4, new java.sql.Date(reservation.getDate().getTime()));

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

            String sql = "DELETE FROM RESERVA WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }

    public void update(Reservation reservation) {

        Connection conn = null;

        try {
            conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "UPDATE RESERVA SET " +
                    "id_livro = ?, id_usuario = ?, data = ?" +
                    "WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reservation.getBookId());
            ps.setInt(2, reservation.getUserId());
            ps.setDate(3, new java.sql.Date(reservation.getDate().getTime()));
            ps.setInt(4, reservation.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionBibliotecaFactory.close(conn);
        }
    }

    public List<Reservation> listAll() {

        try {
            Connection conn = ConnectionBibliotecaFactory.getConnection();

            String sql = "SELECT * FROM RESERVA";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Reservation> reservations = new ArrayList<Reservation>();

            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(rs.getInt(1));
                reservation.setBookId(rs.getInt(2));
                reservation.setUserId(rs.getInt(3));
                reservation.setDate(rs.getDate(4));

                reservations.add(reservation);
            }

            ConnectionBibliotecaFactory.close(conn);

            return reservations;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
