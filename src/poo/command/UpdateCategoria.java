package poo.command;

import java.util.Scanner;

import poo.biblioteca.dao.BookDAO;

public class UpdateCategoria implements Command{

	@Override
	public void execute(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("\nInsira o nome da categoria para pesquisa: ");
		String nome = scanner.next();
		System.out.println("\nInsira o novo da categoria: ");
		String nome2 = scanner.next();
		
		BookDAO book = new BookDAO();
		book.UpdateCategoria(nome,nome2);
		
	}

}
