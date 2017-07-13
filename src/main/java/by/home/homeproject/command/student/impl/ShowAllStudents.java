package by.home.homeproject.command.student.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.entity.Student;
import by.home.homeproject.service.StudentService;
import by.home.homeproject.service.exception.ServiceException;

public class ShowAllStudents extends BaseCommand {

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
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		studentService = (StudentService) context.getBean("studentService");
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();*/

		try {
			students = studentService.getStudents();
		} catch (ServiceException e1) {
			throw new CommandException();
		}

		request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all_students.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}

	}

}
