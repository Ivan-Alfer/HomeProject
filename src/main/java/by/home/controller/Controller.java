package by.home.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.home.command.impl.BaseCommand;
import by.home.command.impl.ConfigurationBean;

public class Controller extends HttpServlet {

	@Autowired
	private BaseCommand baseCommand;
	
	public BaseCommand getBaseCommand() {
		return baseCommand;
	}

	public void setBaseCommand(BaseCommand baseCommand) {
		this.baseCommand = baseCommand;
	}

	private static final long serialVersionUID = 1L;
	//private final CommandHelper commandHelper = new CommandHelper();
	private static final String COMMAND = "command";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String nameCommand = request.getParameter(COMMAND);
		if (nameCommand == null || nameCommand.length() == 0) {
			nameCommand = getInitParameter(COMMAND);
		}
		
		baseCommand.execute(request, response);
		
		AnnotationConfigApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(ConfigurationBean.class);

			BaseCommand command = (BaseCommand) context.getBean(nameCommand);
			command.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				context.close();
			}
		}
		
		
		/*
		 * Command command = commandHelper.getCommand(nameCommand);
		 * command.execute(request, response);
		 */
	}
}