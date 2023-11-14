package quiz;

import java.util.Scanner;

public class B07_ChangeCase {
	public static void main(String[] args) {
		/*
		 * 사용자가 문장을 입력하면 대문자는 소문자로, 소문자는 대문자로 바꿔서 출력해보세요. (영어가 아닌 문자는 그대로 출력)
		 * 
		 */

		// 대문자랑 소문자는 유니코드 값으로 32 차이가 난다.
		// 문장을 입력받고
		System.out.println(" 영문대소문자 변환기 │\n────────────────┘\n");
		System.out.print("문자를 입력하세요 : ");
		String word = new Scanner(System.in).nextLine();
		
		String result = "";
		// 한글자씩 검사한다.
		for(int i = 0; i<word.length(); ++i) {
			char ch = word.charAt(i); //입력문자를 char단위로 나누는 과정
			if(ch>='a'&& ch<='z') {
				result += (char)(ch-32);
			} else if (ch >= 'A' && ch <= 'Z') {
				result += (char)(ch+32);
			} else {
				result +=ch;
			}
		}
		System.out.println("원본 : "+word);
		System.out.println("바뀐것 :"+result);
		
		
		
		
		
		
		
		
		
		
		
// 밑으로 내가한거		
//	───────────────────────────────────────────────────────────────────────────────────────
		
//		char alp;
//
//		for (int i = 0; i < word.length(); i++) {
//			alp = word.charAt(i);
//			char ch_s = (char)(alp + 32);
//			char ch_b = (char)(alp - 32);
//			if (alp <= 90 && alp >= 65) {
//				System.out.print(ch_s);
//			} else if (alp <= 122 && alp >= 97) {
//				System.out.print(ch_b);
//			} else {
//				System.out.print(alp);
//			}
//		}
//		System.out.print(" 입니다.");
	}
}
