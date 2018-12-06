package poo;

import poo.biblioteca.dao.UserDAO;
import poo.biblioteca.menu.MenuFuncionario;
import poo.biblioteca.menu.MenuUsuario;
import poo.biblioteca.model.User;

import java.util.Scanner;



public class Application {

    public static void main(String[] args) {
    	
    	
    	System.out.println("\n*******************************************************");
        System.out.println("*                   BIBLIOTECA CULTURA                  *");
        System.out.println("*********************************************************");
        System.out.println("*                        ACESSO                         *");
        System.out.println("* DIGITE O ID DO USUÁRIO:                               *");
        Scanner entrada = new Scanner(System.in);
        int id = 0 ;
        id = (entrada.nextInt());
        
        String tipo = new String ("Funcionario");
        UserDAO dao = new UserDAO();
        User user = new User();
        user = dao.listId(id);
        
        if(user == null){
        	System.out.println("\nUsuário não encontrado na base de dados!!");
        }else {
        	if(tipo.equals(user.getCategory())) {
        		
        		MenuFuncionario menuFuncionario = new MenuFuncionario();

                menuFuncionario.chooseOption(new Scanner(System.in));        		
        	}else {
        		
        		MenuUsuario menuUsuario = new MenuUsuario();

                menuUsuario.chooseOption(new Scanner(System.in));
        		
        		
        	}
        }
        
        

        
    }
}
