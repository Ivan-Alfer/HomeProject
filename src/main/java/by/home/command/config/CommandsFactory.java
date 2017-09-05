package by.home.command.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import by.home.command.Command;

@Component
public class CommandsFactory {
	
	@Autowired
	private ApplicationContext context;
	
	public Command getCommand(String commandName){
		Command command = (Command) context.getBean(commandName);
		return command;
	}
}
