package quiz;

import java.util.Scanner;

public class B06_ForQuiz2_2 {
	public static void main(String[] args) {
		System.out.print("숫자를 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);
		int lastNum = sc.nextInt();
		
		boolean isMinus = lastNum <0;
		lastNum = Math.abs(lastNum);
		
		for(int i = 0 , cnt = 0 ; i <= lastNum; i++) {
			if(i%5 ==0 && i != 0) {
				if(isMinus) {
					System.out.printf("-%d ", i);
				} else {
					System.out.print(i + " ");
				}
				
				if (++cnt % 10 == 0) {
					System.out.println();
				}
			}
		}
		
		
		
	}
}
