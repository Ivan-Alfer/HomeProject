package by.home.command.subject.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.entity.Mark;
import by.home.service.MarkService;
import by.home.service.exception.ServiceException;

@Component
public class AllStudentOnTheSubject extends BaseCommand {

	private static final String ID = "id";
	
	@Autowired
	private MarkService markService;

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		String sId = request.getParameter(ID);
		Integer subjectId = Integer.valueOf(sId);
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markService = serviceFactory.getMarkService();*/

		List<Mark> marks;
		try {
			marks = markService.getAllStudentOnTheSubject(subjectId);
			//marks = markService.getAllStudentOnTheSubject(subjectId);
		} catch (ServiceException e1) {
			throw new CommandException("Could not show all student on the subject");
		}

		request.setAttribute("marks", marks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("all_student_on_the_subject.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}

	}

}
