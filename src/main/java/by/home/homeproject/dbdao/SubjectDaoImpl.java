package by.home.homeproject.dbdao;

import org.hibernate.Session;

import by.home.homeproject.entity.Subject;

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
