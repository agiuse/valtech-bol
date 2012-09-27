package com.valtech.bankonline.web.pages;

import org.apache.tapestry.annotations.Component;
import org.apache.tapestry.annotations.InjectPage;
import org.apache.tapestry.annotations.Persist;
import org.apache.tapestry.annotations.Service;
import org.apache.tapestry.corelib.components.Form;
import org.apache.tapestry.corelib.components.PasswordField;
import org.apache.tapestry.ioc.annotations.Inject;

import com.valtech.bankonline.service.BankService;
import com.valtech.bankonline.web.pages.bank.ListCompte;

public class Start {

	@Persist
	private String referenceClient;

	private String motDePasse;

	@InjectPage
	private ListCompte listComtes;

	@Inject
	@Service("bankService")
	private BankService bank;

	@Component(id = "motDePasse")
	private PasswordField _passwordField;

	@Component
	private Form _form;

	Object onSuccess() {
		if (!bank.connecter(referenceClient, motDePasse)) {
			_form.recordError(_passwordField, "Mot de passe ou reference client invalide.");
			return null;
		}

		return listComtes.initialize(referenceClient);
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String password) {
		this.motDePasse = password;
	}

	public String getReferenceClient() {
		return referenceClient;
	}

	public void setReferenceClient(String userName) {
		this.referenceClient = userName;
	}

}
