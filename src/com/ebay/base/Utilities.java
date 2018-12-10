package com.ebay.base;

import java.util.Base64;

public class Utilities {

	//This will have all the Utilitie functions
	
	public static String Password() {
		String decryptedPassword, encryptedPassword;
		encryptedPassword= "S2hhc2ltMTIzJA==";
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(encryptedPassword);
		decryptedPassword = new String(decryptedPasswordBytes);
		return decryptedPassword;
		}
	
	
}
