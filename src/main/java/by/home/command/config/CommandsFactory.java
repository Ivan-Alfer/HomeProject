package by.home.command.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.home.command.Command;
import by.home.controller.CommandNames;

@Component

public class CommandsFactory {
	
	@Autowired
	private Map<CommandNames, Command> commands;
	
	public Command getCommand(String name){
		
		CommandNames commandName = CommandNames.valueOf(name.toUpperCase());
		Command command = commands.get(commandName);
		return command;
		
	}
}
