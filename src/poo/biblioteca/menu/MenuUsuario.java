package poo.biblioteca.menu;

import java.util.Locale;
import java.util.Scanner;

import poo.biblioteca.util.ComandOpcao;
import poo.biblioteca.util.CommandList;
import poo.biblioteca.util.CommandUpdate;

public class MenuUsuario implements Menu{
	
	private MenuLivro menuLivro= new MenuLivro();

	public void show() {
		System.out.println("\n*******************************************************");
        System.out.println("*            MENU DE OPCOES - USUARIO                 *");
        System.out.println("*******************************************************");
        System.out.println("* 1) LISTAR TODOS OS LIVROS                           *");
        System.out.println("* 2) CONSULTAR LIVROS               	              *");
        //System.out.println("* 3) RESERVAR LIVRO                                   *");
        System.out.println("* 0) SAIR                                             *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");
		
		
	}

	@Override
	public int chooseOption(Scanner scanner) {
		int option = 0;
        scanner.useLocale(Locale.US);
        CommandList commandList = CommandList.getInstance(false);
        ComandOpcao comandOpcao = ComandOpcao.getInstance(true);
        
        do {
        	show();
    	    option = scanner.nextInt();
        	 if(!(option == 2))
                 commandList.getCommand(option).execute(scanner);
             else{
             menuLivro.show();
             option = scanner.nextInt();
             comandOpcao.getCommand(option).execute(scanner);
             }
        	 
        }while(option != 0);
        
        scanner.close();

	    return 0;
        
	}

}
