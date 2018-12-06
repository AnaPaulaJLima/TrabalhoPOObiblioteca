package poo.command;

import java.util.Scanner;

public class Exit implements Command {

    @Override
    public void execute(Scanner scanner) {

        System.out.println("\n\t\t Sessao encerrada!");
    }
}
