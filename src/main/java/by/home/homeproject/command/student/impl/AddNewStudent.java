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


public class AddNewStudent extends BaseCommand{

	private static final String FIRST_NAME = "first name";
	private static final String LAST_NAME = "last name";
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		
		
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();
		
		try {
			studentService.addStudent(student);
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
