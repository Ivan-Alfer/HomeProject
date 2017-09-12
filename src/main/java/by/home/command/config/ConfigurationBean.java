package by.home.command.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import by.home.command.Command;
import by.home.command.impl.GoToMainPage;
import by.home.command.impl.ShowAll;
import by.home.command.mark.impl.AddMark;
import by.home.command.mark.impl.GoToAddMark;
import by.home.command.student.impl.AddNewStudent;
import by.home.command.student.impl.DeleteStudent;
import by.home.command.student.impl.GoToUpdateStudent;
import by.home.command.student.impl.ShowAllAboutStudent;
import by.home.command.student.impl.ShowAllStudents;
import by.home.command.student.impl.UpdateStudent;
import by.home.command.subject.impl.AddNewSubject;
import by.home.command.subject.impl.AllStudentOnTheSubject;
import by.home.command.subject.impl.DeleteSubject;
import by.home.command.subject.impl.GoToUpdateSubject;
import by.home.command.subject.impl.ShowAllSubjects;
import by.home.command.subject.impl.UpdateSubject;
import by.home.controller.CommandNames;

//@Configuration
@ComponentScan("by.home")
public class ConfigurationBean {

	
/*	@Autowired
	private GoToMainPage goToMainPage;
	
	@Autowired
	private ShowAll showAll;
	
	@Autowired
	private GoToAddMark goToAddMark;
	
	@Autowired
	private AddMark addMark;
	
	@Autowired
	private ShowAllStudents showAllStudents;
	
	@Autowired
	private ShowAllAboutStudent showAllAboutStudent;
	
	@Autowired
	private AddNewStudent addNewStudent;
	
	@Autowired
	private GoToUpdateStudent goToUpdateStudent;
	
	@Autowired
	private UpdateStudent updateStudent;
	
	@Autowired 
	private DeleteStudent deleteStudent;
	
	@Autowired
	private ShowAllSubjects showAllSubjects;
	
	@Autowired
	private AddNewSubject addNewSubject;
	
	@Autowired
	private GoToUpdateSubject goToUpdateSubject;
	
	@Autowired
	private UpdateSubject updateSubject;
	
	@Autowired
	private DeleteSubject deleteSubject;
	
	@Autowired
	private AllStudentOnTheSubject allStudentOnTheSubject;
	
	@Bean
	public Map<CommandNames, Command> commands(){
		Map<CommandNames, Command> commands = new HashMap<CommandNames, Command>();
		commands.put(CommandNames.GO_TO_MAIN_PAGE, goToMainPage);
		commands.put(CommandNames.SHOW_ALL, showAll);
		commands.put(CommandNames.GO_TO_ADD_MARK, goToAddMark);
		commands.put(CommandNames.ADD_MARK, addMark);
		commands.put(CommandNames.SHOW_ALL_STUDENTS, showAllStudents);
		commands.put(CommandNames.SHOW_ALL_ABOUT_STUDENT, showAllAboutStudent);
		commands.put(CommandNames.ADD_NEW_STUDENT, addNewStudent);
		commands.put(CommandNames.GO_TO_UPDATE_STUDENT, goToUpdateStudent);
		commands.put(CommandNames.UPDATE_STUDENT, updateStudent);
		commands.put(CommandNames.DELETE_STUDENT, deleteStudent);
		commands.put(CommandNames.SHOW_ALL_SUBJECTS, showAllSubjects);
		commands.put(CommandNames.ADD_NEW_SUBJECT, addNewSubject);
		commands.put(CommandNames.GO_TO_UPDATE_SUBJECT, goToUpdateSubject);
		commands.put(CommandNames.UPDATE_SUBJECT, updateSubject);
		commands.put(CommandNames.DELETE_SUBJECT, deleteSubject);
		commands.put(CommandNames.ALL_STUDENT_ON_THE_SUBJECT, allStudentOnTheSubject);
		return commands;
	}*/
	
}
