package by.home.command.student.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import by.home.command.exception.CommandException;
import by.home.command.impl.BaseCommand;
import by.home.entity.Student;
import by.home.service.StudentService;
import by.home.service.exception.ServiceException;

@Component
public class ShowAllStudents extends BaseCommand {

	@Autowired
	private StudentService studentService;

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		List<Student> students;

		/*
		 * ServiceFactory serviceFactory = ServiceFactory.getInstance();
		 * StudentService studentService = serviceFactory.getStudentService();
		 */

		try {
			students = studentService.getStudents();
			// students = studentService.getStudents();
		} catch (ServiceException e1) {
			throw new CommandException("Could not show all students");
		}
		
		/*Gson gs = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String sgs = gs.toJson(students);*/
		
		String json;
		ObjectMapper mapper = new ObjectMapper();
		try {
			response.setContentType("students/json");
			json = mapper.writer().writeValueAsString(students);

		} catch (JsonProcessingException e) {
			throw new CommandException("Could not show all students");
		}
	

		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e1) {
			throw new CommandException("Could not show all students");
		}

		
		/*request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all_students.jsp");

		try {
			dispatcher.forward(request, response);S
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}
*/
	}

}
