package poo.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poo.biblioteca.dao.BookDAO;
import poo.biblioteca.dao.UserDAO;
import poo.biblioteca.model.Book;
import poo.biblioteca.model.User;
import poo.biblioteca.proxy.UserDAOProxy;

public class selectBook implements Command {
	@Override
    public void execute(Scanner scanner) {

        BookDAO book = new BookDAO();
        List<Book> books = new ArrayList<Book>();
        books = book.listAll();
        for(Book bo : books) {
        	System.out.println("\n\nAutor: " + bo.getAuthor() + "\nCategoria: "+ bo.getCategory()
        	+"\nPrioridade: "+ bo.getPriority() + "\nTítulo: " + bo.getTitle());
        }
    }
}
