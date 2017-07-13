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
import by.home.homeproject.entity.Subject;
import by.home.homeproject.service.ServiceFactory;
import by.home.homeproject.service.SubjectService;
import by.home.homeproject.service.exception.ServiceException;

public class ShowAllSubjects extends BaseCommand {

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

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		subjectService = (SubjectService) context.getBean("subjectService");
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SubjectService subjectService = serviceFactory.getSubjectService();*/

		try {
			subjects = subjectService.getSubjects();
		} catch (ServiceException e1) {
			throw new CommandException();
		}

		request.setAttribute("subjects", subjects);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all_subjects.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}

	}

}
