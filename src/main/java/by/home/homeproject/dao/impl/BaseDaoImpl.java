package by.home.homeproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import by.home.homeproject.dao.BaseDao;
import by.home.homeproject.dao.exception.DaoException;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	protected Session session;

	protected abstract String getAllSelectQuery();

	protected abstract T getEntity(int id);

	public BaseDaoImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public BaseDaoImpl(Session ses) {
		session = ses;
	}

	public List<T> getEntities() throws DaoException {
		List<T> items = new ArrayList<T>();
		try {
			session.beginTransaction();
			items = session.createQuery(getAllSelectQuery()).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DaoException();
		}
		return items;
	}

	public void addEntity(T item) throws DaoException {
		try {
			session.beginTransaction();
			session.save(item);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DaoException();
		}
	}

	public void deleteEntity(int id) throws DaoException {
		try {
			session.beginTransaction();
			T item = getEntity(id);
			if (item != null) {
				session.delete(item);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DaoException();
		}
	}

	public void updateEntity(T item) throws DaoException {
		try {
			session.beginTransaction();
			session.saveOrUpdate(item);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DaoException();
		}
	}

}
