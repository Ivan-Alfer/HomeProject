package by.home.homeproject.dao;

import java.util.List;

import by.home.homeproject.dao.exception.DaoException;
import by.home.homeproject.entity.Mark;

public interface MarkDao extends BaseDao<Mark>{

	public List<Mark> getAllEntities() throws DaoException;

	public List<Mark> getAllAboutStudent(Integer studentId) throws DaoException;

	public List<Mark> getAllStudentOnTheSubject(Integer subjectId) throws DaoException;
}
