package by.home.homeproject.service.impl;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.home.homeproject.dao.BaseDao;
import by.home.homeproject.dao.exception.DaoException;
import by.home.homeproject.entity.Subject;
import by.home.homeproject.service.SubjectService;
import by.home.homeproject.service.exception.ServiceException;

public class SubjectServiceImpl implements SubjectService {
	
	private BaseDao<Subject> subjectDao;
	private ConfigurableApplicationContext context;

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
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		subjectDao = (BaseDao<Subject>) context.getBean("subjectDao");
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
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		subjectDao = (BaseDao<Subject>) context.getBean("subjectDao");
		try {
			subjectDao.addEntity(subject);
		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void deleteSubject(int id) throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		subjectDao = (BaseDao<Subject>) context.getBean("subjectDao");
		try {
			subjectDao.deleteEntity(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void updateSubject(Subject subject) throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		subjectDao = (BaseDao<Subject>) context.getBean("studentDao");
		try {
			subjectDao.updateEntity(subject);
		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

}
