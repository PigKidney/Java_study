package quiz;

import java.util.Scanner;

public class B03_AppleQuiz {
	public static void main(String[] args) {

		// Ctrl + Shift + F : 들여쓰기 맞추는 단축키
		// 블록지정하고 Ctrl + i : 블록지정한 부분 들여쓰기 맞추기

		Scanner nc = new Scanner(System.in);
		int BASKET_SIZE = 10;
		System.out.println("사과의 개수를 입력해주세요 >");

		int appleCount = nc.nextInt();
		int remain = (int) Math.ceil(appleCount / 10.0);

		if (appleCount < 0) {
			System.out.println("올바른 숫자를 입력해주세요.");
		} else {
			System.out.printf("총 %d개의 바구니가 필요합니다.", remain);
		}

//		Scanner nc = new Scanner(System.in);
//		
//		int BASKET_SIZE=10;	
//						
//		System.out.println("사과의 개수를 입력해주세요 > ");
//		int appleCount = nc.nextInt();
//		// 입력값 체크를 가장 먼저 처리하는 것이 좋다.
//		if(appleCount < 0) {
//			System.out.println("개수가 이상해 프로그램을 종료합니다.");
//		} else {
//			int basketcount = (int)Math.ceil(appleCount/10.0);	
//			System.out.printf("필요한 바구니의 개수는 %d개 입니다.\n",basketcount);
//		}
//		

//		int basketCount = appleCount / BASKET_SIZE;
//		int remain = appleCount % BASKET_SIZE;
//		
//		if (remain > 0) {
//			basketCount = basketCount + 1;
//		}

//		int num = nc.nextInt();
//		int basket = (num/10);
//		int basket_con = (num%10);					
//		
//		if (basket_con == 0 ){
//			System.out.printf("%d개의 사과를 담으려면 총 %d개의 바구니가 필요합니다.",num,(basket));
//		} 
//		else if(basket_con >= 0 ) { 
//			System.out.printf("%d개의 사과를 담으려면 총 %d개의 바구니가 필요합니다.",num,(basket+1));
//		} else{
//			System.out.println("실행할 수 없습니다.");
//			

//			
//		}
//		

	}

	// 사과를 10개씩 담을 수 있는 바구니가 있을 때
	// 사용자가 사과의 개수를 입력하면
	// 사과를 모두 담기 위해 바구니가 총 몇개 필요한지 알려주는 프로그램을 만들어보세요.
}
