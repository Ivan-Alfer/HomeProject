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
import by.home.entity.Student;
import by.home.service.StudentService;
import by.home.service.exception.ServiceException;
import by.home.service.impl.StudentServiceImpl;

@Component
@ComponentScan("by.home")
public class UpdateStudent extends BaseCommand {
	
	private static final String ID = "id";
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
		
		ApplicationContext context =  new AnnotationConfigApplicationContext(UpdateStudent.class);
		UpdateStudent upd = (UpdateStudent) context.getBean("updateStudent");
		
		String sId = request.getParameter(ID);
		upd.student.setFirstName(request.getParameter(FIRST_NAME));
		upd.student.setId(Integer.valueOf(sId));
		upd.student.setLastName(request.getParameter(LAST_NAME));
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		StudentService studentService = serviceFactory.getStudentService();*/

		
		/*student.setId(Integer.valueOf(sId));
		student.setFirstName(request.getParameter(FIRST_NAME));
		student.setLastName(request.getParameter(LAST_NAME));*/
		
		try {
			upd.studentService.updateStudent(upd.student);
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
