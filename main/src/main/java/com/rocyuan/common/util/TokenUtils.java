package com.rocyuan.common.util;
/**
 * 
 */
import java.security.MessageDigest;

public class TokenUtils {
	
	public static String generateToken(String uid, String password) {

		String time = String.valueOf(System.currentTimeMillis() / 1000);
		String key = "rocyuan12wqqe";
		String token = "";
		if (uid == null || uid.trim().length() == 0) {
			uid = new String(new char[] { key.charAt(2), key.charAt(0), key.charAt(3), key.charAt(6) });
		}
		if (password == null || password.trim().length() == 0) {
			password = new String(new char[] { key.charAt(4), key.charAt(1), key.charAt(7), key.charAt(5) });
		}

		token = md5Encrypt(uid + time + password);
		String token1 = token.substring(0, 2);
		String token2 = token.substring(2, 10);
		String token3 = token.substring(10, 20);
		String token4 = token.substring(20);
		String time1 = time.substring(0, 4);
		String time2 = time.substring(4, 7);
		String time3 = time.substring(7);

		token = token1 + time1 + token2 + time2 + token3 + time3 + token4;
		return token; 
	}
    
	public static boolean validToken(String uid, String password, String token) {
		String key = "rocyuan12wqqe";
		String strTime1 = null, strTime2 = null, strTime3 = null, strTime = null;
		if (uid == null || uid.trim().length() == 0) {
			uid = new String(new char[] { key.charAt(2), key.charAt(0), key.charAt(3), key.charAt(6) });
		}
		if (password == null || password.trim().length() == 0) {
			password = "39";
		}

		try {
			strTime1 = token.substring(2, 6);
			strTime2 = token.substring(14, 17);
			strTime3 = token.substring(27, (token.length() - 12));
		} catch (Exception ignore) {
			ignore.printStackTrace();
			return false;
		}
		strTime = strTime1 + strTime2 + strTime3;

		String newToken = uid + strTime + password;
		newToken = md5Encrypt(newToken);
		StringBuffer sbToken = new StringBuffer(newToken);
		sbToken.insert(2, strTime1);
		sbToken.insert(14, strTime2);
		sbToken.insert(27, strTime3);
		return sbToken.toString().equalsIgnoreCase(token);
	}
	
	public static String md5Encrypt(String value) {
		byte[] obj = value.getBytes();
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(obj);
			return byteToHexString(md5.digest()).toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static String byteToHexString(byte[] b) {
		StringBuffer sb = new StringBuffer();
		String temp = "";
		for (int i = 0; i < b.length; i++) {
			temp = Integer.toHexString(b[i] & 0Xff);
			if (temp.length() == 1)
				temp = "0" + temp;
			sb.append(temp);
		}
		return sb.toString();
	}
	
}
