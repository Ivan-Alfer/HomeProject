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
public class AddNewSubject extends BaseCommand {

	private static final String SUBJECT_NAME = "subject";
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private Subject subject;

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String subjectName = request.getParameter(SUBJECT_NAME);
		//Subject subject = new Subject(subjectName);

		subject.setSubjectName(subjectName);
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SubjectService subjectService = serviceFactory.getSubjectService();*/

		try {
			subjectService.addSubject(subject);
			//subjectService.addSubject(subject);
		} catch (ServiceException e1) {
			throw new CommandException("Could not add new subject");
		}

		try {
			response.sendRedirect("/HomeProject/all_subjects");
		} catch (IOException e) {
			throw new CommandException(e);
		}
	}
}
