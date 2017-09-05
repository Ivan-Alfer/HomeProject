package by.home.command.student.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.entity.Student;
import by.home.service.StudentService;
import by.home.service.exception.ServiceException;

@Component
public class UpdateStudent extends BaseCommand {
	
	private static final String ID = "id";
	private static final String FIRST_NAME = "first name";
	private static final String LAST_NAME = "last name";
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Student student;

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		String sId = request.getParameter(ID);
		student.setFirstName(request.getParameter(FIRST_NAME));
		student.setId(Integer.valueOf(sId));
		student.setLastName(request.getParameter(LAST_NAME));
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();*/

		
		/*student.setId(Integer.valueOf(sId));
		student.setFirstName(request.getParameter(FIRST_NAME));
		student.setLastName(request.getParameter(LAST_NAME));*/
		
		try {
			studentService.updateStudent(student);
			//studentService.updateStudent(student);
		} catch (ServiceException e) {
			throw new CommandException("Could not update student");
		}

		try {
			response.sendRedirect("/HomeProject/all_students");
		} catch (IOException e) {
			throw new CommandException(e);
		}

	}

}
