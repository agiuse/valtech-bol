package com.valtech.bankonline.service;


import com.valtech.bankonline.dao.DAO;

public class BankService {
	private DAO<Client> clientDao;
	public void setClientDao(DAO<Client> clientDao) {
		this.clientDao = clientDao;
	}

	public boolean connecter(String referenceClient, String motDePasse) {
		for (Client client : clientDao.getAll()) {
			if (client.referenceClient.equals(referenceClient)) {
				client.connecter(motDePasse);
				return client.estConnecte();
			}
		}
		return false;
	}

}
