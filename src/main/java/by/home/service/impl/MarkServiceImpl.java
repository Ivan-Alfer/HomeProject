package by.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.home.dao.MarkDao;
import by.home.dao.exception.DaoException;
import by.home.entity.Mark;
import by.home.service.MarkService;
import by.home.service.exception.ServiceException;

@Service
public class MarkServiceImpl implements MarkService {
	
	@Autowired
	private MarkDao markDao;

	public MarkDao getMarkDao() {
		return markDao;
	}

	public void setMarkDao(MarkDao markDao) {
		this.markDao = markDao;
	}

	/*
	 * private DaoFactory daoFactory = DaoFactory.getInstance(); private MarkDao
	 * markDao = daoFactory.getMarkDaoImpl();
	 */

	@Override
	public List<Mark> getMarks() throws ServiceException {
		List<Mark> marks;
		try {
			marks = markDao.getEntities();
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
		return marks;
	}

	@Override
	public void addMark(Mark mark) throws ServiceException {
		try {
			markDao.addEntity(mark);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
	}

	@Override
	public void deleteMark(int id) throws ServiceException {
		try {
			markDao.deleteEntity(id);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}

	}

	@Override
	public void updateMark(Mark mark) throws ServiceException {
		try {
			markDao.updateEntity(mark);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}

	}

	@Override
	public List<Mark> getAllEntities() throws ServiceException {
		List<Mark> marks;
		try {
			marks = markDao.getAllEntities();
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
		return marks;
	}

	@Override
	public List<Mark> getAllAboutStudent(Integer studentId) throws ServiceException {
		List<Mark> marks;
		try {
			marks = markDao.getAllAboutStudent(studentId);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
		return marks;
	}

	@Override
	public List<Mark> getAllStudentOnTheSubject(Integer subjectId) throws ServiceException {
		List<Mark> marks;
		try {
			marks = markDao.getAllStudentOnTheSubject(subjectId);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
		return marks;
	}

}
