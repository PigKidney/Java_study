package myobj;

import java.util.Scanner;

public class Game369 {

	String an1 = "짝";
	String an2 = "ㅉ";
	String an3 = "";
	int uperNum = 0;
	boolean gameContinue=true;
	/**
	 * 박수쳐야하는 횟수 검사
	 * 
	 * @param chkNum
	 * @return
	 */
	public int clapTimes(int chkNum) {
		int toClap = 0;
		while (chkNum > 0) {
			int digit = chkNum % 10;
			if (digit != 0 && digit % 3 == 0) {
				toClap++;
			}
			chkNum /= 10;
		}
		return toClap;

	}

	/**
	 * '짝' && 'ㅉ'을 369 없을경우 \n
	 */
	public void game369Start() {

		System.out.println("게임을 시작합니다.");
		if (randomStart() == 1) {
			// 컴터 먼저
			while (gameContinue) {
				uperNum++;
				if (uperNum % 2 == 0) {
					System.out.print("user : "+uperNum + " => ");
					userAns();
				} else {
					System.out.print("com : "+uperNum + " => ");
					computerAns();
				}
				System.out.println();

			}
		} else {
			//유저가 먼저 시작
			while (gameContinue) {
				uperNum++;
				if (uperNum % 2 != 0) {
					System.out.print("user : "+uperNum + " => ");
					userAns();
				} else {
					System.out.print("com : "+uperNum + " => ");
					computerAns();
				}
				System.out.println();
			}

		}
	}

	/**
	 * 1이면 컴퓨터 2이면 사람
	 * 
	 * @return
	 */
	public int randomStart() {
		return (int) (Math.random() * 2 + 1);
	}

	public boolean computerFalse() {
		int result = (int) (Math.random() * 4 + 1);
		if (result == 4) {
			return false;
		}
		return true;
	}

	public boolean userAns() {
		Scanner sc = new Scanner(System.in);
		int clapAns = clapTimes(uperNum);
		String select = sc.nextLine();
		if (clapAns > 0) {
			int[] usclap = new int[clapAns];
			for (int i = 0; i < usclap.length; i++) {
				if (!select.equals(an1) && !select.equals(an2)) {
					System.out.println("게임에 패배하셨습니다.");
					return gameContinue=false;
				}
			}

		} else if (!select.equals(an3)) {
			System.out.println("게임에 패배하셨습니다.");
			return gameContinue=false;
		}
		return gameContinue=true;
	}
	
	public boolean computerAns() {
		int clapAns = clapTimes(uperNum);
		if (computerFalse()==false) {
			for (int i = 0; i < clapAns + 1; i++) {
				System.out.printf("%s ", an1);
			}
			System.out.println("\n승리하셨습니다.");
			return gameContinue=false;
		} else {
			for (int i = 0; i < clapAns; i++) {
				System.out.printf("%s \n", an1);
			}
		}
		return gameContinue=true;
	}
	
}
