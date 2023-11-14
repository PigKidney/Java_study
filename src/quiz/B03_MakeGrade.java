package quiz;

import java.util.Scanner;

public class B03_MakeGrade {
	/*
	 *  국어 영어 수학 점수를 순서대로 입력받아 평균 점수를 구한 후에
	 *  각 과목의 점수와 등급 및 평균 점수를 출력해주는 프로그램을 만들어보세요.
	 *  
	 *  90점 이상은 A
	 *  80점 이상은 B
	 *  70점 이상은 C
	 *  60점 이상은 D
	 *  그 외 F
	 *  
	 *  각 과목의 유효 점수는 0 ~ 100점이다
	 *  유효하지 않은 점수가 하나라도 있다면 모든 과목이 F이고
	 *  평균 점수는 0점
	 *  
	 *  평균 점수는 소수 둘째 자리에서 반올림하여 변수에 저장한 후 출력
	 */
	public static void main(String[] args) {
		
		Scanner nc = new Scanner(System.in);
		System.out.println("당신의 국어 점수를 입력하세요");
		int korSc=nc.nextInt();
		System.out.println("당신의 수학 점수를 입력하세요");
		int mathSc=nc.nextInt();
		System.out.println("당신의 영어 점수를 입력하세요");
		int engSc=nc.nextInt();
		
		// Math.round(a)
		double totalSc = (double)Math.round((korSc+mathSc+engSc)/0.3)*0.1;
		
		if(korSc<=0 || korSc>100 || mathSc<=0 || mathSc>100 || engSc<=0 || engSc>100) {
			System.out.println("당신의 학점은 F입니다. 점수는 0점 입니다.");
		} else {
			
			if(korSc>=90) {
				System.out.println("당신의 국어 학점은 A 입니다.\n");
			}
			else if(korSc>=80 && korSc<90) {
				System.out.println("당신의 국어 학점은 B 입니다.\n");
			}
			else if(korSc>=70 && korSc<80) {
				System.out.println("당신의 국어 학점은 C 입니다.\n");
			}
			else if(korSc>=60 && korSc<70) {
				System.out.println("당신의 국어 학점은 D 입니다.\n");
			}
			else {
				System.out.println("당신의 국어 학점은 F 입니다.\n");
			}
			
			
			if(mathSc>=90) {
				System.out.println("당신의 수학 학점은 A 입니다.\n");
			}
			else if(mathSc>=80 && mathSc<90) {
				System.out.println("당신의 수학 학점은 B 입니다.\n");
			}
			else if(mathSc>=70 && mathSc<80) {
				System.out.println("당신의 수학 학점은 C 입니다.\n");
			}
			else if(mathSc>=60 && mathSc<70) {
				System.out.println("당신의 수학 학점은 D 입니다.\n");
			}
			else {
				System.out.println("당신의 수학 학점은 F 입니다.\n");
			}
			
			if(engSc>=90) {
				System.out.println("당신의 영어 학점은 A 입니다.\n");
			}
			else if(engSc>=80 && engSc<90) {
				System.out.println("당신의 영어 학점은 B 입니다.\n");
			}
			else if(engSc>=70 && engSc<80) {
				System.out.println("당신의 영어 학점은 C 입니다.\n");
			}
			else if(engSc>=60 && engSc<70) {
				System.out.println("당신의 영어 학점은 D 입니다.\n");
			}
			else {
				System.out.println("당신의 영어 학점은 F 입니다.\n");
			}
			System.out.printf("당신의 평균점수는 %.1f 입니다.",totalSc);
			
		}
			
		
//		System.out.printf("당신의 학점은 국어 : %c\n수학 : %c\n영어 : %c\n 이고 평균점수는 %.2f입니다.", 
//				kor_score , math_score, engS_score,totalSc);
//		
		
		
		
		
		
//		else if(totalSc>=90) {
//			System.out.printf("당신의 점수는 %.2f이고, A학점입니다.",totalSc);
//		}
//		else if(totalSc>=80) {
//			System.out.printf("당신의 점수는 %.2f이고, B학점입니다.",totalSc);
//		}
//		else if(totalSc>=70) {
//			System.out.printf("당신의 점수는 %.2f이고, C학점입니다.",totalSc);
//		}
//		else if(totalSc>=60) {
//			System.out.printf("당신의 점수는 %.2f이고, D학점입니다.",totalSc);
//		}
//		else {
//			System.out.printf("당신의 점수는 %.2f이고, F학점입니다.",totalSc);
//		}
		
	}
	
	
	
	
	
	
	
}

