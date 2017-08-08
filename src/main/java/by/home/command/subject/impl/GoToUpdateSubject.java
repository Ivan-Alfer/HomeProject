package by.home.command.subject.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.entity.Subject;

@Component
@ComponentScan("by.home")
public class GoToUpdateSubject extends BaseCommand{

	private static final String ID = "id";
	private static final String SUBJECT = "subjectName";
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		Subject subject = new Subject();
		String sId = request.getParameter(ID);
		subject.setId(Integer.valueOf(sId));
		subject.setSubjectName(request.getParameter(SUBJECT));
		
		request.setAttribute("subject", subject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update_subject.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException("Could not go to the page");
		}
		
	}

}
