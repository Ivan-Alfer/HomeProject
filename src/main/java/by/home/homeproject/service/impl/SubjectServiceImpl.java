package by.home.homeproject.service.impl;

import java.util.List;

import by.home.homeproject.dao.BaseDao;
import by.home.homeproject.dao.DaoFactory;
import by.home.homeproject.dao.exception.DaoException;
import by.home.homeproject.entity.Subject;
import by.home.homeproject.service.SubjectService;
import by.home.homeproject.service.exception.ServiceException;

public class SubjectServiceImpl implements SubjectService {

	private DaoFactory daoFactory = DaoFactory.getInstance();
	private BaseDao<Subject> subjectDao = daoFactory.getSubjectDaoImpl();

	@Override
	public List<Subject> getSubjects() throws ServiceException {
		List<Subject> subjects;
		try {
			subjects = subjectDao.getEntities();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return subjects;
	}

	@Override
	public void addSubject(Subject subject) throws ServiceException {
		try {
			subjectDao.addEntity(subject);
		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void deleteSubject(int id) throws ServiceException {
		try {
			subjectDao.deleteEntity(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void updateSubject(Subject subject) throws ServiceException {
		try {
			subjectDao.updateEntity(subject);
		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

}
