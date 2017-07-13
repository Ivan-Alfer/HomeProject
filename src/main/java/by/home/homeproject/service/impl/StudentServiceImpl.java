package by.home.homeproject.service.impl;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import by.home.homeproject.dao.BaseDao;
import by.home.homeproject.dao.exception.DaoException;
import by.home.homeproject.entity.Student;
import by.home.homeproject.service.StudentService;
import by.home.homeproject.service.exception.ServiceException;

public class StudentServiceImpl implements StudentService {
	
	private BaseDao<Student> studentDao;
	//private ApplicationContext context;
	//private BeanFactory factory;
	private ConfigurableApplicationContext context;
	
	public BaseDao<Student> getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(BaseDao<Student> studentDao) {
		this.studentDao = studentDao;
	}
	
	//StudentDao student = (StudentDao) factory.getBean("studentDao");
	
	//private DaoFactory daoFactory = DaoFactory.getInstance();
	// private BaseDao<Student> studentDao = daoFactory.getStudentDaoImpl();

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents() throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		StudentServiceImpl studentService = (StudentServiceImpl) context.getBean("studentService");

		List<Student> students;
		try {
			students = studentService.studentDao.getEntities();
			//students = studentDao.getEntities();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return students;
	}

	@Override
	public void addStudent(Student student) throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		StudentServiceImpl studentService = (StudentServiceImpl) context.getBean("studentService");		
		try {
			studentService.studentDao.addEntity(student);
			//studentDao.addEntity(student);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void deleteStudent(int id) throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		StudentServiceImpl studentService = (StudentServiceImpl) context.getBean("studentService");
		try {
			studentService.studentDao.deleteEntity(id);
			//studentDao.deleteEntity(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void updateStudent(Student student) throws ServiceException {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
		StudentServiceImpl studentService = (StudentServiceImpl) context.getBean("studentService");
		
		try {
			studentService.studentDao.updateEntity(student);
			//studentDao.updateEntity(student);
		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

}