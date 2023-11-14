package quiz;

import java.util.Arrays;
import java.util.Scanner;

public class C01_FunctionQuiz3 {
	/*
	 * 실행하면 1~45의 중복없는 7개의 숫자로 이루어진 int[]을 반환하는 함수를 만들어보세요.
	 */

	public static int[] randomNum() {
		int[] num = new int[7];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (num[i] == num[j]) {
					--i;
					break;
				}
			}
		}
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = 0;
				if (num[i] < num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		return num;
	}

	public static int[] myRandomNum() {
		int[] num = new int[6];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (num[i] == num[j]) {
					--i;
					break;
				}
			}
		}
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = 0;
				if (num[i] < num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		return num;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] winNum = randomNum();
		System.out.println("1등 번호 : " + Arrays.toString(winNum));
		System.out.print("원하시는 게임 수를 입력 하세요 : ");
		int coin = sc.nextInt();

//		int totalGame = 0;
		int count = 0;
		for (int i = 0; i < coin; i++) {
			System.out.println("[" + (count + 1) + "번 게임] : " + Arrays.toString(myRandomNum()));
			count++;
			if (count % 5 == 0) {
				System.out.println("-----------------------------------------");
			}
		}
//		boolean win = false;
//		int pass = 0;
//		
//		for (int i = 0; i < 7; i++) {
//			for (int j = 0; j < 6; j++) {
//				if (winNum[i] == myNum[j]) {
//					pass++;
//				}
//			}
//		}
//		if(pass == 6) {
//			win = true;
//		} else if(pass > 6) {
//			pass = 0;
//		}
//		++totalGame;
//
//		if(win) {
//			System.out.printf("축하합니다 %d회 만에 1등입니다",totalGame);
//		}
//		System.out.println("이용해 주셔서 감사합니다.");
//		System.out.println(Arrays.toString(randomNum()));
	}
}
