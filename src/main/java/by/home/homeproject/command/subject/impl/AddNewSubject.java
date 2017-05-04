package by.home.homeproject.command.subject.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.entity.Subject;
import by.home.homeproject.service.ServiceFactory;
import by.home.homeproject.service.SubjectService;

public class AddNewSubject extends BaseCommand {

	private static final String SUBJECT_NAME = "subject";

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String subjectName = request.getParameter(SUBJECT_NAME);
		Subject subject = new Subject(subjectName);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SubjectService subjectService = serviceFactory.getSubjectService();

		subjectService.addSubject(subject);

		try {
			response.sendRedirect("/HomeProject/all_subjects");
		} catch (IOException e) {
			throw new CommandException();
		}
	}
}
