package by.home.homeproject.command.mark.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.entity.Student;
import by.home.homeproject.service.ServiceFactory;
import by.home.homeproject.service.StudentService;

public class GoToAddMark extends BaseCommand {

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();

		List<Student> students = studentService.getStudents();

		request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_mark.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}

	}

}