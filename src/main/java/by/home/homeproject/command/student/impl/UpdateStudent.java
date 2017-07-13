package by.home.homeproject.command.student.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.entity.Student;
import by.home.homeproject.service.ServiceFactory;
import by.home.homeproject.service.StudentService;
import by.home.homeproject.service.exception.ServiceException;

public class UpdateStudent extends BaseCommand {
	
	private static final String ID = "id";
	private static final String FIRST_NAME = "first name";
	private static final String LAST_NAME = "last name";
	
	private StudentService studentService;
	private Student student;

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public StudentService getStudentService() {
		return studentService;
	}


	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		
		

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		studentService = (StudentService) context.getBean("studentService");
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();*/

		String sId = request.getParameter(ID);
		student.setId(Integer.valueOf(sId));
		student.setFirstName(request.getParameter(FIRST_NAME));
		student.setLastName(request.getParameter(LAST_NAME));
		
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
