package quiz;

import java.util.Scanner;

public class B04_MakeSeason {
	public static void main(String[] args) {
		/*
		    사용자가 몇 월인지 입력하면 해당하는 계절이 무엇인지 출력해보세요
		    (switch-case문으로 한번, if문으로도 한번)
		  
		  		  
		 */
	Scanner sc = new Scanner(System.in);
	System.out.println("확인 원하시는 ' '월을 입력해주세요. : ");
	int user_date = sc.nextInt();
		
		switch(user_date) {
			case 1 :
				System.out.println("겨울");
				break;
			case 2 :
				System.out.println("겨울");
				break;
			case 3 :
				System.out.println("봄");
				break;
			case 4:
				System.out.println("봄");
				break;
			case 5 :
				System.out.println("봄");
				break;
			case 6 :
				System.out.println("여름");
				break;
			case 7 :
				System.out.println("여름");
				break;
			case 8 :
				System.out.println("여름");
				break;
			case 9 :
				System.out.println("가을");
				break;
			case 10 :
				System.out.println("가을");
				break;
			case 11 :
				System.out.println("가을");
				break;
			case 12 :
				System.out.println("겨울");
				break;
			default :
				System.out.println("알맞은 숫자를 입력해주세요.");
				
				
		}
		
		
	}
}
