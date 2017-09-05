package by.home.command.student.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.entity.Student;

@Component
public class GoToUpdateStudent extends BaseCommand {

	private static final String ID = "id";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException  {
		Student student = new Student();
		String sId = request.getParameter(ID);
		student.setId(Integer.valueOf(sId));
		student.setFirstName(request.getParameter(FIRST_NAME));
		student.setLastName(request.getParameter(LAST_NAME));

		request.setAttribute("student", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update_student.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException("Could not go to the page");
		}

	}

}
