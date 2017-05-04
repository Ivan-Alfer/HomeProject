package by.home.homeproject.command.student.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.entity.Mark;
import by.home.homeproject.service.MarkService;
import by.home.homeproject.service.ServiceFactory;

public class ShowAllAboutStudent extends BaseCommand {

	private static final String ID = "id";

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String sId = request.getParameter(ID);
		Integer studentId = Integer.valueOf(sId);

		List<Mark> marks;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markService = serviceFactory.getMarkService();

		marks = markService.getAllAboutStudent(studentId);

		request.setAttribute("marks", marks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all_about_student.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}

	}

}
