package com.valtech.bankonline.web.forms;



public class TransfertForm {

	private String compteEmetteur;

	private String compteDestinataire;

	private Float montant;

	private String libelleOperation;
	
	public String getCompteEmetteur() {
		return compteEmetteur;
	}

	public void setCompteEmetteur(String compteEmetteur) {
		this.compteEmetteur = compteEmetteur;
	}

	public String getCompteDestinataire() {
		return compteDestinataire;
	}

	public void setCompteDestinataire(String compteDestinataire) {
		this.compteDestinataire = compteDestinataire;
	}

	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}

	public String getLibelleOperation() {
		return libelleOperation;
	}

	public void setLibelleOperation(String comment) {
		this.libelleOperation = comment;
	}

}
