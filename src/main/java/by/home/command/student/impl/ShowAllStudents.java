package by.home.command.student.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.command.impl.ConfigurationBean;
import by.home.entity.Student;
import by.home.service.StudentService;
import by.home.service.exception.ServiceException;

@Component
@ComponentScan("by.home")
public class ShowAllStudents extends BaseCommand {
	
	@Autowired
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		List<Student> students;
		
	
		ApplicationContext context =  new AnnotationConfigApplicationContext(ConfigurationBean.class);
		
		ShowAllStudents showAllStudents = (ShowAllStudents) context.getBean("showAllStudents");
		
		
		
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();*/

		try {
			students = showAllStudents.studentService.getStudents();
			//students = studentService.getStudents();
		} catch (ServiceException e1) {
			throw new CommandException("Could not show all students");
		}

		request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all_students.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}

	}

}
