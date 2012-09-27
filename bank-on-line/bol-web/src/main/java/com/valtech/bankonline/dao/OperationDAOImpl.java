package com.valtech.bankonline.dao;

import com.valtech.bankonline.service.Operation;

public class OperationDAOImpl extends DAOHibernateImpl<Operation> implements DAO<Operation>{

	@Override
	protected boolean exist(Object o) {
		return ((Operation)o).getId() == 0;
	}

	@Override
	protected Class<Operation> getPersistentClass() {
		return Operation.class;
	}

}
