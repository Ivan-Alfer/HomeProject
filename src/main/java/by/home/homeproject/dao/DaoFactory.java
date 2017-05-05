package by.home.homeproject.dao;

import by.home.homeproject.dao.impl.MarkDaoImpl;
import by.home.homeproject.dao.impl.StudentDaoImpl;
import by.home.homeproject.dao.impl.SubjectDaoImpl;
import by.home.homeproject.entity.Student;
import by.home.homeproject.entity.Subject;

public class DaoFactory {
	private static final DaoFactory INSTANSE = new DaoFactory();

	private DaoFactory() {

	}

	public static DaoFactory getInstance() {
		return INSTANSE;
	}

	public BaseDao<Student> getStudentDaoImpl() {
		return new StudentDaoImpl();
	}
	
	public BaseDao<Subject> getSubjectDaoImpl(){
		return new SubjectDaoImpl();
	}

	public MarkDao getMarkDaoImpl(){
		return new MarkDaoImpl();
	}
}
