package by.home.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import by.home.dao.MarkDao;
import by.home.dao.exception.DaoException;
import by.home.entity.Mark;

@Component
public class MarkDaoImpl extends BaseDaoImpl<Mark> implements MarkDao {

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
			throw new DaoException("Database server not responding");
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
			throw new DaoException("Database server not responding");
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
			throw new DaoException("Database server not responding");
		}finally{
			session.getTransaction().commit();
		}
		return marks;
	}
}
