package by.home.command.student.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
import by.home.entity.Mark;
import by.home.service.MarkService;
import by.home.service.exception.ServiceException;
import by.home.service.impl.MarkServiceImpl;

@Component
@ComponentScan("by.home")
public class ShowAllAboutStudent extends BaseCommand {

	private static final String ID = "id";
	
	@Autowired
	private MarkService markService;

	public MarkService getMarkService() {
		return markService;
	}

	public void setMarkService(MarkService markService) {
		this.markService = markService;
	}

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String sId = request.getParameter(ID);
		Integer studentId = Integer.valueOf(sId);

		List<Mark> marks;

		ApplicationContext context =  new AnnotationConfigApplicationContext(ShowAllAboutStudent.class);
		ShowAllAboutStudent showAllAboutStudent = (ShowAllAboutStudent) context.getBean("showAllAboutStudent");
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markService = serviceFactory.getMarkService();*/

		try {
			marks = showAllAboutStudent.markService.getAllAboutStudent(studentId);
			//marks = markService.getAllAboutStudent(studentId);
		} catch (ServiceException e1) {
			throw new CommandException();
		}

		request.setAttribute("marks", marks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all_about_student.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}

	}

}
