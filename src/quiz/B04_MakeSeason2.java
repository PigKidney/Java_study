package quiz;

import java.util.Scanner;

public class B04_MakeSeason2 {
	public static void main(String[] args) {
		/*
		    사용자가 몇 월인지 입력하면 해당하는 계절이 무엇인지 출력해보세요
		    (switch-case문으로 한번, if문으로도 한번)
		  
		  		  
		 */
	Scanner sc = new Scanner(System.in);
	System.out.println("확인 원하시는 ' '월을 입력해주세요. : ");
	int user_date = sc.nextInt();
	String season = ""; // 기억해야할듯
	
	
	if (user_date<=0 || user_date>12) {
		System.out.println("잘못된 숫자를 입력하셨습니다.");
	} else {
		if (user_date == 12 || user_date <= 2) {
			season = "겨울";
			
		} else if(user_date >=3 && user_date <= 5) {
			season = "봄";
		} else if(user_date >=6 && user_date <= 8) {
			season = "여름";
		} else if(user_date >=9 && user_date <= 11){
			season = "가을";
		}
		
		
		System.out.printf("해당 월의 계절은 %s입니다.",season);
	}
	
	
	
	}
	
	
}
