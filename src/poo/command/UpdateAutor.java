package poo.command;

import java.util.Scanner;

import poo.biblioteca.dao.BookDAO;

public class UpdateAutor implements Command{

	@Override
	public void execute(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("\nInsira o nome do autor para pesquisa: ");
		String nome = scanner.next();
		System.out.println("\nInsira o novo do autor: ");
		String nome2 = scanner.next();
		
		BookDAO book = new BookDAO();
		book.UpdateAutor(nome,nome2);
		
	}

}
