package by.home.homeproject.dbdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import by.home.homeproject.dao.BaseDao;
import by.home.homeproject.entity.HibernateUtil;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	protected Session session;

	protected abstract String getAllSelectQuery();

	protected abstract T getEntity(int id);


	public BaseDaoImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public BaseDaoImpl(Session ses){
		session = ses;
	}

	public List<T> getEntities() {
		List<T> items = new ArrayList<T>();
		// session
		session.beginTransaction();
		items = session.createQuery(getAllSelectQuery()).list();
		session.getTransaction().commit();
		return items;
	}

	public void addEntity(T item) {
		// session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
	}

	public void deleteEntity(int id) {
		// session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		T item = getEntity(id);
		if (item != null) {
			session.delete(item);
		}
		session.getTransaction().commit();
	}

	public void updateEntity(T item) {
		// session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(item);
		session.getTransaction().commit();
	}

}
