package by.home.command.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.home.command.student.impl.AddNewStudent;
import by.home.command.student.impl.DeleteStudent;
import by.home.command.student.impl.GoToUpdateStudent;
import by.home.command.student.impl.ShowAllAboutStudent;
import by.home.command.student.impl.ShowAllStudents;
import by.home.command.student.impl.UpdateStudent;

@Configuration
public class StudentConfig {

	@Bean(name = "SHOW_ALL_STUDENTS")
	public ShowAllStudents getShowAllStudents() {
		return new ShowAllStudents();
	}
	
	@Bean(name = "ADD_NEW_STUDENT")
	public AddNewStudent getAddNewStudent() {
		return new AddNewStudent();
	}
	
	@Bean(name = "GO_TO_UPDATE_STUDENT")
	public GoToUpdateStudent getGoToUpdateStudent() {
		return new GoToUpdateStudent();
	}
	
	@Bean(name = "UPDATE_STUDENT")
	public UpdateStudent getUpdateStudent() {
		return new UpdateStudent();
	}
	
	@Bean(name = "DELETE_STUDENT")
	public DeleteStudent getDeleteStudent() {
		return new DeleteStudent();
	}
	
	@Bean(name = "SHOW_ALL_ABOUT_STUDENT")
	public ShowAllAboutStudent getShowAllAboutStudent() {
		return new ShowAllAboutStudent();
	}
}
