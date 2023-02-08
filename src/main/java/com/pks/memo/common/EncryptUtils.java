package com.pks.memo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	
	// 암호화 기능
	public static String md5(String message) { // 멤버변수없고 사용하지도 않는것은 static 붙여서 사용 가능 하다 , 멤버변수사용하면 static 사용 불가
		String resultData = "";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			
			byte[] bytes =message.getBytes();
			md.update(bytes);
			
			byte[] digest = md.digest();
			
			// 16진수 형태의 문자열로 변환
			for(int i = 0; i < digest.length; i++) {
				resultData += Integer.toHexString(digest[i] & 0xff);
			}
			
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		
		return resultData;
		
	}
}
