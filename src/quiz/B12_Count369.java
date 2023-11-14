package quiz;

import java.util.Scanner;

public class B12_Count369 {
	public static void main(String[] args) {
		/*
		 * 100~500 사이의 랜덤 양의 정수를 하나 생성하고 해당 숫자까지 369를 진행한다면 박수를 총 몇 번 쳐야하는지 출력해보세요.
		 * 
		 */

//		Scanner sc = new Scanner(System.in);
		int maxNum = (int) (Math.random() * 401 + 100);
		int clapCount = 0;

		for (int i = 1; i <= maxNum; ++i) {
			System.out.print(i + " : ");
			
//			// (1) 숫자를 문자열로 바꿔서 센다.
//			String numStr = "" + i;
//			for (int j = 0; j < numStr.length(); ++j) {
//				char ch = numStr.charAt(j);
//				if (ch == '3' || ch == '6' || ch == '9') {
//					System.out.print("짝");
//					++clapCount;
//				}
//			}
//		}
			// (2) 숫자를 한자리씩 검사하여 3,6,9 인지 센다.
			int chkNum = i;

			// 이번에 검사할 숫자를 10씩 나누면서 일의 자리만 검사하기
			while (chkNum > 0) {
				// 일의 자리 분리
				int digit = chkNum % 10;
				if (digit != 0 && digit % 3 == 0) {
					System.out.print("짝");
					++clapCount;
				}
				chkNum /= 10;
			}
			System.out.print("\t\t- 누적 " + clapCount + "회");
			System.out.println();

		}


//		int maxNum = 400;
//		int count = 0;
//		for (int chk = 0; chk < maxNum; chk++) {
//
//			int num1 = chk % 10;
//			int num2 = chk % 100 / 10;
//			int num3 = chk / 100;
//
//			// 일의 자리
//			if (num1 == 3 || num1 == 6 || num1 == 9) {
//				++count;
//			}
//			// 십의 자리
//			if (num2 == 3 || num2 == 6 || num2 == 9) {
//				++count;
//			}
//			// 백의 자리
//			if (num3 == 3 || num3 == 6 || num3 == 9) {
//				++count;
//			}

// =====================================================================================================			

//			if(chk%10==3) {
//				count++;
//			} else if(chk%10==6) {
//				count++;
//			} else if(chk%10==9) {
//				count++;
//			}
//			
//			if(chk%100/10==3) {
//				count++;
//			} else if(chk%100/10==6) {
//				count++;
//			} else if(chk%100/10==9) {
//				count++;
//			}
//			
//			if(chk/100==3) {
//				count++;
//			} else if(chk/100==6) {
//				count++;
//			} else if(chk/100==9) {
//				count++;
//			}

//		System.out.printf("%d의 숫자에서 %d번의 박수를 칩니다", maxNum, count);

	}
}
