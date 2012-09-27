package com.valtech.bankonline.service;

import junit.framework.TestCase;

public class BankTimeServiceTest extends TestCase {

	public BankTimeServiceTest(String name) {
		super(name);
	}

	public void testFormatAujourdhui() throws Exception {
		assertTrue(BankTimeService.instance.aujourdhui().matches("\\d\\d/\\d\\d/\\d\\d\\d\\d"));
	}
}
