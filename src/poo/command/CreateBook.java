package poo.command;

import poo.biblioteca.dao.BookDAO;
import poo.biblioteca.model.Book;
import poo.biblioteca.proxy.BookDAOProxy;

import java.util.Scanner;

public class CreateBook implements Command {

    @Override
    public void execute(Scanner scanner) {

        Book book = new Book();
        System.out.println("Digite o codigo do livro: ");
        book.setId(scanner.nextInt());
        System.out.println("Digite o titulo do livro: ");
        book.setTitle(scanner.next());
        scanner.nextLine();
        System.out.println("Digite o autor do livro: ");
        book.setAuthor(scanner.next());
        scanner.nextLine();
        System.out.println("Digite a categoria do livro: ");
        book.setCategory(scanner.next());
        scanner.nextLine();
        System.out.println("Digite o ano do livro: ");
        book.setYear(scanner.nextInt());
        book.setPriority(selectPriority(scanner));

        book.setAvailable(true);

        BookDAO dao = BookDAOProxy.getInstance();
        dao.insert(book);
    }

    private String selectPriority(Scanner scanner) {

        String option = "0";

        do {
            System.out.println("Selecione a prioridade do livro: ");
            System.out.println("1 - Baixa");
            System.out.println("2 - Media");
            System.out.println("3 - Alta");
            option = scanner.next();
            scanner.nextLine();

            if(!option.equals("1") && !option.equals("2") && !option.equals("3")) {
                System.out.println("Opcao invalida, digite novamente.\n");
            }

        } while (!option.equals("1") && !option.equals("2") && !option.equals("3"));

        String response;

        switch (option) {
            case "1":
                response = "Baixa";
                break;
            case "2":
                response = "Media";
                break;
            case "3":
                response = "Alta";
                break;
            default:
                response = "";
                break;
        }

        return response;
    }
}
