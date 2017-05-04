package by.home.homeproject.service;

import java.util.List;

import by.home.homeproject.entity.Mark;

public interface MarkService {
	
	List<Mark> getMarks();

	void addMark(Mark mark);

	void deleteMark(int id);

	void updateMark(Mark mark);
	
	List<Mark> getAllEntities();

	List<Mark> getAllAboutStudent(Integer studentId);

	List<Mark> getAllStudentOnTheSubject(Integer subjectId);
}
