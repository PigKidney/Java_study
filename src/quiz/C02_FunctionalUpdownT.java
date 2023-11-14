package quiz;

import java.util.Scanner;

public class C02_FunctionalUpdownT {
	// 만들었던 Updown 게임을 함수로 나눠서 다시 만들어보세요.

	// 사용자로부터 입력을 하나 받아오는 기능
	public static int getUserGuess() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정답을 맞춰보세요 > ");
		return sc.nextInt();
	}

	/**
	 * 랜덤값을 생성해주는 함수
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getWinNum(int start, int end) {
		// end - start + 1 : 범위 내의 숫자의 개수
		// start : 시작값
		return (int) (Math.random() * (end - start + 1) + start);
	}

	/**
	 * 사용자가 추측한 값의 결과를 반환하는 함수
	 * 
	 * @param userGuess 사용자가 추측한 번호
	 * @param winNum    - 승리 번호
	 * @return 0은 up, 1은 down, 2는 정답
	 */
	public static int checkWin(int userGuess, int winNum) {
		if (userGuess == winNum) {
			return 2;
		} else if (userGuess > winNum) {
			return 1;
		} else if (userGuess < winNum) {
			return 0;
		}

		return -1;
	}


	public static void main(String[] args) {
		int start = 1;
		int end = 100;
		int chance = 5;

		int winNum = getWinNum(start, end);

		while (chance > 0) {

			int userGuess;
			while (true) {
				userGuess = getUserGuess();
				if (userGuess >= start && userGuess <= end) {
					break;
				}
				System.out.printf("%d ~ %d 사이의 값을 입력해주세요.\n",start,end);
			}

			int result = checkWin(userGuess, winNum);

			switch (result) {
			case 0:
				System.out.printf("UP! (남은기회: %d)\n", --chance);
				break;
			case 1:
				System.out.printf("Down! (남은기회: %d)\n", --chance);
				break;
			case 2:
				System.out.println("정답입니다!!");
				return; // main에서 return을 하는 것은 프로그램의 종료를 의미한다.
			case -1:
				System.out.println("에러가 발생했습니다");
				return;
			default:
				System.out.println("예측하지 못했던 값이 발생했습니다");
				return;
			}
		}

		System.out.printf("기회를 모두 사용하셨습니다... 정답은 %d이었습니다", winNum);
	}
}
