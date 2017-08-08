package by.home.command.subject.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.entity.Subject;
import by.home.service.SubjectService;
import by.home.service.exception.ServiceException;

@Component
@ComponentScan("by.home")
public class UpdateSubject extends BaseCommand {

	private static final String ID = "id";
	private static final String SUBJECT = "subject";

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private Subject subject;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		// Subject subject = new Subject();
		String sId = request.getParameter(ID);
		/*
		 * subject.setId(Integer.valueOf(sId));
		 * subject.setSubjectName(request.getParameter(SUBJECT));
		 */

		subject.setId(Integer.valueOf(sId));
		subject.setSubjectName(request.getParameter(SUBJECT));

		/*
		 * ServiceFactory serviceFactory = ServiceFactory.getInstance();
		 * SubjectService subjectService = serviceFactory.getSubjectService();
		 */

		try {
			subjectService.updateSubject(subject);
			// subjectService.updateSubject(subject);
		} catch (ServiceException e1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/HomeProject/error");
			throw new CommandException("Could not delete subject");
		}

		try {
			response.sendRedirect("/all_subjects");
		} catch (IOException e) {
			throw new CommandException(e);
		}
	}

}
