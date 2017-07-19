package by.home.homeproject.command.subject.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.service.SubjectService;
import by.home.homeproject.service.exception.ServiceException;

public class DeleteSubject extends BaseCommand {

	private static final String ID = "id";
	
	private SubjectService subjectService;

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String sId = request.getParameter(ID);
		Integer id = Integer.valueOf(sId);

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		DeleteSubject deleteSubject = (DeleteSubject) context.getBean("deleteSubject");
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SubjectService subjectService = serviceFactory.getSubjectService();*/

		try {
			deleteSubject.subjectService.deleteSubject(id);
			//subjectService.deleteSubject(id);
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
