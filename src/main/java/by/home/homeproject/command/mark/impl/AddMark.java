package by.home.homeproject.command.mark.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.command.impl.BaseCommand;
import by.home.homeproject.entity.Mark;
import by.home.homeproject.service.MarkService;
import by.home.homeproject.service.exception.ServiceException;

public class AddMark extends BaseCommand{

	private static final String STUDENT_ID = "studentId";
	private static final String SUBJECT_ID = "subjectId";
	private static final String MARK = "mark";
	
	private MarkService markService;

	public MarkService getMarkService() {
		return markService;
	}

	public void setMarkService(MarkService markService) {
		this.markService = markService;
	}
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		Mark mark = new Mark();
		String studId=request.getParameter(STUDENT_ID);
		String subId = request.getParameter(SUBJECT_ID);
		String sMark = request.getParameter(MARK);
		
		mark.setSubjectId(Integer.valueOf(subId));
		mark.setStudentId(Integer.valueOf(studId));
		mark.setMark(Integer.valueOf(sMark));
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		markService = (MarkService) context.getBean("markService");
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markService = serviceFactory.getMarkService();*/

			try {
				markService.addMark(mark);
			} catch (ServiceException e1) {
				throw new CommandException();
			}

		try {
			response.sendRedirect("/HomeProject/all_student_on_the_subject?id="+subId);
		} catch (IOException e) {
			throw new CommandException();
		}
	}
}
