package by.home.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import by.home.command.Command;
import by.home.command.config.CommandsFactory;

public class Controller extends HttpServlet {

	@Autowired
	private CommandsFactory commandsFactory;
	
/*	@Autowired
	@Qualifier("GO_TO_MAIN_PAGE")
	private BaseCommand baseCommand;*/

	private static final long serialVersionUID = 1L;
	// private final CommandHelper commandHelper = new CommandHelper();
	private static final String COMMAND = "command";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		//ApplicationContextUtils.getWebApplicationContext( config.getServletContext())
		
	}

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
		
		Command command = commandsFactory.getCommand(nameCommand);
		command.execute(request, response);
		
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ConfigurationBean.class);
		baseCommand.execute(request, response);*/

		
		 /* AnnotationConfigApplicationContext context = null; try { context =
		  new AnnotationConfigApplicationContext(ConfigurationBean.class);
		  
		  BaseCommand command = (BaseCommand) context.getBean(nameCommand);
		  command.execute(request, response); } catch (Exception e) {
		  e.printStackTrace(); } finally { if (context != null) {
		  context.close(); } }*/
		 

		/*
		 * Command command = commandHelper.getCommand(nameCommand);
		 * command.execute(request, response);
		 */
	}

}