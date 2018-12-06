package poo.command;

import java.util.Scanner;

import poo.biblioteca.dao.BookDAO;
import poo.biblioteca.model.Book;

public class RemoveBook implements Command{
	private int id;
	@Override
	public void execute(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("\nInsira o id do livro: ");
		id = scanner.nextInt();
		
		BookDAO book = new BookDAO();
		book.delete(id);
		
		
		
	}

}
