package com.valtech.bankonline.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry.beaneditor.NonVisual;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public String referenceClient;
	public String motDePasse;
	public boolean connection;

	
	public Client() {
	}

	public Client(String referenceClient, String motDePasse) {
		this.referenceClient = referenceClient;
		this.motDePasse = motDePasse;
		this.connection = false;
	}

	@NonVisual
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void connecter(String motDePasse) {
		connection = this.motDePasse.equals(motDePasse);
	}

	public void deconnecter() {
		connection = false;
	}

	public boolean estConnecte() {
		return connection;
	}

	public String getReference() {
		return referenceClient;
	}

}
