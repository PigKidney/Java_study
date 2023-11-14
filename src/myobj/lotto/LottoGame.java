package myobj.lotto;

import java.util.Arrays;
import java.util.Scanner;

public class LottoGame {

	Scanner sc = new Scanner(System.in);
	LottoNumber winNum = new LottoNumber(true);
	
	//(사용 금액, 당첨 횟수, 손익 계산)
	int prize;
	int[] prizeCount = new int[6];
	long[] prizeAmount = {0 , 10000000000L, 800000000L, 1500000L, 50000L, 5000L};
	
	public LottoNumber getLottoNumberManual() {
		int count = 0;
		int[] nums = new int[6];
		
		
		while (count < 6) {
			//우리는 0이 사용하기 편하지만 사용자들에게는 1부터 나오도록 해준다
			System.out.printf("%d번째 숫자를 입력해주세요 : ",count +1);
			int num=sc.nextInt();
			
			if(num <1 || num >45) {
				System.out.println("1~45 사이의 숫자를 골라주세요!");
				continue;
			} 
			
			boolean duplicate = false;
			for(int i = 0 ; i < count; ++i) {
				if(nums[i] == num) {
					System.out.println("중복되는 값이 있습니다!" + "다시 선택해 주세요!");
					duplicate = true;
					break;
				}
			}
			
			if (duplicate) {
				continue;
			}
			//검사를 모두 통과한 숫자만 배열에 들어갈 수 있다.
			nums[count++]=num;
			
			//숫자 오름차순으로 재배치
//			for (int i = 0; i < nums.length; i++) {
//				for (int j = 0; j < i; j++) {
//					int temp = 0;
//					if (nums[i] < nums[j]) {
//						temp = nums[i];
//						nums[i] = nums[j];
//						nums[j] = temp;
//					}
//				}
//			}
		}
		// 다 만든 1~45사이의 중복값 없는 int[]을 전달해 인스턴스를 생성한 후 리턴
		return new LottoNumber(nums);
	}
	

	
	public void printGameInfo() {
		int spent = 0;
		long prize = 0;
		
//		prize += prizeCount[1]*10000000000L;
//		prize += prizeCount[2]*800000000L;
//		prize += prizeCount[3]*1500000L;
//		prize += prizeCount[4]*50000L;
//		prize += prizeCount[5]*5000L;
		
		for(int i = 0 ; i <prizeCount.length; i++) {
			spent += prizeCount[i]*1000; 
			prize += prizeCount[i]*prizeAmount[i];
		}
		
		System.out.printf("총 사용금액 : %d원\n",spent);
		System.out.printf("손익 : %d",prize-spent);
		System.out.println("\n## 당첨 이력 ##");
		for(int i = 0 ; i<prizeCount.length; i++) {
			System.out.printf("%d등 : %d회\n",i,prizeCount[i]);
		}
		System.out.println("##################");
	}
	
	
	
	
	
	public void play() {

		while (true) {
			System.out.println("1. 자동 구매");
			System.out.println("2. 수동 구매");
			System.out.println("3. 현재까지의 이력 확인");
			System.out.println("4. 게임 종료");
			System.out.println("> ");
			int userSelect = sc.nextInt();

			int result = -1;
			
			switch (userSelect) {
			case 1:
				result = new LottoNumber(false).check(winNum);
				break;
			case 2:
				result = getLottoNumberManual().check(winNum);
				break;
			case 3:
				printGameInfo();
				break;
			case 4:
				System.out.println("게임을 종료합니다.");
				return;
			default:
				break;
			}
			if(result != -1) {
				++prizeCount[result];
				System.out.println("디버깅용 당첨번호 : "+Arrays.toString(winNum.numbers));
				
				if (result == 0) {
					System.out.println("당첨되지 않았습니다...");
				} else {
					System.out.printf("%d등 당첨!!!\n",result);
				}
			}
		}
	}
}
