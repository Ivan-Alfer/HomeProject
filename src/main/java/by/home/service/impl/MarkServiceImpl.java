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

import by.home.command.mark.impl.AddMark;
import by.home.dao.MarkDao;
import by.home.dao.exception.DaoException;
import by.home.dao.impl.MarkDaoImpl;
import by.home.entity.Mark;
import by.home.service.MarkService;
import by.home.service.exception.ServiceException;

@Service
@ComponentScan("by.home")
public class MarkServiceImpl implements MarkService {
	
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
		ApplicationContext context =  new AnnotationConfigApplicationContext(MarkServiceImpl.class);
		markDao = context.getBean(MarkDaoImpl.class);
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
		ApplicationContext context =  new AnnotationConfigApplicationContext(MarkServiceImpl.class);
		markDao = context.getBean(MarkDaoImpl.class);
		try {
			markDao.addEntity(mark);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
	}

	@Override
	public void deleteMark(int id) throws ServiceException {
		ApplicationContext context =  new AnnotationConfigApplicationContext(MarkServiceImpl.class);
		markDao = context.getBean(MarkDaoImpl.class);
		try {
			markDao.deleteEntity(id);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}

	}

	@Override
	public void updateMark(Mark mark) throws ServiceException {
		ApplicationContext context =  new AnnotationConfigApplicationContext(MarkServiceImpl.class);
		markDao = context.getBean(MarkDaoImpl.class);
		try {
			markDao.updateEntity(mark);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}

	}

	@Override
	public List<Mark> getAllEntities() throws ServiceException {
		ApplicationContext context =  new AnnotationConfigApplicationContext(MarkServiceImpl.class);
		markDao = context.getBean(MarkDaoImpl.class);
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
		ApplicationContext context =  new AnnotationConfigApplicationContext(MarkServiceImpl.class);
		markDao = context.getBean(MarkDaoImpl.class);
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
		ApplicationContext context =  new AnnotationConfigApplicationContext(MarkServiceImpl.class);
		markDao = context.getBean(MarkDaoImpl.class);
		List<Mark> marks;
		try {
			marks = markDao.getAllStudentOnTheSubject(subjectId);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
		return marks;
	}

}
