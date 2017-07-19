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
import by.home.homeproject.service.SubjectService;
import by.home.homeproject.service.exception.ServiceException;

public class UpdateSubject extends BaseCommand {

	private static final String ID = "id";
	private static final String SUBJECT = "subject";
	
	private SubjectService subjectService;
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
		//Subject subject = new Subject();
		String sId = request.getParameter(ID);
		/*subject.setId(Integer.valueOf(sId));
		subject.setSubjectName(request.getParameter(SUBJECT));*/
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		UpdateSubject updateSubject = (UpdateSubject) context.getBean("updateSubject");
		
		updateSubject.subject.setId(Integer.valueOf(sId));
		updateSubject.subject.setSubjectName(request.getParameter(SUBJECT));
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SubjectService subjectService = serviceFactory.getSubjectService();*/

		try {
			updateSubject.subjectService.updateSubject(updateSubject.subject);
			//subjectService.updateSubject(subject);
		} catch (ServiceException e1) {
			throw new CommandException();
		}

		try {
			response.sendRedirect("/all_subjects");
		} catch (IOException e) {
			throw new CommandException();
		}
	}

}
