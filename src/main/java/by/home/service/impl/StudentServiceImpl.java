package by.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import by.home.dao.BaseDao;
import by.home.dao.exception.DaoException;
import by.home.dao.impl.StudentDaoImpl;
import by.home.entity.Student;
import by.home.service.StudentService;
import by.home.service.exception.ServiceException;

@Service
@ComponentScan("by.home")
public class StudentServiceImpl implements StudentService {
	
	public StudentServiceImpl() {
	}
	
	
	private BaseDao<Student> studentDao;
	
	private ApplicationContext context;
	
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
		context =  new AnnotationConfigApplicationContext(StudentServiceImpl.class);
		studentDao = context.getBean(StudentDaoImpl.class);
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
		context =  new AnnotationConfigApplicationContext(StudentServiceImpl.class);
		studentDao = context.getBean(StudentDaoImpl.class);
		try {
			studentDao.addEntity(student);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void deleteStudent(int id) throws ServiceException {
		context =  new AnnotationConfigApplicationContext(StudentServiceImpl.class);
		studentDao = context.getBean(StudentDaoImpl.class);
		try {
			studentDao.deleteEntity(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void updateStudent(Student student) throws ServiceException {
		context =  new AnnotationConfigApplicationContext(StudentServiceImpl.class);
		studentDao = context.getBean(StudentDaoImpl.class);
		try {
			studentDao.updateEntity(student);
		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

}