package by.home.dao;

import by.home.dao.impl.MarkDaoImpl;
import by.home.dao.impl.StudentDaoImpl;
import by.home.dao.impl.SubjectDaoImpl;
import by.home.entity.Student;
import by.home.entity.Subject;

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
