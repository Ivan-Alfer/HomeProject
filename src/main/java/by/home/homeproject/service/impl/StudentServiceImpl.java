package by.home.homeproject.service.impl;

import java.util.List;

import by.home.homeproject.dao.BaseDao;
import by.home.homeproject.dao.DaoFactory;
import by.home.homeproject.dao.exception.DaoException;
import by.home.homeproject.entity.Student;
import by.home.homeproject.service.StudentService;
import by.home.homeproject.service.exception.ServiceException;

public class StudentServiceImpl implements StudentService {

	private DaoFactory daoFactory = DaoFactory.getInstance();
	private BaseDao<Student> studentDao = daoFactory.getStudentDaoImpl();

	@Override
	public List<Student> getStudents() throws ServiceException {
		List<Student> students;
		try {
			students = studentDao.getEntities();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return students;
	}

	@Override
	public void addStudent(Student student) throws ServiceException {
		try {
			studentDao.addEntity(student);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void deleteStudent(int id) throws ServiceException {
		try {
			studentDao.deleteEntity(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void updateStudent(Student student) throws ServiceException {
		try {
			studentDao.updateEntity(student);
		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

}