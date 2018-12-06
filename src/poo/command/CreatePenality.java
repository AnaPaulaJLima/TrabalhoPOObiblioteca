package poo.command;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import poo.biblioteca.dao.LoanDAO;
import poo.biblioteca.dao.UserDAO;
import poo.biblioteca.model.Loan;
import poo.biblioteca.model.User;

public class CreatePenality implements Command{
	private User emprestimo = new User();
	@Override
	public void execute(Scanner scanner) {
		
		// TODO Auto-generated method stub
		int cod_multa;
		String descricao;
		System.out.println("Digite o codigo da multa ");
		cod_multa = scanner.nextInt();
		
		 System.out.println("Insira o codigo do emprestimo");
		 int id_emprestimo = scanner.nextInt();
		 UserDAO user = new UserDAO();
		 
		 emprestimo = user.listId(id_emprestimo);
		 
		 if(emprestimo.getClass() != null) {
		 LoanDAO loan = new LoanDAO();
		 Loan loans = new Loan();
		 loans = loan.listIds(id_emprestimo);
		 System.out.println(loans.getEndDate().toString());
			 
		 System.out.println("Insira a descrição ");
		 descricao = scanner.next();
		 System.out.println("Insira a data de devolução");
		 String datas = scanner.next();//depois mudar para data atual do sistema 
		 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		 try {
			Date data = formato.parse(datas);
		 } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 //diferença entre dias
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	     df.setLenient(false);
	     Date d1,d2;
			try {
				d1 = loans.getEndDate();
				System.out.println(d1);
				d2 = df.parse(datas);
				System.out.println(d2);
				long dt = (d2.getTime() - d1.getTime()) + 3600000;
				System.out.println(dt/86400000L);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 }
		 else
		 {
			 System.out.println("emprestimo invalido");
		 }
		 
		
	}

}
