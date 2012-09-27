package com.valtech.bankonline.dao;

import com.valtech.bankonline.service.Compte;

public class CompteDAOImpl extends DAOHibernateImpl<Compte> implements DAO<Compte> {

	@Override
	protected boolean exist(Object o) {
		return ((Compte) o).getId() == null;
	}

	@Override
	protected Class<Compte> getPersistentClass() {
		return Compte.class;
	}

}
