package by.home.command.subject.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.command.mark.impl.AddMark;
import by.home.entity.Subject;
import by.home.service.SubjectService;
import by.home.service.exception.ServiceException;
import by.home.service.impl.SubjectServiceImpl;

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

		ApplicationContext context =  new AnnotationConfigApplicationContext(UpdateSubject.class);
		UpdateSubject updateSubject = (UpdateSubject) context.getBean("updateSubject");

		updateSubject.subject.setId(Integer.valueOf(sId));
		updateSubject.subject.setSubjectName(request.getParameter(SUBJECT));

		/*
		 * ServiceFactory serviceFactory = ServiceFactory.getInstance();
		 * SubjectService subjectService = serviceFactory.getSubjectService();
		 */

		try {
			updateSubject.subjectService.updateSubject(updateSubject.subject);
			// subjectService.updateSubject(subject);
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
