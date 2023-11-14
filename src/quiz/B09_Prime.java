package quiz;

import java.util.Scanner;

public class B09_Prime {
	public static void main(String[] args) {
		/*
		 * 
		 * 사용자가 정수를 입력하면 1부터 입력한 정수 사이에 있는 모든 소수를 출력해보세요.
		 * 
		 * ※ 소수(prime) : 나누어 떨어지는 수가 1과 자기 자신밖에 없는 수
		 * 
		 */

		System.out.print("숫자를 입력해 주세요 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 2; i <= num; ++i) {
			boolean isPrime = true; // <- 반복문 안에서 초기화
			//int count = 0; // <- 여기서 들어가면 두번째 for문을 돌고 count가 초기화가 된다!
			// 이번 숫자 i에 대한 약수 개수 검사
			//(1) 약수가 2개인지 검사하기
			//(2) 2부터 i-1에 약수가 존재하면 소수가 아님
			//(3) 2부터 루트 i까지 약수가 존재하면 소수가 아님
			for (int chk = 2; chk <= Math.sqrt(i); ++chk) {
				if (i % chk == 0) {
					isPrime = false;
					break;
					// System.out.printf("%d는 %d로 나누어떨어집니다.[약수의 개수 : %d개]\n",i,chk,count);
				}
			}
			// 검사가 끝났을 때 약수가 2개라면 소수
			// System.out.printf("%d는 소수인가요? %s\n",i,count==2);
			if (isPrime) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

// ------------------------------------------------------------------------------------------------------		
//		
//		// 몇번 할건지 횟수라 => 입력한 num 값 만큼 계산을 할거다!
//		for (int i = 1; i <= num; i++) {
//			int count = 0; // <- 여기서 들어가면 두번째 for문을 돌고 count가 초기화가 된다!
//			// 그때 j가 1부터 num까지 증가를 시키면서 딱 나누어 떨어지는지를 계산 해서 카운트한다.
//			// 소수는 자신과 1뿐이니까 카운트가 2이어야만 한다.
//			// System.out.print(i+" ");
//			for (int j = 1; j <= i; j++) {
//
//				if (i % j == 0) {
//					++count;
//				}
//			}
//			// 그렇게 카운트가 2가 된 숫자들을 밖으로 꺼내온다!
//			if (count == 2) {
//				System.out.print(i + " ");
//			}
//			
//		}
//
//		

	}

}
