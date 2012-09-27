package com.valtech.bankonline;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.valtech.bankonline.service.Client;
import com.valtech.bankonline.service.Compte;
import com.valtech.bankonline.service.Operation;


public class PopulateListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {

		ServletContext servletContext = arg0.getServletContext();

		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);

		EntityManager em = ((EntityManagerFactory) wac
				.getBean("entityManagerFactory")).createEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		em.persist(new Client("0001", "motsecret"));
		em.persist(new Client("0002", "motsecretClient2"));
		
		Compte compte1 = new Compte("0001", "100-123-456", "compte courant", 1000);
		Compte compte2 = new Compte( "0001", "200-123-456", "epargne", 800);
		Compte compte3 = new Compte( "0001", "300-123-456", "carte credit", -345);
		Compte compte4 = new Compte( "0002", "400-123-456", "compte courant", 100);

		Operation operation1 = new Operation("04/02/2008", "retrait", -20);
		Operation operation2 = new Operation("06/02/2008", "Virement dest CPTE COMMUN", -500);
		Operation operation3 = new Operation("08/02/2008", "RBT assurance maladie", 34);
		Operation operation4 = new Operation("28/02/2008", "Paye", 2349);
		
		List<Operation> operations = new ArrayList<Operation>();
		operations.add(operation1);
		operations.add(operation2);
		operations.add(operation3);
		operations.add(operation4);
		compte1.setDetail(operations);

		em.persist(compte1);
		em.persist(compte2);
		em.persist(compte3);
		em.persist(compte4);

		transaction.commit();

	}

}
