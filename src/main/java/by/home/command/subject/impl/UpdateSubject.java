package by.home.command.subject.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.entity.Subject;
import by.home.service.SubjectService;
import by.home.service.exception.ServiceException;

@Component
public class UpdateSubject extends BaseCommand {

	private static final String ID = "id";
	private static final String SUBJECT = "subject";

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private Subject subject;

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
			throw new CommandException("Could not delete subject");
		}

		try {
			response.sendRedirect("/all_subjects");
		} catch (IOException e) {
			throw new CommandException(e);
		}
	}

}
