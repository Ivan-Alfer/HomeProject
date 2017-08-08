package by.home.command.subject.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
public class ShowAllSubjects extends BaseCommand {

	@Autowired
	private SubjectService subjectService;

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		List<Subject> subjects;

		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SubjectService subjectService = serviceFactory.getSubjectService();*/

		try {
			subjects = subjectService.getSubjects();
			//subjects = subjectService.getSubjects();
		} catch (ServiceException e1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/HomeProject/error");
			throw new CommandException("Could not show all subjects");
		}

		request.setAttribute("subjects", subjects);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all_subjects.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}

	}

}
