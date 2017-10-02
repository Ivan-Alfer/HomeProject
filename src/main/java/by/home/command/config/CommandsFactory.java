package by.home.command.config;

import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import by.home.command.Command;
import by.home.controller.CommandNames;

@Component
@ComponentScan("by.home")
public class CommandsFactory {
	
	//@Autowired
	private Map<CommandNames, Command> commands;
	
	public Map<CommandNames, Command> getCommands() {
		return commands;
	}

	public void setCommands(Map<CommandNames, Command> commands) {
		this.commands = commands;
	}

	public Command getCommand(String name){
		
		CommandNames commandName = CommandNames.valueOf(name.toUpperCase());
		Command command = commands.get(commandName);
		return command;
		
	}
}
