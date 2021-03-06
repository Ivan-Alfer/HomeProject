package by.home.command.student.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.service.StudentService;
import by.home.service.exception.ServiceException;

@Component
public class DeleteStudent extends BaseCommand {

	private static final String ID = "id";

	@Autowired
	private StudentService studentService;
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String sId = request.getParameter(ID);
		Integer id = Integer.valueOf(sId);

		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();*/

		try {
			studentService.deleteStudent(id);
			//studentService.deleteStudent(id);
		} catch (ServiceException e) {
			throw new CommandException("Could not delete student");
		}

		try {
			response.sendRedirect("/HomeProject/all_students");
		} catch (IOException e) {
			throw new CommandException(e);
		}
	}
}
