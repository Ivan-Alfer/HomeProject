package by.home.dao;

import java.util.List;

import by.home.dao.exception.DaoException;

public interface BaseDao<T> {

	List<T> getEntities() throws DaoException;

	void addEntity(T item) throws DaoException;

	void deleteEntity(int id) throws DaoException;

	void updateEntity(T item) throws DaoException;

}
