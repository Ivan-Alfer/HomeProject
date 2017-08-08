package by.home.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import by.home.entity.Student;

@Component
public class StudentDaoImpl extends BaseDaoImpl<Student> {
	
	public StudentDaoImpl(Session session) {
		super(session);
	}
	
	public StudentDaoImpl() {
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
