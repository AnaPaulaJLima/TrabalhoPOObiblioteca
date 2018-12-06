package poo.biblioteca.menu;

import poo.biblioteca.util.ComandOpcao;
import poo.biblioteca.util.CommandList;
import poo.biblioteca.util.CommandUpdate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.*;


public class MenuFuncionario implements Menu {
	private MenuLivro menuLivro= new MenuLivro();
	private MenuEditUser menuLivros= new MenuEditUser();
    @Override
    public void show() {

        System.out.println("\n*******************************************************");
        System.out.println("*           MENU DE OPCOES - FUNCIONÁRIOS             *");
        System.out.println("*******************************************************");
        System.out.println("* 1) CADASTRAR LIVRO                                  *");
        System.out.println("* 2) CADASTRAR USUARIO                                *");
        System.out.println("* 3) CADASTRAR EMPRESTIMO                             *");
        System.out.println("* 4) LISTAR TODOS OS LIVROS                           *");
        System.out.println("* 5) CONSULTAR LIVROS               	              *");
        System.out.println("* 6) CADASTRAR MULTA                                  *");
        System.out.println("* 7) REMOVER USUARIO  	               	              *");
        System.out.println("* 8) REMOVER LIVRO                                    *");
        System.out.println("* 9) ALTERAR LIVRO                                    *");
        System.out.println("* 10) ALTERAR USUARIO                  	              *");
        System.out.println("* 11) LISTAR TODOS OS EMPRESTIMOS      	              *");
        System.out.println("* 12) LISTAR TODOS OS USUÁRIOS                        *");
        System.out.println("* 0) SAIR                                             *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");
          
    }

    @Override
    public int chooseOption(Scanner scanner) {

        int option = 0;
        scanner.useLocale(Locale.US);

        CommandList commandList = CommandList.getInstance(true);
        ComandOpcao comandOpcao = ComandOpcao.getInstance(true);
        CommandUpdate comandUpdate = CommandUpdate.getInstance(true);

        do {
            show();
            option = scanner.nextInt();
            if (option == 9) {
            	menuLivro.show();
                option = scanner.nextInt();
                comandUpdate.getCommand(option).execute(scanner);
            }
            
            else if((option == 10)) {
            	 menuLivros.show();
                option = scanner.nextInt();
               comandUpdate.getCommand(option).execute(scanner);
            }
            else if(!(option == 5))
                commandList.getCommand(option).execute(scanner);
            else{
            menuLivro.show();
            option = scanner.nextInt();
            comandOpcao.getCommand(option).execute(scanner);
            }

        } while (option != 0);

        scanner.close();

        return 0;
    }
}
