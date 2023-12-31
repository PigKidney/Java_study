package quiz;

import java.util.Scanner;

public class B12_UpdownGameT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int MAX_CHANCE = 5;
		int chance = MAX_CHANCE;
		int answer = (int)(Math.random()*100+1);
		boolean userWin = false;
		
		System.out.println("정답 (테스트용) : " + answer);
		
		while (chance > 0) {
			System.out.print("숫자를 고르세요 (1~100) : ");
			int select = sc.nextInt();
			
			if(select > 100 || select < 1) {
				System.out.println("숫자의 범위를 올바르게 입력해주세요.");
				continue;
			}
			
			--chance;
			if(select > answer) {
				System.out.println("Down!!");
			} else if(select < answer) {
				System.out.println("Up!!");
			} else {
				System.out.println("정답!!");
				userWin = true;
				break;
			}
			
			System.out.println("남은 기회 : "+ chance);
		}
		
		if(userWin) {
			System.out.printf("%d번 만에 맞추셨습니다!!\n",(MAX_CHANCE-chance));
		} else {
			System.out.printf("패배하셨습니다! 정답은 %d이였습니다.",answer);
		}
		
	}
}
