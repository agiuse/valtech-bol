package com.valtech.bankonline.web.pages.bank;

import java.util.List;

import org.apache.tapestry.annotations.Persist;
import org.apache.tapestry.annotations.Service;
import org.apache.tapestry.ioc.annotations.Inject;

import com.valtech.bankonline.service.CompteService;
import com.valtech.bankonline.service.Operation;

public class OperationList {

	@Persist
	private List<Operation> operations;

	private Operation operation;

	@Persist
	private DisplayInfo displayInfo;

	@Inject
	@Service("compteService")
	private CompteService compteService;

	public Object initialize(String numeroCompte, DisplayInfo displayInfo)
			throws Exception {
		System.out.println("initialize() : " + numeroCompte);
		this.displayInfo = displayInfo;

		displayInfo.setExternalAccountId(numeroCompte);

		operations = compteService.getCompte(numeroCompte).getDetail();

		return this;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public int getOperationsSize() {
		return operations.size();
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public DisplayInfo getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(DisplayInfo displayInfo) {
		this.displayInfo = displayInfo;
	}

}
