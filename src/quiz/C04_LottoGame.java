package quiz;

import java.util.Arrays;
import java.util.Scanner;

import myobj.LottoGame;

public class C04_LottoGame {
	/*
	 * # 로또 게임 만들기
	 * 
	 * 1. 당첨 번호는 7개이고 1등 당첨이 되면 다음 당첨 번호로 넘어간다.
	 * 
	 * 
	 * 2. 플레이어는 번호 6개를 입력해 숫자를 맞춰야 한다
	 * 
	 * 3. 1등 : 앞에 6개의 숫자를 모두 맞춤 (+10억) 2등 : 보너스 번호를 포함한 6개의 숫자를 맞춤 (+8천만원) 3등 : 5개의
	 * 숫자를 맞춤 (보너스 번호 미포함) (+150만원) 4등 : 4개의 숫자를 맞춤 (보너스 번호 미포함) (+5만원) 5등 : 3개의 숫자를
	 * 맞춤 (보너스 번호 미포함) (+5천원)
	 * 
	 * 
	 * 4. 플레이어가 게임을 종료할때까지 게임이 계속 된다
	 * 
	 * <화면 예시> 1. 자동 구매 2. 수동 구매 3. 현재까지의 이력 확인 (사용 금액, 당첨 횟수, 손익 계산) 4. 프로그램 종료
	 * 
	 */
	public static void main(String[] args) {
		LottoGame u1 = new LottoGame();
		
//		int[] winNum = u1.getWinNum();
		int[] winLotto = u1.getWinNum();
//		System.out.println("1등번호 : " + Arrays.toString(winLotto));
		int gameOver=0;
		
		while(gameOver<1) {
			
			int select = u1.mainMenu();
			if (select == 1) {
				System.out.println("원하시는 게임 수량을 입력해주세요");
				Scanner sc = new Scanner(System.in);
				int coin = sc.nextInt();
				if(coin<0) {
					System.out.println("올바른 게임 숫자를 입력해주세요");
				}
				for(int i=0; i<coin; i++) {
					int[] ranNum = u1.myNum();
					int chkNum = u1.chkPlace(ranNum, winLotto);
					System.out.println(u1.printPlace(chkNum));
					if(chkNum==1) {
//						System.out.println("1등번호 : " + Arrays.toString(winLotto));
						winLotto = u1.getWinNum();
					}
				}
				
			} else if (select == 2) {
				int[] selfNum = u1.selectMyNum();
				int chkNum = u1.chkPlace(selfNum, winLotto);
				System.out.println(u1.printPlace(chkNum));
				if(chkNum==1) {
					winLotto = u1.getWinNum();
//					System.out.println("1등번호 : " + Arrays.toString(winLotto));
				}
			} else if (select == 3) {
				u1.userInfo();
			} else if (select == 4) {
				++gameOver;
			}
			
		}
		System.out.print("종료하겠습니다.");

	}

}
