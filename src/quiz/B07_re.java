package quiz;

import java.util.Scanner;

public class B07_re {
	public static void main(String[] args) {
		System.out.print("좌우대칭인지 알고 싶은 문자를 입력하세요 : ");

		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		String reword = ""; // 좌우반전으로 얻은 값 변수지정
		String result = "";
		// 대문자 소문자가 모두 포함되었는지 여부를 체크
//		boolean hasDiffCass = false;
		
		int lowerCount = 0;
		int upperCount = 0;
		
		for(int i = 0 ; i < word.length(); ++i) {
			char ch =word.charAt(i);
			if(ch>='A' && ch <='Z') {
				++upperCount;
			} else if (ch>='a' && ch<='z') {
				++lowerCount;
			}
		}
	
		boolean hasDiffCass = upperCount > 0 && lowerCount >0;
		
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i); // 입력문자를 char단위로 나누는 과정 한글자씩 검사한다.
			if (ch >= 'a' && ch <= 'z') {
				result += (char) (ch - 32);
			} else {
				result += ch;
			} 
		}
		for (int i = 0; i < result.length(); i++) {
			reword += result.charAt(result.length() - 1 - i); // 좌우반전으로 reword에 +=연산으로 스택 쌓기
		}



		// if로 확인 -> 문자열이기 때문에 xx.equals() 로 서로의 크기가 맞나 확인
		if (result.equals(reword) && hasDiffCass) {
			System.out.println("대소문자가 다르지만 대칭입니다.");
		} else if(result.equals(reword)) {
			System.out.println("좌우 대칭입니다.");
		} else {
			System.out.println("좌우대칭이 아닙니다.");
		}

	}
}
