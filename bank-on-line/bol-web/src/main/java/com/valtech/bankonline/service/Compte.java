package com.valtech.bankonline.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.apache.tapestry.beaneditor.NonVisual;

@NamedQueries({
		@NamedQuery(name = "Compte.findOperationsByAccountNumber", query = "select c.operations from Compte c where c.numeroCompte = :numeroCompte "),
		@NamedQuery(name = "Compte.findByNumeroCompte", query = "select c from Compte c where c.numeroCompte = :numeroCompte ") })
@Entity
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public String referenceClient;
	public String numeroCompte;
	public String type;
	public float solde;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Operation> operations = new ArrayList<Operation>();

	public Compte() {

	}

	public Compte(String referenceClient, String numeroCompte, String type,
			float solde) {
		this.referenceClient = referenceClient;
		this.numeroCompte = numeroCompte;
		this.type = type;
		this.solde = solde;
	}

	public List<Operation> getDetail() {
		return operations;
	}

	public void addOperation(Operation operation) {
		operations.add(operation);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDetail(List<Operation> operations) {
		this.operations = operations;
	}

	@NonVisual
	public String getReferenceClient() {
		return referenceClient;
	}

	public void setReferenceClient(String referenceClient) {
		this.referenceClient = referenceClient;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;

		Compte test = (Compte) obj;
		return (referenceClient == test.referenceClient || (referenceClient != null && referenceClient
				.equals(test.referenceClient)))
				&& (numeroCompte == test.numeroCompte || (numeroCompte != null && numeroCompte
						.equals(test.numeroCompte)))
				&& (type == test.type || (type != null && type
						.equals(test.type))) && solde == test.solde;
	}

	public boolean estDebitAutorise(float montantVirement) throws Exception {
		if (montantVirement == 0) {
			throw new Exception(
					"Le montant d'un virement ne peut pas etre nul.");
		}
		return solde >= montantVirement;
	}

}
