package by.home.homeproject.command.subject.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.service.ServiceFactory;
import by.home.homeproject.service.SubjectService;

public class DeleteSubject extends BaseCommand {

	private static final String ID = "id";

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String sId = request.getParameter(ID);
		Integer id = Integer.valueOf(sId);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SubjectService subjectService = serviceFactory.getSubjectService();

		subjectService.deleteSubject(id);

		try {
			response.sendRedirect("/HomeProject/all_subjects");
		} catch (IOException e) {
			throw new CommandException();
		}
	}

}
