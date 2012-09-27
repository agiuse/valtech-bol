package com.valtech.bankonline.dao;

import java.util.List;

public interface DAO<T> {
	public void save(T newObject);

	public void saveCollection(List<T> newCollection);

	public T getById(Long id);

	public List<T> getAll();
}
