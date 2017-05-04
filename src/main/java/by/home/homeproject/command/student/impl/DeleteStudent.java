package by.home.homeproject.command.student.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.ServiceException;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.service.ServiceFactory;
import by.home.homeproject.service.StudentService;

public class DeleteStudent extends BaseCommand {

	private static final String ID = "id";

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String sId = request.getParameter(ID);
		Integer id = Integer.valueOf(sId);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();

		try {
			studentService.deleteStudent(id);
		} catch (ServiceException e) {
			throw new CommandException();
		}

		try {
			response.sendRedirect("/HomeProject/all_students");
		} catch (IOException e) {
			throw new CommandException();
		}
	}
}
