package quiz;

import java.util.Scanner;

//아메리카노가 1600원 카페라떼 2700원 카페모카 3300원
		// 커피 3개의 개수를 입력받고 각 메뉴를 몇 잔 시켰는지와 총 가격은 얼마인지 출력해주는 프로그램을 만들어보세요.
		//처음 주는 값은 가능한 초기화 해놓기
public class B00_Starbucks {
	public static void main(String[] args) {
		
		int AMC_PRICE = 1600; 						//각 상품 가격 설정
		int CAL_PRICE = 2700; 
		int MOL_PRICE = 3300; 
		
		Scanner sc = new Scanner(System.in);   		// 사용자에게 입력 받기
		System.out.print("주문하실 아메리카노 수량 : ");
		int am_cano = sc.nextInt();	
		System.out.print("주문하실 카페라떼 수량 : ");
		int ca_latt = sc.nextInt();	
		System.out.print("주문하실 카페모카 수량 : ");
		int mo_latt = sc.nextInt();
		
		int total_order = am_cano+ca_latt+mo_latt; 	// 주문 받은 총 갯수
		
		int amc_toptalp = am_cano*AMC_PRICE;		// 주문 받은 음료 각 가격 계산
		int cal_toptalp = ca_latt*CAL_PRICE;
		int mol_totalp = mo_latt*MOL_PRICE;
		
		
		int total_price = amc_toptalp+cal_toptalp+mol_totalp; // 주문 받은 음료 총 가격 계산
		
		String format = "아메리카노\t\t%d잔 : %d￦\n"+
						"카페라떼\t\t%d잔 : %d￦\n"+
						"카페모카\t\t%d잔 : %d￦\n"+
						"--------------------\n"+
						"총합\t\t%d￦\n";
		System.out.printf(format,am_cano,amc_toptalp,ca_latt,cal_toptalp,mo_latt,mol_totalp,total_price);
		
//		System.out.printf("아메리카노 총 %d잔 %d원, 카페라떼 총 %d잔 %d원, 카페모카 총 %d잔 %d원 이고\n총 %d잔의 금액은 %d원 입니다.", 
//				am_cano,amc_toptalp,ca_latt,cal_toptalp,mo_latt,mol_totalp,total_order,total_price);

	}
}