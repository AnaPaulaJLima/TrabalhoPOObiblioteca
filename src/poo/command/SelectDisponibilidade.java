package poo.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poo.biblioteca.dao.BookDAO;
import poo.biblioteca.model.Book;

public class SelectDisponibilidade implements Command{

	@Override
	public void execute(Scanner scanner) {
		// TODO Auto-generated method stub
		String nome;
        BookDAO book = new BookDAO();
        List<Book> books = new ArrayList<Book>();
        System.out.println("\nDigite o nome da disponibilidade:");
        nome = scanner.next();
        books = book.listDisponibilidade(nome);
        for(Book bo : books) {
        	System.out.println("\n\nAutor: " + bo.getAuthor() + "\nCategoria: "+ bo.getCategory()
        	+"\nPrioridade: "+ bo.getPriority() + "\nTítulo: " + bo.getTitle());
        }
		
	}

}
