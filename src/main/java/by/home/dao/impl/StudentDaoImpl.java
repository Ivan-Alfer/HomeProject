package by.home.homeproject.dao.impl;

import org.hibernate.Session;

import by.home.homeproject.entity.Student;

public class StudentDaoImpl extends BaseDaoImpl<Student> {

	public StudentDaoImpl() {
	}
	
	public StudentDaoImpl(Session session) {
		super(session);
	}
	
	@Override
	protected String getAllSelectQuery() {
		return "from Student";
	}

	@Override
	protected Student getEntity(int id) {
		return session.load(Student.class, id);
	}
}
