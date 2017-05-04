package by.home.homeproject.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.entity.Mark;
import by.home.homeproject.service.MarkService;
import by.home.homeproject.service.ServiceFactory;

public class ShowAll extends BaseCommand {

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		List<Mark> marks;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markDao = serviceFactory.getMarkService();

		marks = markDao.getAllEntities();

		request.setAttribute("marks", marks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}
	}
}
