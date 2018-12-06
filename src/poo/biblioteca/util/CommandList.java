package poo.biblioteca.util;

import poo.command.*;

import java.util.Hashtable;

public class CommandList {

    private static CommandList instance;
    private Hashtable<Integer, Command> commands = new Hashtable<Integer, Command>();

    private CommandList(boolean isAdmin) {

        if(isAdmin) {
            commands.put(0, new Exit());
            commands.put(1, new CreateBook());
            commands.put(2, new CreateUser());
            commands.put(3, new CreateLoan());
            commands.put(4,new selectBook());
            commands.put(5, new SelectBookName());
            commands.put(6, new CreatePenality());
            commands.put(7, new RemoveUser());
            commands.put(8, new RemoveBook());
            commands.put(11, new selectLoan());
            commands.put(12, new selectUser());
            
        } else {
            commands.put(0, new Exit());
            commands.put(1, new selectBook());
            commands.put(2, new SelectBookName());
            //commands.put(3, new CreateReserve());
            
        }
    }

    public Command getCommand(Integer option) {

        return commands.get(option);

    }

    public static synchronized CommandList getInstance(boolean isAdmin) {

        if(instance == null) {
            instance = new CommandList(isAdmin);
        }

        return instance;
    }
}
