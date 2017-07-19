package by.home.command.mark.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.entity.Student;
import by.home.service.ServiceFactory;
import by.home.service.StudentService;
import by.home.service.exception.ServiceException;

public class GoToAddMark extends BaseCommand {

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();

		List<Student> students;
		try {
			students = studentService.getStudents();
		} catch (ServiceException e1) {
			throw new CommandException();
		}

		request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_mark.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}

	}

}