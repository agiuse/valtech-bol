package com.valtech.bankonline.web.pages.bank;

import org.apache.tapestry.annotations.Service;
import org.apache.tapestry.ioc.annotations.Inject;

import com.valtech.bankonline.dao.DAO;
import com.valtech.bankonline.service.Compte;

public class CreateCompte {
	private Compte Compte;

	@Inject
	@Service("compteDAO")
	private DAO<Compte> dao;

	public Compte getCompte() {
		return Compte;
	}

	public void onActivate(long id) {
		Compte = dao.getById(id);
	}

	public void setCompte(Compte Compte) {
		this.Compte = Compte;
	}

	public String onAction() {
		dao.save(Compte);
		return "Start";
	}
}
