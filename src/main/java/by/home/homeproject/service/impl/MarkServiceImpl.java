package by.home.homeproject.service.impl;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.home.homeproject.dao.MarkDao;
import by.home.homeproject.dao.exception.DaoException;
import by.home.homeproject.entity.Mark;
import by.home.homeproject.service.MarkService;
import by.home.homeproject.service.exception.ServiceException;

public class MarkServiceImpl implements MarkService {

	private MarkDao markDao;
	public MarkDao getMarkDao() {
		return markDao;
	}

	public void setMarkDao(MarkDao markDao) {
		this.markDao = markDao;
	}

	private ConfigurableApplicationContext context;
	
	/*private DaoFactory daoFactory = DaoFactory.getInstance();
	private MarkDao markDao = daoFactory.getMarkDaoImpl();*/

	@Override
	public List<Mark> getMarks() throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		markDao = (MarkDao) context.getBean("markDao");
		List<Mark> marks;
		try {
			marks = markDao.getEntities();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return marks;
	}

	@Override
	public void addMark(Mark mark) throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		markDao = (MarkDao) context.getBean("markDao");
		try {
			markDao.addEntity(mark);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void deleteMark(int id) throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		markDao = (MarkDao) context.getBean("markDao");
		try {
			markDao.deleteEntity(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void updateMark(Mark mark) throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		markDao = (MarkDao) context.getBean("markDao");
		try {
			markDao.updateEntity(mark);
		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

	@Override
	public List<Mark> getAllEntities() throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		markDao = (MarkDao) context.getBean("markDao");
		List<Mark> marks;
		try {
			marks = markDao.getAllEntities();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return marks;
	}

	@Override
	public List<Mark> getAllAboutStudent(Integer studentId) throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		markDao = (MarkDao) context.getBean("markDao");
		List<Mark> marks;
		try {
			marks = markDao.getAllAboutStudent(studentId);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return marks;
	}

	@Override
	public List<Mark> getAllStudentOnTheSubject(Integer subjectId) throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		markDao = (MarkDao) context.getBean("markDao");
		List<Mark> marks;
		try {
			marks = markDao.getAllStudentOnTheSubject(subjectId);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return marks;
	}

}
