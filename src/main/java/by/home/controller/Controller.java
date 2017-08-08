package by.home.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import by.home.command.Command;
import by.home.command.impl.ConfigurationBean;
import by.home.command.impl.ShowAll;

@ComponentScan("by.home")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final CommandHelper commandHelper = new CommandHelper();
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

		CommandNames commandName = CommandNames.valueOf(nameCommand.toUpperCase());
		AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext();
		context.register(ConfigurationBean.class);
		context.refresh();
		context.getBean(nameCommand);
		
		/*Command command = commandHelper.getCommand(nameCommand);
		command.execute(request, response);*/
	}
}