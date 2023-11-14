package quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class E09_EncryptFile {
	final public static String CAESAR_CHARSET = 
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*0123456789abcdefghijklmnopqrstuvwxyz[]/?;'\"";
	final static int KEY = 1000 ;

	/*
	  	frankenstein.txt를 시저 암호방식으로 암호화 한 파일
	  	frankenstein_encrypted.enc를 생성해보세요
	  	
	  	(1) char 방식으로 한 글자씩 암호화하는 속도 측정해보기 
	  	
	  	(2) char[] 방식으로 암호화하는 속도 측정해보기
	  	
	  	(3) 버퍼를 추가하여 암호화하는 속도 측정해보기
	  	
	  	(4) 암호화 했던 파일의 복호화 파일 생성 해보기
	*/

	public static char encrypt(char ch, int key) {
		char sb;
		int lenOfCharset = CAESAR_CHARSET.length();
		int index = CAESAR_CHARSET.indexOf(ch);
		if(index != -1) {
			int cipherIndex = (index+key) % lenOfCharset;
			sb = CAESAR_CHARSET.charAt(cipherIndex);				
		} else {
			sb = ch ;
		} 
		return sb;
	}
	
	public static char decrypt(char ch, int key) {
		char sb;
		int lenOfCharset = CAESAR_CHARSET.length();
		int index = CAESAR_CHARSET.indexOf(ch);
		if(index != -1) {
			int plainIndex = (index-key) % lenOfCharset;
				
			if(plainIndex < 0) {
				// key값을 뺀 결과가 0보다 작으면
				sb = CAESAR_CHARSET.charAt(lenOfCharset+plainIndex);
			} else {	
				sb = CAESAR_CHARSET.charAt(plainIndex);				
			}
		} else {
			sb = ch;
		}
		return sb;
	}
	
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
	
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		// 암호화
		try (
				FileReader in = new FileReader(new File("myfiles/frankenstein.txt"));
				FileWriter fout = new FileWriter(new File("myfiles/frankenstein_encrypted.enc"));
				
				//버퍼 있이
				BufferedWriter bout = new BufferedWriter(fout);
				PrintWriter out = new PrintWriter(bout);
				
				//버퍼 없이
//				PrintWriter out = new PrintWriter(fout);
				
		){
			// char 방식
//			int ch;
//			while ((ch = in.read()) != -1 ) {
//				char sb = encrypt((char)ch,KEY);
//				out.append(sb);
//			}
			
			// char[] 방식
			char[] buff = new char[1024];
			
			int len = in.read(buff);
			out.append(encrypt(new String(buff, 0, len),KEY));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		System.out.println("수행시간: " + (end - start) + " ms");
		
		// 복호화
		
		try (
				FileReader in = new FileReader(new File("myfiles/frankenstein_encrypted.enc"));
				FileWriter fout = new FileWriter(new File("myfiles/frankenstein_decrypt.txt"));
				BufferedWriter bout = new BufferedWriter(fout);
				PrintWriter out = new PrintWriter(bout);
		){
			int ch;
			while ((ch = in.read()) != -1 ) {
				char sb = decrypt((char)ch,KEY);
				out.append(sb);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
}
