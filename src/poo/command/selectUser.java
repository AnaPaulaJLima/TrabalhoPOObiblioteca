package poo.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poo.biblioteca.dao.UserDAO;
import poo.biblioteca.model.User;

public class selectUser implements Command {

	@Override
	public void execute(Scanner scanner) {
		
		UserDAO user = new UserDAO();
		List<User> users = new ArrayList<User>();
		users = user.listAll();
		for (User us : users ) {
			System.out.println("\n\nId do usu�rio: " + us.getId() + "\nNome do usu�rio: " + us.getName() 
									+ "\nCategoria: " + us.getCategory() + "\nTelefone: " + us.getPhone() 
										+ "\nSexo: " + us.getGender());
		}
		
	}

}
