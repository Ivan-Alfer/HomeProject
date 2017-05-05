package by.home.homeproject.service;

import java.util.List;

import by.home.homeproject.entity.Subject;
import by.home.homeproject.service.exception.ServiceException;

public interface SubjectService {

	List<Subject> getSubjects() throws ServiceException;

	void addSubject(Subject subject) throws ServiceException;
	
	void deleteSubject(int id) throws ServiceException;

	void updateSubject(Subject subject) throws ServiceException;

}
