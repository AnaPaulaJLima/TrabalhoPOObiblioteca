package poo.biblioteca.menu;

import java.util.Locale;
import java.util.Scanner;

import poo.biblioteca.util.ComandOpcao;

public class MenuEditUser implements Menu{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		 	System.out.println("*******************************************************");
	        System.out.println("*           MENU DE OPCOES - EDITAR USUARIO           *");
	        System.out.println("*******************************************************");
	        System.out.println("* 1) SELECIONAR POR NOME                              *");
	        System.out.println("* 2) SELECIONAR POR TELEFONE                          *");
	        System.out.println("* 3) SELECIONAR POR ENDERECO                          *");
	        System.out.println("* 0) SAIR                                             *");
	        System.out.println("*                                                     *");
	        System.out.println("*******************************************************");
	          
		
	}

	@Override
	public int chooseOption(Scanner scanner) {
		// TODO Auto-generated method stub
		
		 int option = 0;
	        scanner.useLocale(Locale.US);

	        ComandOpcao comandOpcao = ComandOpcao.getInstance(true);

	
	            show();
	            option = scanner.nextInt();
	            comandOpcao.getCommand(option).execute(scanner);

	

	        scanner.close();

	        return 0;
	        
	}

}
