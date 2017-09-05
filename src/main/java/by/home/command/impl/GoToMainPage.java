package by.home.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;

@Component
public class GoToMainPage extends BaseCommand {

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		try {
			request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException("Could not go to the page");
		}

	}

}