package com.valtech.bankonline.web.pages.bank;

import org.apache.tapestry.annotations.Service;
import org.apache.tapestry.ioc.annotations.Inject;

import com.valtech.bankonline.dao.DAO;
import com.valtech.bankonline.service.Operation;

public class CreateOperation {
	private Operation Operation;

	@Inject
	@Service("operationDAO")
	private DAO<Operation> dao;

	public Operation getOperation() {
		return Operation;
	}

	public void onActivate(long id) {
		Operation = dao.getById(id);
	}

	public void setOperation(Operation Operation) {
		this.Operation = Operation;
	}

	public String onAction() {
		dao.save(Operation);
		return "Start";
	}
}
