package com.valtech.bankonline.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry.beaneditor.NonVisual;

@Entity
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public String dateOperation;
	public String libelleOperation;
	public float montant;

	public Operation() {
	}

	public Operation(String dateOperation, String libelleOperation,
			float montant) {
		super();
		this.dateOperation = dateOperation;
		this.libelleOperation = libelleOperation;
		this.montant = montant;
	}

	@NonVisual
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getLibelleOperation() {
		return libelleOperation;
	}

	public void setLibelleOperation(String libelleOperation) {
		this.libelleOperation = libelleOperation;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "opeId=" + id 
		+ " date=" + dateOperation 
		+ " libelle=" + libelleOperation 
		+ " montant=" + Float.toString(montant);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;

		Operation test = (Operation) obj;
		return (dateOperation == test.dateOperation || (dateOperation != null && dateOperation.equals(test.dateOperation)))
				&& (libelleOperation == test.libelleOperation || (libelleOperation != null && libelleOperation.equals(test.libelleOperation)))
				&& montant == test.montant;
	}
}
