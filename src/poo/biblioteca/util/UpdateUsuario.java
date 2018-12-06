package poo.biblioteca.util;

import java.util.Hashtable;

import poo.command.Command;
import poo.command.Exit;
import poo.command.UpdateAutor;
import poo.command.UpdateCategoria;
import poo.command.UpdateEndereco;
import poo.command.UpdateName;
import poo.command.UpdateTelefone;

public class UpdateUsuario {
	private static UpdateUsuario instance;
	private Hashtable<Integer, Command> commands = new Hashtable<Integer,Command>();
	private UpdateUsuario(boolean isAdmin) {

        if(isAdmin) {
        	commands.put(0, new Exit());
        	commands.put(1, new UpdateName());
        	 commands.put(2, new UpdateTelefone());
             commands.put(3, new UpdateEndereco());
            //commands.put(4, new UpdateDisponibilidade());
        } else {
        	commands.put(0, new Exit());
        	commands.put(1, new UpdateName());
            commands.put(2, new UpdateTelefone());
            commands.put(3, new UpdateEndereco());
            //commands.put(4, new UpdateDisponibilidade());
        }
    }
	
	public Command getCommand(Integer option) {

        return commands.get(option);

    }

    public static synchronized UpdateUsuario getInstance(boolean isAdmin) {
        if(instance == null) {
            instance = new UpdateUsuario(isAdmin);
        }
        return instance;
    }

}
