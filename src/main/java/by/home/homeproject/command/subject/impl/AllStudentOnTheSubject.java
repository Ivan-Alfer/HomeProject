package by.home.homeproject.command.subject.impl;

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
import by.home.homeproject.entity.Mark;
import by.home.homeproject.service.MarkService;
import by.home.homeproject.service.ServiceFactory;
import by.home.homeproject.service.exception.ServiceException;

public class AllStudentOnTheSubject extends BaseCommand {

	private static final String ID = "id";
	
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
		Integer subjectId = Integer.valueOf(sId);

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		markService = (MarkService) context.getBean("markService");
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markService = serviceFactory.getMarkService();*/

		List<Mark> marks;
		try {
			marks = markService.getAllStudentOnTheSubject(subjectId);
		} catch (ServiceException e1) {
			throw new CommandException();
		}

		request.setAttribute("marks", marks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/all_student_on_the_subject.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}

	}

}
