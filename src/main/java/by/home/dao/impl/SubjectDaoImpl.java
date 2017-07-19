package by.home.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import by.home.entity.Subject;

@Component
public class SubjectDaoImpl extends BaseDaoImpl<Subject> {

	public SubjectDaoImpl() {
	}
	
	public SubjectDaoImpl(Session session) {
		super(session);
	}
	
	@Override
	protected String getAllSelectQuery() {
		return "from Subject";
	}

	@Override
	protected Subject getEntity(int id) {
		return session.load(Subject.class, id);
	}

}
