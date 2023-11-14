package quiz;

public class D09_CaesarCipher {
	final public static String CAESAR_CHARSET = 
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*0123456789abcdefghijklmnopqrstuvwxyz[]/?;'\"";

	public static boolean ENCRYPT_MODE = false;
	public static boolean DECRYPT_MODE = true;
	
	/*
	 
	 	# 시저 암호
	 	
	 	- 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 암호화하는 암호 알고리즘
	 	- 키 값만큼 평문의 모든 알파벳을 오른쪽으로 밀어주면 암호화가 되고
	 	  암호문을 다시 정해진 키 값만큼 왼쪽으로 밀어주면 복호화가 된다
	 	  
	 	  ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*0123456789abcdefghijklmnopqrstuvwxyz[]/?;'"
	 	  
	 	  [평문]			key : 10		[암호문]
	 	  Hello!! 	--------------> 	RovvyCC
	 	  				  암호화
	 				<--------------
	 					  복호화
	 */
	
	// 1. 평문과 키값이 전달되면 해당 평문을 암호화하여 리턴해주는 메서드
	// 2. 암호문과 키값이 전달되면 해당 암호문을 복호화하여 리턴해주는 메서드
	
	public static String encrypt(String text, int key) {
		StringBuilder sb = new StringBuilder();
		int lenOfCharset = CAESAR_CHARSET.length();
		int len = text.length();
		for(int i = 0 ; i < len; ++i) {
			char ch = text.charAt(i);
			int index = CAESAR_CHARSET.indexOf(ch);
			if(index != -1) {
				int cipherIndex = (index+key) % lenOfCharset;
				sb.append(CAESAR_CHARSET.charAt(cipherIndex));				
			} else {
				// 암호 CHARSET에 없는 문자인 경우 그대로 더해줘야 한다
				sb.append(ch);
			} 
		}
		return sb.toString();
	}
	
	public static String decrypt(String text, int key) {
		StringBuilder sb = new StringBuilder();
		int lenOfCharset = CAESAR_CHARSET.length();
		int len = text.length();
		for(int i = 0 ; i < len; ++i) {
			char ch = text.charAt(i);
			int index = CAESAR_CHARSET.indexOf(ch);
			if(index != -1) {
				int plainIndex = (index-key) % lenOfCharset;
				
				if(plainIndex < 0) {
					// key값을 뺀 결과가 0보다 작으면
					sb.append(CAESAR_CHARSET.charAt(lenOfCharset+plainIndex));
				} else {	
					//key값을 뺀 결과가 0보다 크면 그대로 사용
					sb.append(CAESAR_CHARSET.charAt(plainIndex));				
				}
			} else {
				// 암호 CHARSET에 없는 문자인 경우 그대로 더해줘야 한다
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	
	
	
	public static String encrypt(String str, int key , boolean getDecrypt) {
		StringBuilder reBuildtext = new StringBuilder();
		
		for(int i = 0 ; i < str.length() ; i++) {
			int originNum = CAESAR_CHARSET.indexOf(Character.toString(str.charAt(i)));
			if(originNum != -1) {
				int len = CAESAR_CHARSET.length();
				if(key>= len) {
					key = key%len; 
				}
				int reBuildNum = getDecrypt ? originNum - key : originNum + key;
				if(reBuildNum >= len) {
					reBuildNum = reBuildNum%len;
				} 
				if(reBuildNum < 0) {
					reBuildNum = len - Math.abs(reBuildNum)%len;
				}
				reBuildtext.append(Character.toString(CAESAR_CHARSET.charAt(reBuildNum)));		
			} else {
				reBuildtext.append(str.charAt(i));
			}
		}
		return reBuildtext.toString();
	}
	
	public static void encryption_debuge(String debugeString , int KeyNum) {
		String str = encrypt(debugeString, KeyNum, ENCRYPT_MODE);
		System.out.println(str);
		System.out.println(encrypt(str, KeyNum , DECRYPT_MODE));
	}
	
	public static void main(String[] args) {
		System.out.println(encrypt("Hello!!한국",3555));
		String encryptedText = encrypt("Hello!!한국",3555);
		System.out.println(decrypt(encryptedText,3555));
		System.out.println(encrypt("Hello!!한국",3555,ENCRYPT_MODE));
		System.out.println(encrypt("Uryy]55한국",3555,DECRYPT_MODE));
		
	}
}
