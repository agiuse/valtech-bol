package com.valtech.bankonline.service;

import junit.framework.TestCase;

public class ClientTest extends TestCase {

	public ClientTest(String name) {
		super(name);
	}
	
	public void testConnectionDeconnection() throws Exception {
		Client client = new Client("any", "motSecret");

		assertFalse(client.estConnecte());

		client.connecter("motSecret");
		
		assertTrue(client.estConnecte());
		
		client.deconnecter();
		
		assertFalse(client.estConnecte());
	}

	public void testMauvaisMotDePasse() throws Exception {
		Client client = new Client("any", "motSecret");
		client.connecter("motSecretFaux");
		
		assertFalse(client.estConnecte());
		
	}
}
