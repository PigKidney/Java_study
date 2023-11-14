package quiz;

import java.util.Scanner;

public class B06_ForQuiz2T {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력 > ");
		int lastNum=sc.nextInt();
		
		// 입력값이 양수일때
		if(lastNum >=0) {
			for (int i=0, cnt = 0 ; i<= lastNum; ++i) {
				if(i%5 == 0 && i != 0) {
					System.out.print(i + "\t");
					if (++cnt %10 == 0) {
						System.out.println();
					}
				}
			
			}
		} else { //입력값이 음수일때
			for (int i=0, cnt = 0 ; i>= lastNum; --i) {
				if(i%5 == 0 && i != 0) {
					System.out.print(i + "\t");
					if (++cnt %10 == 0) {
						System.out.println();
					}
				}
			
			}
		}
		
	}
}
