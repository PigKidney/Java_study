package quiz;

import java.util.Scanner;

public class B00_AgeCalculator {

	/*
	  
	  사용자가 태어난 해를 입력하면 그 사람의 한국 나이를 알려주는 프로그램을 만들어보세요. 	 
	  
    */
	public static void main(String[] agrs) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신이 태어난 해를 입력하시오 : ");
		
		
		int birthYear = sc.nextInt();
		int thisYear = 2023;
		int age = thisYear - birthYear;
		
		System.out.printf("당신의 나이는 %d살 입니다.\n",age);
		
		
		
//		int year = sc.nextInt();
//		int korage = (2023-year)+1;
//		
//		System.out.println("당신의 한국식 나이는 : "+korage);
//		
		
		
	}
}
