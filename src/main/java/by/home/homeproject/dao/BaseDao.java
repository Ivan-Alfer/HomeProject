package by.home.homeproject.dao;

import java.util.List;

import by.home.homeproject.dao.exception.DaoException;

public interface BaseDao<T> {

	public List<T> getEntities() throws DaoException;

	public void addEntity(T item) throws DaoException;

	public void deleteEntity(int id) throws DaoException;

	public void updateEntity(T item) throws DaoException;

}
