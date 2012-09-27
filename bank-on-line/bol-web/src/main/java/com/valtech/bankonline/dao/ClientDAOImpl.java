package com.valtech.bankonline.dao;

import com.valtech.bankonline.service.Client;

public class ClientDAOImpl extends DAOHibernateImpl<Client> implements DAO<Client> {

	@Override
	protected boolean exist(Object o) {
		return ((Client) o).getId() == null;
	}

	@Override
	protected Class<Client> getPersistentClass() {
		return Client.class;
	}

}
