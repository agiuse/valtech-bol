package com.valtech.bankonline.web.pages.bank;

import java.util.List;

import org.apache.tapestry.annotations.InjectPage;
import org.apache.tapestry.annotations.Persist;
import org.apache.tapestry.annotations.Service;
import org.apache.tapestry.ioc.annotations.Inject;

import com.valtech.bankonline.service.Compte;
import com.valtech.bankonline.service.CompteService;
import com.valtech.bankonline.service.Operation;

public class ListCompte {
	private List<Compte> compteList;
	private Compte compte;

	@Persist
	private String client;

	@Persist
	private DisplayInfo displayInfo;

	@Inject
	@Service("compteService")
	private CompteService compteService;

	public void beginRender() {
		compteList = compteService.getComptes(client);
	}

	public Object initialize(String client) {

		this.client = client;

		displayInfo = new DisplayInfo();

		displayInfo.setClientName(client);

		return this;
	}

	public List<Compte> getCompteList() {
		return compteList;
	}

	public void setCompteList(List<Compte> compteList) {
		this.compteList = compteList;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<Operation> getOperationList() {
		return compte.getDetail();
	}

	public void setOperationList(List<Operation> operations) {
		compte.setDetail(operations);
	}

	public void setOperation(List<Operation> operations) {
		compte.setDetail(operations);
	}

	public List<Operation> getOperation() {
		return compte.getDetail();
	}

	@InjectPage
	private OperationList operationList;

	Object onActionFromLink(String numeroCompte) throws Exception {
		System.out.println("onActionFromLink() : " + numeroCompte);

		return operationList.initialize(numeroCompte, displayInfo.clone());
	}

	@InjectPage
	private DoTransfert doTransfert;

	Object onActionFromTransfert(Integer clientId) {

		return doTransfert.initialize(displayInfo.clone());
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public DisplayInfo getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(DisplayInfo displayInfo) {
		this.displayInfo = displayInfo;
	}

}
