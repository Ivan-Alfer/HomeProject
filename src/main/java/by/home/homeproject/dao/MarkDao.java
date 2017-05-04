package by.home.homeproject.dao;

import java.util.List;

import by.home.homeproject.entity.Mark;

public interface MarkDao extends BaseDao<Mark>{

	public List<Mark> getAllEntities();

	public List<Mark> getAllAboutStudent(Integer studentId);

	public List<Mark> getAllStudentOnTheSubject(Integer subjectId);
}
