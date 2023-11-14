package quiz;

import java.util.Scanner;

public class B02_ConditionQuzi {
	public static void main(String[] args){
		/*
		 	1. int형 변수 a가 10보다 크고 20보다 작을 때 true.
		 	2. int형 변수 b가 짝수일 때 true
		 	3. int형 변수 c가 7의 배수일 때 true
		 	4. int형 변수 d와 e의 차이가 30일 때 true
		 	5. int형 변수 year가 400으로 나누어 떨어지거나 또는 4로 나누어 떨어지고 100으로 나누어떨어지지 않을 때 true 
		 	   (2월이 하루 더 있는 해를 구하는 방식)
		  	6. boolean형 변수 powerOn이 false 일 때 true
		  	7. 문자열 참조변수 str이 "yes" 일 때 true
			
		*/
		
		int a = 15;
		int b = 4;
		int c = 21;
		int d = 10;
		int e = 40;
		int year = 400;
		boolean powerOn = false;
		String str = "yes";
		
		
		System.out.println(a>10 && a<20);
		System.out.println(b%2 == 0 );
		System.out.println(c%7 == 0 );
//		System.out.println(d-e == 30 || d-e == -30 );
		System.out.println(Math.abs(e-d)==30);
		// ||보다 &&를 먼저한다
		System.out.println(year%400 == 0 || (year%4 ==0 && year%100 != 0));
		System.out.println(powerOn == false);
//		System.out.println(!powerOn); 
		System.out.println(str == "yes");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정말 제출 하시겠습니까? (yes/no) > ");
		String userInput = sc.next();
		
		System.out.println(str == "yes");
		System.out.println(userInput.equals("yes"));
		// 문자열은 비교할 때 .equals() 메서드를 사용해야 한다.
		// (모든 참조형 변수는 equals() 메서드를 통해 비교해야 한다)
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
