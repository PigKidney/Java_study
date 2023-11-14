package myobj.prize;

import java.util.Arrays;
import java.util.Scanner;

public class Prize {

	// 1~6등 1등-1개 2등-2개 3등-4개 4등-8개 5등-16개 6등-32개
	// 기본적으로 그렇지만 몇개의 상품이 있는지 직접 넣을 수 있게 만들고 int[num] => num이 등수 개수 int[num] =
	// 'num1' => num1은 그 등수 상품의 개수
	// 각 등수에 상품이 몇개인지 설정한다

	int[] prizeType;
	int[] prob;
	int totalPrize;


//	public void Prize(int num) {
//		this.prizeType = new int [num];
//		setPrizeNum();
////		setProbability();	
//	}
//	
	public void prize() {
		Scanner sc = new Scanner(System.in);
		System.out.println("원하시는 상품의 개수");

		this.prizeType = new int[sc.nextInt()];
		setPrizeNum();
//		setProbability();
	}

	public int[] setPrizeNum() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < prizeType.length; i++) {
			System.out.print((i + 1) + "등의 상품의 개수를 입력해주세요 => ");
			int num = sc.nextInt();
			prizeType[i] = num;
			totalPrize += num;
		}
		return prizeType;
	}

	public void info() {
		System.out.print("뽑기 정보 => ");
		for (int i = 0; i < prizeType.length; i++) {
			System.out.print(" | " + (i + 1) + "등 : " + prizeType[i] + "개 ");
//			System.out.print(" | "+(i+1)+"등 : " + prizeType[i] + "개 [확률:"+prob[i]+"%]");
		}
	}

//	public int[] setProbability() {
//	
//	}

//	public int[] setProbability() {
//		Scanner sc = new Scanner(System.in);
//		for(int i = 0 ; i < prizeType.length ; i++) {
//			System.out.print((i+1)+"등의 상품의 뽑기 확률[1~100]%을 입력해주세요 => ");
//			prob[i]=sc.nextInt();
//		}
//		return prob;
//	}

//	@Override
//	public String toString() {
//		return "상품의 남은 개수 : " + Arrays.toString(prizeType);
//	}
}
