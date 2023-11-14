package quiz;

import java.util.Scanner;

public class B07_Palindrome {
	/*
	 * 사용자가 단어를 입력하면 해당 단어가 좌우대칭인지 판별해주는 프로그램을 만들어보세요.
	 * 
	 * >> LEVEL -> 좌우대칭입니다.
	 * 
	 * >> FATHER -> 좌우대칭이 아닙니다.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("좌우 대칭인지 확인 하실 단어를 입력하세요 : ");
		String word = sc.nextLine();

		
		// 1. 맨 앞부터 글자를 하나씩 비교해나간다(절반까지만)
		// 항상 동일할 예정인 계산은 조건쪽에서 하면 낭비가 될 수 있다.
		int len = word.length();
		int incorrectCount = 0;
		boolean palindrome = true;
		
		int lowerCount = 0;
		int upperCount = 0;
		boolean hasDiffCass = upperCount > 0 && lowerCount >0;
		
		//대소문자가 다르면 카운트 
		for(int i = 0 ; i < word.length(); ++i) {
			char ch =word.charAt(i);
			if(ch>='A' && ch <='Z') {
				++upperCount;
			} else if (ch>='a' && ch<='z') {
				++lowerCount;
			}
		}
		
		
		// 단어의 맨 앞 인덱스부터 절반 인덱스까지 검사를 진행한다.
		for(int i=0, half = len /2 ; incorrectCount == 0 && i< half; ++i) {
			char frontCh = word.charAt(i);
			char behindCh = word.charAt(len-1-i);
			
			// &= 을 이용해 false가 한번만 발생해도 false가 되도록 만들 수 있다.
			// for(int i=0, half = len /2 ; palindrome && i< half; ++i) {
			// palindrome &= frontCh != behindCh;
			
			
			// 앞쪽 문자와 뒤쪽 문자가 일치하지 않을때마다 불일치 카운트를 1증가 
			if(frontCh!=behindCh) {
				++incorrectCount;
			}
		}
		if(incorrectCount > 0) {
			System.out.println("(1) 좌우대칭이 아닙니다.");
		} else if (hasDiffCass){
			System.out.println("(1) 대/소문자가 다르지만 좌우대칭입니다.");
		} else {
			System.out.println("(1) 좌우대칭입니다.");
		}
		
		// 2. 단어를 뒤집고 비교해서 똑같으면 좌우대칭이다.
		

//		String reversed = "";
//		// 비어있는 문자열을 하나 만들고 문자를 하나씩 누적 연산하면
//		// 새로운 문자열을 만들 수 있다.
//		
//		for (int i = 0 ; i < word.length(); ++i) {
//			reversed += word.charAt(word.length()-1-i);
//		}
//		System.out.printf("원본 : %s, 뒤집: %s\n",word,reversed);
//		
//		if(!word.equals(reversed)) {
//			System.out.println("좌우대칭이 아닙니다.");
//		} else if (hasDiffCass) {
//			System.out.println("대/소문자가 다르지만 좌우대칭입니다.");
//		} else {
//		   	System.out.println("(1) 좌우대칭입니다.");
//		}
		
		
//		char front = 0;
//		char back = 0;
//		int a , b; 
//		for (int i = 0; i < user_date.length(); i++) {
////			front = user_date.charAt(i);
//			back = user_date.charAt(user_date.length() - 1 - i);
//			System.out.print(back);
//		} 
//		String back2 = next(back);
//		System.out.print(back2);

	}

}
