package com.valtech.bankonline.service;

import java.text.SimpleDateFormat;

public interface TimeService {
	public static final SimpleDateFormat BANK_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public abstract String aujourdhui();

}