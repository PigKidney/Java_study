package quiz;

import java.util.Scanner;

public class B08_Numeric {
	public static void main(String[] args) {
		/*
		 * 사용자가 입력한 문자열이 모두 숫자로만 구성된 문자열인지 판별하는 프로그램을 만들어보세요.
		 * 
		 * >> a1234 -> 모두 숫자인 문자열이 아닙니다.
		 * 
		 * >> 432413412 -> 모두 숫자인 문자열입니다.
		 * 
		 * 
		 */
		System.out.print("확인하고 싶은 문자열을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();

		// 방법 1 : 숫자의 개수를 센다, 문자열의 길이와 숫자의 개수가 같으면 모두 숫자

		// 방법 2 : 하나씩 보면서 숫자가 아닌게 하나라도 등장하면 모두 숫자가 아님 -> break

		boolean onlyNumber = true;

		// 한 문자씩 검사하다가 숫자가 아닌것이 발견되면 onlyNumber를 false로 바꾼다.
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			//onlyNumber = ch < '0' || ch > '9';
			if (ch < '0' || ch > '9') {
				onlyNumber = false;
				break;
			}
		}

		if (onlyNumber) {
			System.out.println("숫자로만 이루어진 문자열입니다.");
		} else {
			System.out.println("숫자로만 이루어지지 않았습니다.");
		}

//		System.out.print("확인하고 싶은 문자열을 입력하세요 : ");
//		Scanner sc = new Scanner(System.in);
//		String text = sc.nextLine();
//		int count = 0;
//		
//		for(int i = 0; i<text.length();i++) {
//			char ch = text.charAt(i);
//			if(ch<'0'|| ch>'9') {
//				++count;
//			}
//		}
//		
//		boolean numOther = count > 0;
//		
//		if(numOther) {
//			System.out.printf("%s 이 문자열은 모두 숫자가 아닙니다.",text);
//		} else {
//			System.out.printf("%s 이 문자열은 모두 숫자로 이루어져 있습니다.",text);
//		}

	}
}
