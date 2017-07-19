package by.home.service;

import java.util.List;

import by.home.entity.Mark;
import by.home.service.exception.ServiceException;

public interface MarkService {
	
	List<Mark> getMarks() throws ServiceException;

	void addMark(Mark mark) throws ServiceException;

	void deleteMark(int id) throws ServiceException;

	void updateMark(Mark mark) throws ServiceException;
	
	List<Mark> getAllEntities() throws ServiceException;

	List<Mark> getAllAboutStudent(Integer studentId) throws ServiceException;

	List<Mark> getAllStudentOnTheSubject(Integer subjectId) throws ServiceException;
}
