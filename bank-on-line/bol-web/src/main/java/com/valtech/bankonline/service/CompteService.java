package com.valtech.bankonline.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.valtech.bankonline.dao.DAO;

public class CompteService {

	private DAO<Compte> compteDao;

	private EntityManagerFactory entityManagerFactory;

	public void setCompteDao(DAO<Compte> compteDao) {
		this.compteDao = compteDao;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public List<Compte> getComptes(String referenceClient) {
		List<Compte> compteDuClient = new ArrayList<Compte>();
		for (Compte compte : compteDao.getAll()) {
			if (compte.referenceClient.equals(referenceClient)) {
				compteDuClient.add(compte);
			}
		}
		return compteDuClient;
	}

	public void creerCompte(Compte compte) {
		compteDao.save(compte);
	}

	public void transfert(String numeroCompteEmetteur, String numeroCompteDestinataire,
			float montant, String libelle) throws Exception {

		EntityManager em = entityManagerFactory.createEntityManager();

		Compte debitAccount = (Compte) em.createNamedQuery("Compte.findByNumeroCompte")
				.setParameter("numeroCompte", numeroCompteEmetteur).getSingleResult();
		
		if( ! debitAccount.estDebitAutorise(montant)) {
			throw new Exception("Le solde du compte débiteur est insufisant.");
		}

		Compte creditAccount = (Compte) em.createNamedQuery("Compte.findByNumeroCompte")
				.setParameter("numeroCompte", numeroCompteDestinataire).getSingleResult();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		debitAccount.solde -= montant;
		creditAccount.solde += montant;

		transaction.commit();
		
		
		String aujourdhui = BankTimeService.instance.aujourdhui();
		addOperation(numeroCompteEmetteur, aujourdhui, libelle, -1 * montant);
		addOperation(numeroCompteDestinataire, aujourdhui, libelle, montant);
	}

	public Compte getCompte(String numeroCompte) throws Exception {
		for (Compte compte : compteDao.getAll()) {
			if (compte.numeroCompte.equals(numeroCompte)) {
				return compte;
			}
		}
		throw new Exception("Compte non trouvé : " + numeroCompte);
	}

	public void addOperation(String numeroCompte, String dateOperation, String libelleOperation,
			float montant) throws Exception {

		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Compte compte = (Compte) em.createNamedQuery("Compte.findByNumeroCompte").setParameter(
				"numeroCompte", numeroCompte).getSingleResult();

		List<Operation> operations = em.createNamedQuery("Compte.findOperationsByAccountNumber")
				.setParameter("numeroCompte", numeroCompte).getResultList();

		Operation operation = new Operation(dateOperation, libelleOperation, montant);
		em.persist(operation);

		operations.add(operation);
		compte.setDetail(operations);

		transaction.commit();
	}
}
