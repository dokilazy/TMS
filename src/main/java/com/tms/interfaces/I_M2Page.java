package com.tms.interfaces;

public class I_M2Page {

	
	public static final String LOGIN_ERROR_MESSAGE = "//div[@class='message-error error message']/div[contains(text(), '%s')]";
	
	public static final String MAIL_SUBJECT  = "//td[contains(text(), '%s')]";
	
	public static final String WELCOME_TEXT  = "//div[@class='panel header']//li[@class='greet welcome']/span[contains(text(), '%s')]";
	
}
