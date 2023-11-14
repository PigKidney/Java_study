package myobj;

import java.util.Arrays;
import java.util.Scanner;

public class LottoGame {
	int pay=1000;
	int money;
	int playTime;
	int first;
	int second;
	int third;
	int fourth;
	int fifth;
	int[] winNum;
	
	/**
	 * 게임 메인화면 도출 
	 * @return
	 */
	public int mainMenu() {
		System.out.print("1. 자동 구매\r\n" + "2. 수동 구매\r\n" + "3. 현재까지의 이력 확인 \r\n" + "4. 프로그램 종료 \r\n");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		return select;
	}

	/**
	 * 수동게임
	 * 
	 * @param myNum
	 */
	public int[] selectMyNum() {
		System.out.println("1~45사이의 번호를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int[] myNum = new int[6];
		for (int i = 0; i < 6; i++) {
			int num = sc.nextInt();
			if (num > 0 && num < 46) {
				myNum[i] = num;
				int count = 0;
				for(int j=0; j<myNum.length;j++) {
					if(myNum[j] == num) {
						++count;
//						System.out.println(count);
						if(count==2) {
							System.out.println("중복된 숫자를 입력하셨습니다.");
							--i;
						}
					}
				}
			} else {
				System.out.println("1~45까지만 입력가능!!");
				--i;
			}
			
		}
		for (int i = 0; i < myNum.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = 0;
				if (myNum[i] < myNum[j]) {
					temp = myNum[i];
					myNum[i] = myNum[j];
					myNum[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(myNum));
		return myNum;
	}

	/**
	 * 1등 번호 생성
	 * 
	 * @return
	 */
	public int[] getWinNum() {
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

	/**
	 * 자동게임
	 * 
	 * @return
	 */
	public int[] myNum() {
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
		System.out.println(Arrays.toString(num));
		return num;
	}
	
	/**
	 * 복권 등수확인프로그
	 * @param myNum
	 * @param winNum
	 * @return
	 */
	public int chkPlace(int[] myNum, int[] winNum) {

		boolean hasBonusNum = false;
		int winCount = 0;

		for (int userIndex = 0; userIndex < myNum.length; ++userIndex) {
			for (int winIndex = 0; winIndex < winNum.length; ++winIndex) {
				if (myNum[userIndex] == winNum[winIndex]) {
					if (winIndex == 6) {
						hasBonusNum = true;
					}
					++winCount;
				}
			}
		}
		// 당첨번호가 6개일
		if (winCount == 6) {
			if (hasBonusNum) {
				return 2;
			} else {
				return 1;
			}
		} else if (winCount == 5) {
			return 3;
		} else if (winCount == 4) {
			return 4;
		} else if (winCount == 3) {
			return 5;
		}
		return 0;
	}
	
	/**
	 * 확인된 등수별로 돈 지금 후 사용자 정보 업데이트 
	 * @param chkNum
	 * @return
	 */
	public String printPlace(int chkNum) {
		++playTime;
		if (chkNum == 1) {
			++first;
			money+=1000000000;
			return "1등입니다";
		} else if (chkNum == 2) {
			++second;
			money+=80000000;
			return "2등입니다";
		} else if (chkNum == 3) {
			++third;
			money+=1500000;
			return "3등입니다";
		} else if (chkNum == 4) {
			++fourth;
			money+=50000;
			return "4등입니다";
		} else if (chkNum == 5) {
			++fifth;
			money+=5000;
			return "5등입니다";
		} else {
			return "낙첨입니다";
		}

	}
	
	/**
	 * 게임 진행사항 표시
	 */
	public void userInfo() {
		System.out.printf("현재 상태\n사용금액 : %d원\n당첨 횟수 : 1등[%d] 2등[%d] 3등[%d] 4등[%d] 5등[%d]\n손익 : %d원\n", this.pay*this.playTime, this.first,
				this.second, this.third, this.fourth, this.fifth,this.money-(this.pay*this.playTime));
	}

	/**
	 * 게임 자동으로 출력시 게임 수 입력 기능
	 * @param coin
	 */
	public void multBuy(int coin) {
		
		for(int i=0; i<coin; i++) {
			int[] ranNum = this.myNum();
			int chkNum = this.chkPlace(ranNum, winNum);
			System.out.println(this.printPlace(chkNum));
		}
	}

}
