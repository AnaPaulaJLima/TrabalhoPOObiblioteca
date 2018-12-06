package poo.command;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poo.Date.System.Data;
import poo.Date.System.DateSystem;
import poo.biblioteca.dao.BookDAO;
import poo.biblioteca.dao.LoanDAO;
import poo.biblioteca.dao.UserDAO;
import poo.biblioteca.model.Book;
import poo.biblioteca.model.Loan;
import poo.biblioteca.model.User;

public class CreateLoan implements Command {
	
	
	private DateSystem dataSystem = new DateSystem();
	private User usuario = new User();
	
    @Override
    public void execute(Scanner scanner) {
    	Loan loan = new Loan();
    	String inicio,fim;
    	int emprestimo;
    	System.out.println("Insira o codigo do emprestimo");
    	emprestimo = scanner.nextInt();
    	
    	
    		 int id_Livro,id_usuario;
    		//verifica se livro existe no bd
    		 System.out.println("Insira o codigo do livro");
    		 id_Livro = scanner.nextInt();
    		 BookDAO book = new BookDAO();
    		 Boolean books;
    		 books = (Boolean) book.listId(id_Livro);
    		 
    		 
    		 //verifica se usuario existe no bd
    		 System.out.println("Insira o codigo do usuario");
    		 id_usuario = scanner.nextInt();
    		 UserDAO user = new UserDAO();
    		 
    		 usuario =  user.listId(id_usuario);
    		 
    		 
    		 
    		 if(books == true && usuario.getClass() != null) {
    			 loan.setId(emprestimo);
    			 loan.setBookId(id_Livro);
    			 loan.setUserId(id_usuario);
    			 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				loan.setBeginDate(dataSystem.getDataSystem());		
				//CommandDevolucao commandDevolucao =  CommandDevolucao.getInstance(true);
			    //commandDevolucao.getCommand("professor").execute(scanner);
			    
			    Data date = new DateSystem();
			    
			    
			    //aqui entra um projeto mas n sei qual posso colocar talvez chainofresponsability
			    if(usuario.getCategory().toLowerCase().equals("professor")) {
			    	loan.setEndDate((Date) dataSystem.adicionarDias(15));
			    }
			    else if (usuario.getCategory().toLowerCase().equals("funcionario")) {
			    	loan.setEndDate((Date) dataSystem.adicionarDias(12));
			    } else if (usuario.getCategory().toLowerCase().equals("aluno")) {
			    	loan.setEndDate((Date) dataSystem.adicionarDias(20));
			    }else
			    	loan.setEndDate( (Date) dataSystem.adicionarDias(8));
			    
			    
			    
			    
			 LoanDAO loanDAO = new LoanDAO();
       		 loanDAO.insert(loan);
       		 book.updateDisponibilidade(id_Livro);
			    
			    
				
				/*
    			 System.out.println("Insira a data de devolução");
    			 fim = scanner.next();
    			 try {
					loan.setEndDate(formato.parse(fim));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			 
    			 LoanDAO loanDAO = new LoanDAO();
        		 loanDAO.insert(loan);
        		 book.updateDisponibilidade(id_Livro);
    		 }
    		 else
    			 System.out.println("dados invalidos");
    		 */
				
				
    		 
    		 

    		 
    	        	
    	     
    		
    }
}
}