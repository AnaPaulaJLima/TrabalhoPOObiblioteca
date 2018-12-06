package poo.biblioteca.proxy;

import poo.biblioteca.dao.BookDAO;
import poo.biblioteca.dao.UserDAO;
import poo.biblioteca.model.Book;
import poo.biblioteca.model.User;

import java.util.List;

public class UserDAOProxy extends UserDAO {

    private List<User> cache;
    private static UserDAOProxy instance;

    public UserDAOProxy() {}

    public static UserDAOProxy getInstance() {

        if(instance == null) {
            instance = new UserDAOProxy();
        }

        return instance;
    }

    @Override
    public void insert(User user) {
        super.insert(user);
        cache = null;
    }

    @Override
    public void delete(int id) {

        super.delete(id);
        cache = null;
    }

    @Override
    public void update(User user) {
        super.update(user);
        cache = null;
    }

    public List<User> listAll() {

        if(cache == null) {
            cache = super.listAll();
        }

        return cache;
    }
}
