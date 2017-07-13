package by.home.homeproject.command.student.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.service.StudentService;
import by.home.homeproject.service.exception.ServiceException;

public class DeleteStudent extends BaseCommand {

	private static final String ID = "id";

	private StudentService studentService;


	public StudentService getStudentService() {
		return studentService;
	}


	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String sId = request.getParameter(ID);
		Integer id = Integer.valueOf(sId);

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		DeleteStudent deleteStudent = (DeleteStudent) context.getBean("deleteStudent");
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();*/

		try {
			deleteStudent.studentService.deleteStudent(id);
			//studentService.deleteStudent(id);
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
