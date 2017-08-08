package by.home.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import by.home.dao.exception.DaoException;
import by.home.entity.Mark;

@Component
public interface MarkDao extends BaseDao<Mark>{

	List<Mark> getAllEntities() throws DaoException;

	List<Mark> getAllAboutStudent(Integer studentId) throws DaoException;

	List<Mark> getAllStudentOnTheSubject(Integer subjectId) throws DaoException;
}
