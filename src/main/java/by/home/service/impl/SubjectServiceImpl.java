package by.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import by.home.dao.BaseDao;
import by.home.dao.exception.DaoException;
import by.home.dao.impl.SubjectDaoImpl;
import by.home.entity.Subject;
import by.home.service.SubjectService;
import by.home.service.exception.ServiceException;

@Service
@ComponentScan("by.home")
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private BaseDao<Subject> subjectDao;
	
	/*private DaoFactory daoFactory = DaoFactory.getInstance();
	private BaseDao<Subject> subjectDao = daoFactory.getSubjectDaoImpl();*/

	public BaseDao<Subject> getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(BaseDao<Subject> subjectDao) {
		this.subjectDao = subjectDao;
	}

	@Override
	public List<Subject> getSubjects() throws ServiceException {
		List<Subject> subjects;
		try {
			subjects = subjectDao.getEntities();
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
		return subjects;
	}

	@Override
	public void addSubject(Subject subject) throws ServiceException {
		try {
			subjectDao.addEntity(subject);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}

	}

	@Override
	public void deleteSubject(int id) throws ServiceException {
		try {
			subjectDao.deleteEntity(id);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}

	}

	@Override
	public void updateSubject(Subject subject) throws ServiceException {
		try {
			subjectDao.updateEntity(subject);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}

	}

}
