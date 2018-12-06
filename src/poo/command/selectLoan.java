package poo.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poo.biblioteca.dao.LoanDAO;
import poo.biblioteca.model.Loan;

public class selectLoan implements Command {

	@Override
	public void execute(Scanner scanner) {
	
		LoanDAO loan = new LoanDAO();
		List<Loan> loans = new ArrayList<Loan>();
		loans = loan.listAll();
		for (Loan lo : loans) {
			System.out.println("\n\nId livro: " + lo.getBookId() + "\nId do autor: " + lo.getAuthorId() 
									+ "\nId do usuário: " + lo.getUserId());
		}
		
	}

}
