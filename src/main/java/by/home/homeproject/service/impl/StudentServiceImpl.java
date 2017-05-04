package by.home.homeproject.service.impl;

import java.util.List;

import by.home.homeproject.dao.BaseDao;
import by.home.homeproject.dao.DaoFactory;
import by.home.homeproject.entity.Student;
import by.home.homeproject.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private DaoFactory daoFactory = DaoFactory.getInstance();
	private BaseDao<Student> studentDao = daoFactory.getStudentDaoImpl();

	@Override
	public List<Student> getStudents() {
		List<Student> students = studentDao.getEntities();
		return students;
	}

	@Override
	public void addStudent(Student student) {
		studentDao.addEntity(student);
	}

	@Override
	public void deleteStudent(int id) {
		studentDao.deleteEntity(id);
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateEntity(student);

	}

}