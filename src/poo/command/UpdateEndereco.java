package poo.command;

import java.util.Scanner;

import poo.biblioteca.dao.BookDAO;
import poo.biblioteca.dao.UserDAO;

public class UpdateEndereco implements Command{

	@Override
	public void execute(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("\nInsira o nome do endereço para pesquisa: ");
		String nome = scanner.next();
		System.out.println("\nInsira o novo endereco: ");
		String nome2 = scanner.next();
		
		UserDAO user = new UserDAO();
		user.updateEndereco(nome, nome2);
		
	}

}
