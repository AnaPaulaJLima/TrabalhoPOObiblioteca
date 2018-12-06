package poo.biblioteca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBibliotecaFactory {

    private static final String DB_URI = "jdbc:hsqldb:hsql://localhost/bibliotecadb";
    private static final String SQL_USER = "sa";
    private static final String SQL_PASS = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URI, SQL_USER, SQL_PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
