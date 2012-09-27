package com.valtech.testutils;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.valtech.bankonline.service.CompteService;


public class CompteServiceFactory {
	
	private static CompteService compteService;
	
	public static CompteService service() {
		if(compteService == null){
		
			ClassPathResource res = new ClassPathResource("hibernateDaoConfig.xml");
			XmlBeanFactory factory = new XmlBeanFactory(res);
			
			compteService = (CompteService) factory.getBean("compteService");
		}
		return compteService;
	}
	
	public static void nouvelleBase() {
		compteService = null;
	}
}

