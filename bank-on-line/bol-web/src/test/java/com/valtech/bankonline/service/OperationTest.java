package com.valtech.bankonline.service;

import junit.framework.TestCase;

public class OperationTest extends TestCase {

	public OperationTest(String name) {
		super(name);
	}

	public void testEqual() throws Exception {
		Operation operation = new Operation("01/01/2000", "libelle", 1);
		Operation operationEgale = new Operation("01/01/2000", "libelle", 1);
		assertFalse(operation.equals(null));
		assertFalse(operation.equals("any other object"));
		assertEquals(operation, operation);		
		assertEquals(operation, operationEgale);
		
		assertFalse(operation.equals(new Operation("01/01/2000", "libelle", 2)));
		assertFalse(operation.equals(new Operation("01/01/2000", "autre libelle", 1)));
		assertFalse(operation.equals(new Operation("01/01/2001", "libelle", 1)));
		
		Operation operationLibelleNull = new Operation("01/01/2000", null, 1);
		Operation operationDateNull = new Operation(null, "libelle", 1);
		
		assertFalse(operation.equals(operationLibelleNull));
		assertFalse(operationLibelleNull.equals(operation));
		
		assertFalse(operation.equals(operationDateNull));
		assertFalse(operationDateNull.equals(operation));
	}
}
