package by.home.homeproject.command.subject.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.entity.Subject;
import by.home.homeproject.service.ServiceFactory;
import by.home.homeproject.service.StudentService;
import by.home.homeproject.service.SubjectService;
import by.home.homeproject.service.exception.ServiceException;

public class AddNewSubject extends BaseCommand {

	private static final String SUBJECT_NAME = "subject";
	
	private SubjectService subjectService;

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String subjectName = request.getParameter(SUBJECT_NAME);
		Subject subject = new Subject(subjectName);

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		subjectService = (SubjectService) context.getBean("subjectService");
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SubjectService subjectService = serviceFactory.getSubjectService();*/

		try {
			subjectService.addSubject(subject);
		} catch (ServiceException e1) {
			throw new CommandException();
		}

		try {
			response.sendRedirect("/HomeProject/all_subjects");
		} catch (IOException e) {
			throw new CommandException();
		}
	}
}
