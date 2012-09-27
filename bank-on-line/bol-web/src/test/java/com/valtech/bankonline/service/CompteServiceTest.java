package com.valtech.bankonline.service;

import com.valtech.testutils.CompteServiceFactory;

import junit.framework.TestCase;

public class CompteServiceTest extends TestCase {

	public CompteServiceTest(String name) {
		super(name);
	}

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		CompteServiceFactory.nouvelleBase();
	}


	public void testInterdictionTransfertSiSoldeCompteDebiteurInsufisant() throws Exception {
		CompteServiceFactory.service().creerCompte(new Compte("Client1", "1", "", 0));
		CompteServiceFactory.service().creerCompte(new Compte("Client1", "2", "", 0));
		
		try {
			CompteServiceFactory.service().transfert("1", "2", 1, "");
			fail("intediction transfert non détectée");
		} catch (Exception e) {
			assertEquals("Le solde du compte débiteur est insufisant.", e.getMessage());
		}
	}
}
