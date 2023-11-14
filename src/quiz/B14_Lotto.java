package quiz;

public class B14_Lotto {
	public static void main(String[] args) {
		/*
		 * 1. 랜덤으로 로또 당첨 번호를 생성해보세요 (1~45의 중복 없는 랜덤 숫자 7개, 마지막 번호는 보너스 번호)
		 * 
		 * 2. 1등에 당첨될때까지 로또 번호를 자동으로 계속 생성하여 몇 번 만에 당첨되었는지 출력해보세요. (자동 번호는 1~45의 중복 없는
		 * 랜덤 숫자 6개)
		 * 
		 * 3. 1등에 당첨 될 때까지 뽑는 동안 2등에 당첨되는 번호들이 있으면 출력해주세요.
		 * 
		 */

		int[] winerNum = new int[7];

		System.out.print("로또 번호 : ");
		for (int i = 0; i < winerNum.length; i++) {
			winerNum[i] = (int) (Math.random() * 45) + 1;
			// 중복 제거를 해보자
			for (int j = 0; j < i; j++) {
				if (winerNum[i] == winerNum[j]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < winerNum.length; i++) {
//			System.out.print(winerNum[i] + " ");
		}
//		System.out.println();

		// 내 로또 출력
		int totalcount = 0;
		int loser = 0;
//		System.out.print("내 로또 번호 : ");
		boolean win = false;
		int[] myLotto = new int[6];
		for (int otherNum = 0;; otherNum++) {
			for (int i = 0; i < myLotto.length; i++) {
				myLotto[i] = (int) (Math.random() * 45) + 1;
				for (int j = 0; j < i; j++) {
					if (myLotto[i] == myLotto[j]) {
						i--;
						break;
					}
				}
			}
			for (int i = 0; i < myLotto.length; i++) {
//				System.out.print(myLotto[i] + " ");
			}
			++totalcount;
			
			// System.out.println();
			int count = 0;
			boolean bonusNum = false;
			for (int i = 0; i < myLotto.length; i++) {
				for (int j = 0; j < i; j++) {
					if (myLotto[i] == winerNum[j]) {
						if(j==6) {
							bonusNum = true;
						}
					}
					count++;
				}
			}
			if (count == 6) {
				if(bonusNum) {
					System.out.printf("%d번만에 2등에 당첨되었습니다.",totalcount);
				}else {
					System.out.printf("%d번만에 1등에 당첨되었습니다.",totalcount);
					break;
				}
			} else {
				otherNum = 0;
			}


//			System.out.println("\tcount: " + count + "\ttotal: " + totalcount + "\t2등: " + loser);
		}

//		if (win) {
//			System.out.println(totalcount);
//		}

//		if (win) {
//			System.out.println(totalcount);
//		}

//		System.out.println("총 : " + totalcount);
//		System.out.print(myLotto[i] + " ");

//		System.out.println();
//		if (count == 6) {
//			System.out.printf("%d개 맞추셔서 당첨입니다.",count); 
//		} else {
//			System.out.printf("%d개 맞추셔서 미당첨입니다.",count);
//		}
//		
	}
}
