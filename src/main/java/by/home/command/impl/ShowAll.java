package by.home.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import by.home.command.exception.CommandException;
import by.home.entity.Mark;
import by.home.service.MarkService;
import by.home.service.exception.ServiceException;

@Component
@ComponentScan("by.home")
public class ShowAll extends BaseCommand {

	@Autowired
	private MarkService markService;
	
	@Autowired
	private Mark mark;

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	public MarkService getMarkService() {
		return markService;
	}

	public void setMarkService(MarkService markService) {
		this.markService = markService;
	}
	
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

		request.setAttribute("marks", marks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}
	}
}
