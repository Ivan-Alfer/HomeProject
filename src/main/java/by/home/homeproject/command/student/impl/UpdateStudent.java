package by.home.homeproject.command.student.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.ServiceException;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.entity.Student;
import by.home.homeproject.service.ServiceFactory;
import by.home.homeproject.service.StudentService;

public class UpdateStudent extends BaseCommand {

	private static final String ID = "id";
	private static final String FIRST_NAME = "first name";
	private static final String LAST_NAME = "last name";

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		Student student = new Student();
		String sId = request.getParameter(ID);
		student.setId(Integer.valueOf(sId));
		student.setFirstName(request.getParameter(FIRST_NAME));
		student.setLastName(request.getParameter(LAST_NAME));

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();

		try {
			studentService.updateStudent(student);
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
