package quiz;

import java.util.Scanner;

public class B06_CheckDigit {
	public static void main(String[] args) {
		/*
		  
		  사용자가 숫자를 입력하면 해당 숫자가 몇 자리 숫자인지
		  알려주는 프로그램을 만들어보세요
		  
		 */
		
		

		System.out.print("숫자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
//		String num = sc.nextLine();
//		System.out.println(num.length());
		
		//Math.pow(a,b)
		int uear_date = sc.nextInt();
		int cnt = 0;
		int abs = Math.abs(uear_date);
		for ( ; abs > 0 ; abs/=10) {
			++ cnt;
		}
		System.out.println(cnt);
			
			
			
				

	}
}
