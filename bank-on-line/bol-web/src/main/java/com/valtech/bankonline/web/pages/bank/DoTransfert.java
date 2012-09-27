package com.valtech.bankonline.web.pages.bank;

import org.apache.tapestry.annotations.Component;
import org.apache.tapestry.annotations.InjectPage;
import org.apache.tapestry.annotations.Persist;
import org.apache.tapestry.annotations.Service;
import org.apache.tapestry.corelib.components.BeanEditForm;
import org.apache.tapestry.ioc.annotations.Inject;

import com.valtech.bankonline.service.CompteService;
import com.valtech.bankonline.web.forms.TransfertForm;

public class DoTransfert {
	@Persist
	private TransfertForm transfertForm;

	@Persist
	private DisplayInfo displayInfo;

	@Inject
	@Service("compteService")
	private CompteService compteService;

	@InjectPage
	private ListCompte listCompte;
	
	@Component(id="transfertForm") 
	private BeanEditForm transfertFormBean;

	public Object onAction() throws Exception {

		try {
			compteService.transfert(transfertForm.getCompteEmetteur(), transfertForm
					.getCompteDestinataire(), transfertForm.getMontant(), transfertForm
					.getLibelleOperation());
		} catch (Exception e) {
			transfertFormBean.recordError(e.getMessage());
			return null;
		}

		return listCompte;
	}

	public TransfertForm getTransfertForm() {
		return transfertForm;
	}

	public void setTransfertForm(TransfertForm transfertForm) {

		this.transfertForm = transfertForm;
	}

	public ListCompte getListCompte() {
		return listCompte;
	}

	public void setListCompte(ListCompte listCompte) {
		this.listCompte = listCompte;
	}

	DoTransfert initialize(DisplayInfo displayInfo) {
		this.displayInfo = displayInfo;
		return this;
	}

	public DisplayInfo getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(DisplayInfo displayInfo) {
		this.displayInfo = displayInfo;
	}

}
