package by.home.command.subject.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.service.SubjectService;
import by.home.service.exception.ServiceException;

@Component
public class DeleteSubject extends BaseCommand {

	private static final String ID = "id";
	
	@Autowired
	private SubjectService subjectService;

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String sId = request.getParameter(ID);
		Integer id = Integer.valueOf(sId);
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SubjectService subjectService = serviceFactory.getSubjectService();*/

		try {
			subjectService.deleteSubject(id);
			//subjectService.deleteSubject(id);
		} catch (ServiceException e1) {
			throw new CommandException("Could not delete subject");
		}

		try {
			response.sendRedirect("/HomeProject/all_subjects");
		} catch (IOException e) {
			throw new CommandException();
		}
	}

}
