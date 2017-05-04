package by.home.homeproject.dao;

import java.util.List;

public interface BaseDao<T> {

	public List<T> getEntities();

	public void addEntity(T item);

	public void deleteEntity(int id);

	public void updateEntity(T item);

}
