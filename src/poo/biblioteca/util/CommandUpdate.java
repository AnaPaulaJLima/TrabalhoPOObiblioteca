package poo.biblioteca.util;

import java.util.Hashtable;

import poo.command.Command;
import poo.command.CreateBook;
import poo.command.CreateLoan;
import poo.command.CreatePenality;
import poo.command.CreateUser;
import poo.command.Exit;
import poo.command.RemoveBook;
import poo.command.RemoveUser;
import poo.command.SelectAutor;
import poo.command.SelectBookName;
import poo.command.SelectCategoria;
import poo.command.SelectDisponibilidade;
import poo.command.SelectName;
import poo.command.UpdateAutor;
import poo.command.UpdateCategoria;
import poo.command.UpdateName;
import poo.command.selectBook;

public class CommandUpdate {
	private static CommandUpdate instance;
	private Hashtable<Integer, Command> commands = new Hashtable<Integer,Command>();
	private CommandUpdate(boolean isAdmin) {

        if(isAdmin) {
        	commands.put(0, new Exit());
        	commands.put(1, new UpdateName());
            commands.put(2, new UpdateAutor());
            commands.put(3, new UpdateCategoria());
            //commands.put(4, new UpdateDisponibilidade());
        } else {
        	commands.put(0, new Exit());
        	commands.put(1, new UpdateName());
            commands.put(2, new UpdateAutor());
            commands.put(3, new UpdateCategoria());
            //commands.put(4, new UpdateDisponibilidade());
        }
    }
	
	public Command getCommand(Integer option) {

        return commands.get(option);

    }

    public static synchronized CommandUpdate getInstance(boolean isAdmin) {
        if(instance == null) {
            instance = new CommandUpdate(isAdmin);
        }
        return instance;
    }

}
