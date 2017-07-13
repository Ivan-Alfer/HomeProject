package by.home.homeproject.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.home.homeproject.command.exception.CommandException;
import by.home.homeproject.entity.Mark;
import by.home.homeproject.service.MarkService;
import by.home.homeproject.service.ServiceFactory;
import by.home.homeproject.service.exception.ServiceException;

public class ShowAll extends BaseCommand {

	private MarkService markService;
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

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		ShowAll showAll = (ShowAll) context.getBean("showAll");
		
		/*ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markDao = serviceFactory.getMarkService();*/

		try {
			marks = showAll.markService.getAllEntities();
			//marks = markDao.getAllEntities();
		} catch (ServiceException e1) {
			throw new CommandException();
		}

		request.setAttribute("marks", marks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}
	}
}
