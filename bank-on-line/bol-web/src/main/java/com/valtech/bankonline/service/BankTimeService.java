package com.valtech.bankonline.service;

import java.util.Date;


public class BankTimeService implements TimeService {

	public static TimeService instance = new BankTimeService();

	public String aujourdhui(){
		return BANK_DATE_FORMAT.format(new Date());
	}
}
