package by.home.homeproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.home.homeproject.dao.MarkDao;
import by.home.homeproject.dao.exception.DaoException;
import by.home.homeproject.entity.Mark;

public class MarkDaoImpl extends BaseDaoImpl<Mark> implements MarkDao {

	public MarkDaoImpl() {
		super();
	}

	@Override
	protected String getAllSelectQuery() {
		return "from Mark";
	}

	@Override
	protected Mark getEntity(int id) {
		return session.load(Mark.class, id);
	}

	@Override
	public List<Mark> getAllEntities() throws DaoException {
		List<Mark> marks = new ArrayList<Mark>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			marks = session.createQuery("from Mark", Mark.class).list();
		} catch (Exception e) {
			throw new DaoException();
		}finally{
			session.getTransaction().commit();
		}
		return marks;
	}

	@Override
	public List<Mark> getAllAboutStudent(Integer studentId) throws DaoException {
		List<Mark> marks = new ArrayList<Mark>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			marks = session.createQuery("from Mark where studentId = :id", Mark.class).setParameter("id", studentId)
					.list();
		} catch (Exception e) {
			throw new DaoException();
		}finally{
			session.getTransaction().commit();
		}
		return marks;
	}

	@Override
	public List<Mark> getAllStudentOnTheSubject(Integer subjectId) throws DaoException {
		List<Mark> marks = new ArrayList<Mark>();
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		marks = session.createQuery("from Mark where subjectId = :id", Mark.class).setParameter("id", subjectId).list();
		} catch (Exception e) {
			throw new DaoException();
		}finally{
			session.getTransaction().commit();
		}
		return marks;
	}
}
