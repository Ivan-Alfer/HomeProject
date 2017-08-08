package by.home.command.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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

@Configuration
@ComponentScan("by.home")
public class ConfigurationBean {
	
	private String nameBean;
	
	public ConfigurationBean(String nameBean) {
		this.nameBean = nameBean;
	}

	@Bean(name = "SHOW_ALL_STUDENTS")
	  public ShowAllStudents getShowAllStudents() {
	    return new ShowAllStudents();
	  }
	
	@Bean(name = "GO_TO_MAIN_PAGE")
	  public GoToMainPage getGoToMainPage() {
	    return new GoToMainPage();
	  }
	
	@Bean(name = "SHOW_ALL")
	  public ShowAll getShowAll() {
	    return new ShowAll();
	  }
	
	@Bean(name = "SHOW_ALL_SUBJECTS")
	  public ShowAllSubjects getShowAllSubjects() {
	    return new ShowAllSubjects();
	  }
	
	@Bean(name = "SHOW_ALL_ABOUT_STUDENT")
	  public ShowAllAboutStudent getShowAllAboutStudent() {
	    return new ShowAllAboutStudent();
	  }
	
	@Bean(name = "ADD_NEW_STUDENT")
	  public AddNewStudent getAddNewStudent() {
	    return new AddNewStudent();
	  }
	
	@Bean(name = "ADD_NEW_SUBJECT")
	  public AddNewSubject getAddNewSubject() {
	    return new AddNewSubject();
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
	
	@Bean(name = "GO_TO_ADD_MARK")
	  public GoToAddMark getGoToAddMark() {
	    return new GoToAddMark();
	  }
	
	@Bean(name = "ADD_MARK")
	  public AddMark getAddMark() {
	    return new AddMark();
	  }
}
