package quiz;

import java.util.Scanner;

public class D08_isPhoneNumber {
	/*
	 * 사용자로부터 입력받은 문자열이 유효한 핸드폰 번호인지 검사하는 메서드를 만들어보세요
	 * 
	 */
//	public static int isNum(String num, char ch) {
//		if (num.charAt(3) == ch && num.charAt(8) == ch) {
//			String[] nums = num.split(String.valueOf(ch));
//			for (int i = 0; i < nums.length; i++) {
//				for (int j = 0; j < 3; j++) {
//					if (nums[i].charAt(j) < '0' || nums[i].charAt(j) > '9') {
//						return -1;
//					}
//				}
//			}
//		}
//		return 1;
//	}
//	
//	
//	public static boolean isPhoneNumber(String num) {
//		// 010-1111-1111
//		num.trim();
//		if (num.startsWith("010") && num.length() == 13) {
//		} else {
//			return false;
//		}
//		if(isNum(num,' ')==-1) {
//			if(isNum(num,'-')==1) {
//				return true;
//			} else {
//				return false;
//			}
//		} else {
//			return true;
//		}
//	
//		
//	}
//
//	public static boolean isPhoneNumber2(String num) {
//		// 010-1111-1111
//		num.trim();
//		if (num.startsWith("010") && num.length() == 11) {
//		} else {
//			return false;
//		}
//		for (int i = 0; i < num.length(); i++) {
//			if (num.charAt(i) < '0' || num.charAt(i) > '9') {
//				return false;
//			}
//		}
//		return true;
//
//	}
	
	public static boolean isVaildPhoneNumber(String phoneNumber) {
		if(!phoneNumber.startsWith("010")) {
			System.out.printf("[INFO] %s는 010으로 시작하지 않는 휴대폰번호입니다.\n",phoneNumber);
			return false;
		}
		
		String hyponRemovedNumber = phoneNumber.replace("-", "");
		
		for(int i = 0, len = hyponRemovedNumber.length(); i < len ; i++) {
			if(!Character.isDigit(hyponRemovedNumber.charAt(i))) {
				System.out.printf("[INFO] %s는 숫자가 아닌것이 포함되어 있습니다.\n",phoneNumber);
				return false;
			}
		}
		
		if(hyponRemovedNumber.length() != 11) {
			System.out.printf("[INFO] %s는 숫자가 아닌것이 포함되어 있습니다.\n",phoneNumber);
			return false;
		}
		
		int len = phoneNumber.length();
		
		if(!(len == 11 || len == 13)) {
			System.out.printf("[INFO] %s는 번호 길이가 잘못되었습니다.\n",phoneNumber);
			return false;
		} 
		
		if (len ==13) {
			if(phoneNumber.charAt(3) !='-' || phoneNumber.charAt(8) !='-') {
				System.out.printf("[INFO] %s는 '-'가 없거나 위치가 이상합니다.\n",phoneNumber);
				return false;
			}
			int hyponCount = 0;
			for (int i = 0 ; i < len ; i++) {
				if(phoneNumber.charAt(i)=='-') {
					++hyponCount;
				}
			}
			if (hyponCount != 2) {
				System.out.printf("[INFO] %s는 올바른 형식의 핸드폰 번호가 아닙니다.\n",phoneNumber);
				return false;
			}
		}
		
		
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		
//		System.out.println("핸드폰 번호를 입력해주세요");
//		String userInputData = sc.nextLine();
//
//		if (isPhoneNumber(userInputData)) {
//			System.out.println(userInputData + "는 유효한 핸드폰 번호입니다.");
//		} else {
//			if (isPhoneNumber2(userInputData)) {
//				System.out.println(userInputData + "는 유효한 핸드폰 번호입니다.");
//			} else {
//				System.out.println(userInputData + "는 유효한 핸드폰 번호가 아닙니다.");
//			}
//		}

	}
}
