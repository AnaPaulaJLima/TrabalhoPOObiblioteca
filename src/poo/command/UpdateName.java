package poo.command;

import java.util.Scanner;

import poo.biblioteca.dao.BookDAO;
import poo.biblioteca.dao.UserDAO;

public class UpdateName implements Command{

	@Override
	public void execute(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("\nInsira o nome do usuario para pesquisa: ");
		String nome = scanner.next();
		System.out.println("\nInsira o novo nome do usuario: ");
		String nome2 = scanner.next();
		
		UserDAO user = new UserDAO();
		user.updateName(nome, nome2);
	}

}
