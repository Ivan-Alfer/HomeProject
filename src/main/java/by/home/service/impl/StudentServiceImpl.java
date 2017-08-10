package by.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import by.home.dao.BaseDao;
import by.home.dao.exception.DaoException;
import by.home.entity.Student;
import by.home.service.StudentService;
import by.home.service.exception.ServiceException;

@Service
@ComponentScan("by.home")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private BaseDao<Student> studentDao;
	
	public BaseDao<Student> getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(BaseDao<Student> studentDao) {
		this.studentDao = studentDao;
	}
	
	//private DaoFactory daoFactory = DaoFactory.getInstance();
	// private BaseDao<Student> studentDao = daoFactory.getStudentDaoImpl();


	@Override
	public List<Student> getStudents() throws ServiceException {
		List<Student> students;
		try {
			students = studentDao.getEntities();
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
		return students;
	}

	@Override
	public void addStudent(Student student) throws ServiceException {
		try {
			studentDao.addEntity(student);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
	}

	@Override
	public void deleteStudent(int id) throws ServiceException {
		try {
			studentDao.deleteEntity(id);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}
	}

	@Override
	public void updateStudent(Student student) throws ServiceException {
		try {
			studentDao.updateEntity(student);
		} catch (DaoException e) {
			throw new ServiceException("Something happend in DAO");
		}

	}

}