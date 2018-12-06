package poo.command;

import java.util.Scanner;

import poo.biblioteca.dao.UserDAO;

public class RemoveUser implements Command{
	private int id;
	@Override
	public void execute(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("\nInsira o id do usuario:");
		id = scanner.nextInt();
		
		UserDAO user = new UserDAO();
		user.delete(id);
	}

}
