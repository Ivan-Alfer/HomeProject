package by.home.homeproject.service;

import java.util.List;

import by.home.homeproject.entity.Subject;

public interface SubjectService {

	List<Subject> getSubjects();

	void addSubject(Subject subject);
	
	void deleteSubject(int id);

	void updateSubject(Subject subject);

}
