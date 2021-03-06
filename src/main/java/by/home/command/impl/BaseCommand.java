package by.home.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.command.Command;
import by.home.command.exception.CommandException;


public abstract class BaseCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			executeRaw(request, response);
		} catch (CommandException e) {
			e.printStackTrace();
		}
	}

	protected abstract void executeRaw(HttpServletRequest request, HttpServletResponse response)
			throws CommandException;
}
