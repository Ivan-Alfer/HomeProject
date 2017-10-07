package by.home.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import by.home.command.exception.CommandException;
import by.home.entity.Mark;
import by.home.service.MarkService;
import by.home.service.exception.ServiceException;

@Component
public class ShowAll extends BaseCommand {

	@Autowired
	private MarkService markService;
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		List<Mark> marks;
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markDao = serviceFactory.getMarkService();*/

		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markDao = serviceFactory.getMarkService();*/

		try {
			marks = markService.getAllEntities();
			//marks = markDao.getAllEntities();
		} catch (ServiceException e1) {
			throw new CommandException("Could not show all notes");
		}

		
		String json;
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writer().writeValueAsString(marks);
			response.setContentType("all/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

		} catch (IOException e) {
			e.printStackTrace();
			throw new CommandException("Could not show all students" + e.getMessage());
		}


		
/*		request.setAttribute("marks", marks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}*/
	}
}
