package poo.biblioteca.proxy;

import poo.biblioteca.dao.BookDAO;
import poo.biblioteca.model.Book;
import poo.biblioteca.util.ConnectionBibliotecaFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOProxy extends BookDAO {

    private List<Book> cache;
    private static BookDAOProxy instance;

    public BookDAOProxy() {}

    public static BookDAOProxy getInstance() {

        if(instance == null) {
            instance = new BookDAOProxy();
        }

        return instance;
    }

    @Override
    public void insert(Book book) {
        super.insert(book);
        cache = null;
    }

    @Override
    public void delete(int id) {

        super.delete(id);
        cache = null;
    }

    

    public List<Book> listAll() {

        if(cache == null) {
            cache = super.listAll();
        }

        return cache;
    }
}
