package by.home.command.mark.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.entity.Mark;
import by.home.service.MarkService;
import by.home.service.exception.ServiceException;

@Component
public class AddMark extends BaseCommand {

	private static final String STUDENT_ID = "studentId";
	private static final String SUBJECT_ID = "subjectId";
	private static final String MARK = "mark";

	@Autowired
	private MarkService markService;
	
	@Autowired
	private Mark mark;

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
	
		//Mark mark = new Mark();
		String studId=request.getParameter(STUDENT_ID);
		String subId = request.getParameter(SUBJECT_ID);
		String sMark = request.getParameter(MARK);
		
		
		mark.setSubjectId(Integer.valueOf(subId));
		mark.setStudentId(Integer.valueOf(studId));
		mark.setMark(Integer.valueOf(sMark));

		/*mark.setSubjectId(Integer.valueOf(subId));
		mark.setStudentId(Integer.valueOf(studId));
		mark.setMark(Integer.valueOf(sMark));*/
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markService = serviceFactory.getMarkService();*/

			try {
				markService.addMark(mark);
				//markService.addMark(mark);
		} catch (ServiceException e1) {
			throw new CommandException("Could not add mark");
		}

		try {
			response.sendRedirect("/HomeProject/all_student_on_the_subject?id=" + subId);
		} catch (IOException e) {
			throw new CommandException(e);
		}
	}
}
