package quiz;

import java.util.Scanner;

public class B00_DollarSwap {
	
	// 한국 돈을 입력하면 현재 환율로 몇 달러인지 알려주는 프로그램을 만들어보세요.
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		System.out.print("환율 계산기 (￦->$)\n");
//		System.out.print("-----------------\n\n");
//		System.out.print("금액을 입력하세요 : ");
//		
//		int krw = sc.nextInt();
//		double exchangeRate = 0.00075;
//		double dollar = krw*exchangeRate;
//		
//		System.out.printf("\n보유하고 있는 금액은\n%.2f $입니다", dollar);
		
		System.out.print("얼마를 환전하시겠습니까?\nKRW : ");
		int krw = sc.nextInt();
		double exchange_rate = 1332.74;
		double usd = krw / exchange_rate;
		
		System.out.printf("%dKRW은 %.2fUSD입니다.\n", krw, usd);
		
	}

}
