package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class E01_CorrectInput {
	/*
	 	사용자로부터 스캐너로 숫자를 입력반되
	 	숫자가 아닌 문자를 입력하더라도 다시 입력받을 수 있는 프로그램을 만들어보세요
	 	
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		while(true) {
			System.out.println("숫자를 입력하세요 > ");
			try {
				sc.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.println(sc.next()+"는 숫자가 아닙니다 다시 입력바랍니다."); //버퍼클리어
				continue;
			}
		}
		System.out.println("숫자 입력확인");
	}
}
