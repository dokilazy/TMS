package com.tms.helper;

public class Constants {

	public final static String userNameTMS = "initUser";
	public final static String passwordTMS = "initUser";

	public final static long explicitWait = 100;
	public final static long impliciteWait = 100;

	public final static String base_URL = "https://tms.dallmeier.vn/";
	public final static String TMS_URL = "https://tms.dallmeier.vn/tms-dev/ui/";
	public final static String M2_URL = "https://magento-dev.dallmeier.vn/";
//	public final static String M2_URL = "https://m2-staging.dallmeier.vn/";
	
	public static String firstName = "null";
	public static String lastName = "null";
	public static String email = "null";
	public static String password = "dmvn@123";
	public static String organizationName = "null";
	public static String subdomain = "null";
	public static String mailinatorInboxURL = "https://www.mailinator.com/v4/public/inboxes.jsp";
	
	
	public static String getUsername() {
		return userNameTMS;
	}

	public static String getPassword() {
		return passwordTMS;
	}

	public static long getExplicitwait() {
		return explicitWait;
	}

	public static long getImplicitewait() {
		return impliciteWait;
	}

}
