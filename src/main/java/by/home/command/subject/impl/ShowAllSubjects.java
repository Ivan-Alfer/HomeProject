package by.home.command.subject.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.entity.Subject;
import by.home.service.SubjectService;
import by.home.service.exception.ServiceException;

@Component
public class ShowAllSubjects extends BaseCommand {

	@Autowired
	private SubjectService subjectService;

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		List<Subject> subjects;

		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		SubjectService subjectService = serviceFactory.getSubjectService();*/

		try {
			subjects = subjectService.getSubjects();
			//subjects = subjectService.getSubjects();
		} catch (ServiceException e1) {
			throw new CommandException("Could not show all subjects");
		}

		String json;
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writer().writeValueAsString(subjects);
			response.setContentType("subjects/json");
		} catch (JsonProcessingException e) {
			throw new CommandException("Could not show all subjects");
		}
	

		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e1) {
			throw new CommandException("Could not show all subjects");
		}
		
		/*request.setAttribute("subjects", subjects);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all_subjects.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}*/

	}

}
