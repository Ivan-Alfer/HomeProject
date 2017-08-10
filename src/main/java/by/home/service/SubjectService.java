package by.home.service;

import java.util.List;

import by.home.entity.Subject;
import by.home.service.exception.ServiceException;


public interface SubjectService {

	List<Subject> getSubjects() throws ServiceException;

	void addSubject(Subject subject) throws ServiceException;
	
	void deleteSubject(int id) throws ServiceException;

	void updateSubject(Subject subject) throws ServiceException;

}
