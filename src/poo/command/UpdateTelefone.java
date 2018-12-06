package poo.command;

import java.util.Scanner;

import poo.biblioteca.dao.UserDAO;

public class UpdateTelefone implements Command{

	@Override
	public void execute(Scanner scanner) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("\nInsira o nome do telefone para pesquisa");
				String nome = scanner.next();
				System.out.println("\nInsira o novo nome do telefone do usuario");
				String nome2 = scanner.next();
				
				UserDAO user = new UserDAO();
				user.updateTelefone(nome, nome2);
		
	}

}
