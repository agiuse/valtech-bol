package com.valtech.bankonline.dao;

import java.util.List;

import org.springframework.orm.jpa.JpaTemplate;

public abstract class DAOHibernateImpl<T> extends JpaTemplate {

	public final void save(T newObject) {
		if (exist(newObject)) {
			merge(newObject);
		} else {
			persist(newObject);
		}
	}

	public final void saveCollection(List<T> newCollection) {
		for (T newObject : newCollection) {
			save(newObject);
		}
	}

	public final T getById(Long id) {
		return (T) find(getPersistentClass(), id);
	}

	public final List<T> getAll() {
		return find("from " + getPersistentClass().getName() + " p ORDER BY id");
	}

	/**
	 * Returns true if the object already exists in the persistent storage,
	 * false if this is a new object only existing in memory.
	 */
	protected abstract boolean exist(Object o);

	/**
	 * Returns the Class object corresponding to the concrete persistent object
	 * for this DAO
	 * 
	 * @return
	 */
	protected abstract Class<?> getPersistentClass();
}
