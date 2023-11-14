package quiz;

import java.util.Scanner;

public class B02_ConditionQuiz2 {
	public static void main(String[] args) {
	/*
		  1. char형 변수 a가 'q' 또는 'Q'일 때 true
		  2. char형 변수 b가 공백이나 탭이 아닐 때 true
		  3. char형 변수 c가 '0' ~ '9'일 때 true
		  4. char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
		  5. char형 변수 e가 한글일 때 true (한글의 범위는 유니코드 검색)
		  6. 사용자가 입력한 문자열이 quit일 때 true
		  		  	  		  	   
	 */
		
		char a = 'q';
		System.out.println(a == 'q' || a == 'Q');
		
		char b = 'a';
		System.out.println(b != ' ' && b != '\t');
		System.out.println(!(b==' '&&b=='\t'));
		
		char c = '각';
		System.out.println(c>='0' && c<='9'); //확인 ^^
				
		char d = 'z';
		System.out.println((d>=65 && d<=90) || (d>=97 && d<=122));
		
		char e = '각'; //한글: AC00-D7AF => 44032 - 55203
		System.out.println(e>=44032 && e<=55203);
		
		// Scanner sc = new Scanner(System.in);		
		//System.out.println("quit 정확하게 입력하시오!");
		//String userInput = sc.next();
		//System.out.println(userInput.equals("quit"));
		System.out.println("quit 정확하게 입력하시오!");
		System.out.print(new Scanner(System.in).next().equals("quit"));
		
	}
}
