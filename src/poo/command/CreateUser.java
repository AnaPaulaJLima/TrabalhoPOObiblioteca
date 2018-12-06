package poo.command;

import poo.biblioteca.dao.UserDAO;
import poo.biblioteca.model.User;
import poo.biblioteca.proxy.UserDAOProxy;

import java.util.Scanner;

public class CreateUser implements Command {

    @Override
    public void execute(Scanner scanner) {

        User user = new User();
        System.out.println("Digite o codigo do usuario: ");
        user.setId(scanner.nextInt());
        System.out.println("Digite o nome do usuario: ");
        user.setName(scanner.next());
        scanner.nextLine();
        user.setGender(selectGender(scanner));
        user.setCategory(selectCategory(scanner));
        System.out.println("Digite o endereco do usuario: ");
        user.setAddress(scanner.next());
        scanner.nextLine();
        System.out.println("Digite o telefone do usuario: ");
        user.setPhone(scanner.next());

        UserDAO dao = UserDAOProxy.getInstance();
        dao.insert(user);
    }

    private String selectGender(Scanner scanner) {

        int option = 0;

        do {
            System.out.println("Selecione o sexo do usuario: ");
            System.out.println("1 - Feminino");
            System.out.println("2 - Masculino");
            option = scanner.nextInt();

            if(option != 1 && option != 2) {
                System.out.println("Opcao invalida, digite novamente.\n");
            }

        } while (option != 1 && option != 2);

        String response;

        switch (option) {
            case 1:
                response = "Feminino";
                break;
            case 2:
                response = "Masculino";
                break;
            default:
                response = "";
                break;
        }

        return response;
    }

    private String selectCategory(Scanner scanner) {

        String option = "0";

        do {
            System.out.println("Selecione a categoria do usuario: ");
            System.out.println("1 - Aluno");
            System.out.println("2 - Professor");
            System.out.println("3 - Funcionario");
            System.out.println("4 - Comunidade");
            System.out.println("5 - Administrador");
            option = scanner.next();
            scanner.nextLine();

            if(!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("5")) {
                System.out.println("Opcao invalida, digite novamente.\n");
            }

        } while (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("5"));

        String response;

        switch (option) {
            case "1":
                response = "Aluno";
                break;
            case "2":
                response = "Professor";
                break;
            case "3":
                response = "Funcionario";
                break;
            case "4":
                response = "Comunidade";
                break;
            case "5":
                response = "Administrador";
                break;
            default:
                response = "Comunidade";
                break;
        }

        return response;
    }
}
