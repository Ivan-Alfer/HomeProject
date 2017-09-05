package by.home.command.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.home.command.subject.impl.AddNewSubject;
import by.home.command.subject.impl.AllStudentOnTheSubject;
import by.home.command.subject.impl.DeleteSubject;
import by.home.command.subject.impl.GoToUpdateSubject;
import by.home.command.subject.impl.ShowAllSubjects;
import by.home.command.subject.impl.UpdateSubject;

@Configuration
public class SubjectConfig {

	@Bean(name = "SHOW_ALL_SUBJECTS")
	public ShowAllSubjects getShowAllSubjects() {
		return new ShowAllSubjects();
	}
	
	@Bean(name = "ADD_NEW_SUBJECT")
	public AddNewSubject getAddNewSubject() {
		return new AddNewSubject();
	}
	
	@Bean(name = "GO_TO_UPDATE_SUBJECT")
	public GoToUpdateSubject getGoToUpdateSubject() {
		return new GoToUpdateSubject();
	}
	
	@Bean(name = "UPDATE_SUBJECT")
	public UpdateSubject getUpdateSubject() {
		return new UpdateSubject();
	}
	
	@Bean(name = "DELETE_SUBJECT")
	public DeleteSubject getDeleteSubject() {
		return new DeleteSubject();
	}
	
	@Bean(name = "ALL_STUDENT_ON_THE_SUBJECT")
	public AllStudentOnTheSubject getAllStudentOnTheSubject() {
		return new AllStudentOnTheSubject();
	}
}
