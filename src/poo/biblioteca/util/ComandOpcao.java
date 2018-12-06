package poo.biblioteca.util;

import java.util.Hashtable;

import poo.command.Command;
import poo.command.Exit;
import poo.command.SelectAutor;
import poo.command.SelectCategoria;
import poo.command.SelectDisponibilidade;
import poo.command.SelectName;

public class ComandOpcao{
	 private static ComandOpcao instance;
	    private Hashtable<Integer, Command> commands = new Hashtable<Integer, Command>();

	    private ComandOpcao(boolean isAdmin) {

	        if(isAdmin) {
	        	commands.put(0, new Exit());
	            commands.put(1, new SelectName());
	            commands.put(2, new SelectAutor());
	            commands.put(3, new SelectCategoria());
	            commands.put(4, new SelectDisponibilidade());
	            
	        } else {
	        	commands.put(0, new Exit());
	        	commands.put(1, new SelectName());
	            commands.put(2, new SelectAutor());
	            commands.put(3, new SelectCategoria());
	            commands.put(4, new SelectDisponibilidade());
	        }
	    }

	    public Command getCommand(Integer option) {

	        return commands.get(option);

	    }

	    public static synchronized ComandOpcao getInstance(boolean isAdmin) {

	        if(instance == null) {
	            instance = new ComandOpcao(isAdmin);
	        }

	        return instance;
	    }

}
