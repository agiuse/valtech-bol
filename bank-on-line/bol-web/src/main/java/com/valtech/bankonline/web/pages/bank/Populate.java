package com.valtech.bankonline.web.pages.bank;

import org.apache.tapestry.annotations.Service;
import org.apache.tapestry.ioc.annotations.Inject;

import com.valtech.bankonline.dao.DAO;
import com.valtech.bankonline.service.Compte;

public class Populate {
	private Compte Compte;

	@Inject
	@Service("compteDAO")
	private DAO<Compte> dao;

	public Compte getCompte() {
		return Compte;
	}

	public void onActivate(long id) {
		Compte = dao.getById(id);

		System.out
				.println("onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   onActivate   ");
	}

	public void setCompte(Compte Compte) {
		this.Compte = Compte;
	}

	public String onAction() {
		dao.save(Compte);

		System.out
				.println("onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction onAction ");

		return "Start";
	}

	private String compteDebiteur;
	private String compteCrediteur;
	private float montant;

	public String getCompteDebiteur() {
		return compteDebiteur;
	}

	public void setCompteDebiteur(String compteDebiteur) {
		this.compteDebiteur = compteDebiteur;
	}

	public String getCompteCrediteur() {
		return compteCrediteur;
	}

	public void setCompteCrediteur(String compteCrediteur) {
		this.compteCrediteur = compteCrediteur;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}
}
