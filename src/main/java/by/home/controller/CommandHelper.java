package by.home.controller;

import java.util.HashMap;
import java.util.Map;

import by.home.command.Command;
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



public class CommandHelper {

	private Map<CommandNames, Command> commands = new HashMap<>();

	public CommandHelper() {
		//commands.put(CommandNames.GO_TO_MAIN_PAGE, new GoToMainPage());
		commands.put(CommandNames.SHOW_ALL_STUDENTS, new ShowAllStudents());
		commands.put(CommandNames.SHOW_ALL_SUBJECTS, new ShowAllSubjects());
		commands.put(CommandNames.SHOW_ALL, new ShowAll());
		commands.put(CommandNames.SHOW_ALL_ABOUT_STUDENT, new ShowAllAboutStudent());
		commands.put(CommandNames.ADD_NEW_STUDENT, new AddNewStudent());
		commands.put(CommandNames.ADD_NEW_SUBJECT, new AddNewSubject());
		commands.put(CommandNames.GO_TO_UPDATE_STUDENT, new GoToUpdateStudent());
		commands.put(CommandNames.UPDATE_STUDENT, new UpdateStudent());
		commands.put(CommandNames.DELETE_STUDENT, new DeleteStudent());
		commands.put(CommandNames.GO_TO_UPDATE_SUBJECT, new GoToUpdateSubject());
		commands.put(CommandNames.UPDATE_SUBJECT, new UpdateSubject());
		commands.put(CommandNames.DELETE_SUBJECT, new DeleteSubject());
		commands.put(CommandNames.ALL_STUDENT_ON_THE_SUBJECT, new AllStudentOnTheSubject());
		commands.put(CommandNames.GO_TO_ADD_MARK, new GoToAddMark());
		commands.put(CommandNames.ADD_MARK, new AddMark());
	}

	protected Command getCommand(String name) {
		CommandNames commandName = CommandNames.valueOf(name.toUpperCase());
		Command command = commands.get(commandName);
		return command;
	}
}
