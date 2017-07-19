package by.home.command.student.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.command.mark.impl.AddMark;
import by.home.service.StudentService;
import by.home.service.exception.ServiceException;
import by.home.service.impl.StudentServiceImpl;

@Component
@ComponentScan("by.home")
public class DeleteStudent extends BaseCommand {

	private static final String ID = "id";

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
		String sId = request.getParameter(ID);
		Integer id = Integer.valueOf(sId);

		ApplicationContext context =  new AnnotationConfigApplicationContext(DeleteStudent.class);
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
