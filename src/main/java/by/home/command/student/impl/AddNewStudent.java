package by.home.command.student.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.entity.Student;
import by.home.service.StudentService;
import by.home.service.exception.ServiceException;

@Component
@ComponentScan("by.home")
public class AddNewStudent extends BaseCommand{

	private static final String FIRST_NAME = "first name";
	private static final String LAST_NAME = "last name";
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
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
		
		ApplicationContext context =  new AnnotationConfigApplicationContext(AddNewStudent.class);
		AddNewStudent addNewStudent = (AddNewStudent) context.getBean("addNewStudent");
		
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		
		addNewStudent.student.setFirstName(firstName);
		addNewStudent.student.setLastName(lastName);
		
		/*Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);*/
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();*/
		
		try {
			addNewStudent.studentService.addStudent(addNewStudent.student);
			//studentService.addStudent(student);
		} catch (ServiceException e) {
			throw new CommandException("Could not add student");
		}
		
		try {
			response.sendRedirect("/HomeProject/all_students");
		} catch (IOException e) {
			throw new CommandException(e);
		}
	}
}
