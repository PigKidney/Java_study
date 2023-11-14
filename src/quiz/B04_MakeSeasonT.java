package quiz;

import java.util.Scanner;

public class B04_MakeSeasonT {
	public static void main(String[] args) {
		System.out.println("원하시는 달을 입력해주세요 >");
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		
		
		switch(month) {
			case 12 : case 1 : case 2 :
				System.out.println("겨울");
				break;
			case 3 : case 4 : case 5 :
				System.out.println("봄");
				break;
			case 6 : case 7 : case 8 :
				System.out.println("여름");
				break;
			case 9 : case 10 : case 11 :
				System.out.println("가을");
				break;
			default:
				System.out.println("그러한 달은 없습니다.");
				break;
			
				
		}
		
		
		if (month < 1 || month >12) {
			System.out.println("그런 달은 없습니다.");
		} else if (month == 12 || month == 1 || month == 2) { //(month >= 11 || month <=2)
			System.out.println("겨울입니다.");
		} else if (month >= 9) {
			System.out.println("가을입니다.");
		} else if (month >= 6) {
			System.out.println("여름입니다.");
		} else {
			System.out.println("봄입니다.");
		}
		
		
		
		
	}
}
