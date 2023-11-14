package myobj;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
	int[] set_num;
	/**
	 * 1~9사이의 자리수로 야구공을 생성
	 * @param num
	 * @return
	 */
	public int[] pitch(int num) {
		this.set_num = new int[num];
		if(num>9 || num<0) {
			System.out.println("잘못된 수치를 입력하셨습니다.");
		}
		for (int i = 0; i < set_num.length; i++) {
			set_num[i] = (int) (Math.random() * 10);
			for (int j = 0; j < i; j++) {
				if (set_num[i] == set_num[j]) {
					--i;
				}
			}
		}
		return set_num;
	}
	/**
	 * 사용자가 생성된 자리수의 숫자를 입력하면 그 숫자로 이용해 방망이 생성
	 * @param num
	 * @return
	 */
	public int[] hit(int num) {
		int[] chk_num = new int[set_num.length];
		for (int i = chk_num.length - 1; i >= 0; i--) {
			chk_num[i] = num % 10;
			num /= 10;
		}
		return chk_num;
	}
	/**
	 * 방망이로 야구공을 쳐보고 제대로 맞았는지 피드백 해주는 감독님
	 * @param bat
	 * @return
	 */
	public boolean is_strike(int[] bat) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < set_num.length; i++) {
			for (int j = 0; j < bat.length; j++) {
				if (set_num[i] == bat[j] && i == j) {
					++strike;
				} else if (set_num[i] == bat[j]) {
					++ball;
				}

			}
		}
		if(strike==set_num.length) {
			return true;
		} else {
			System.out.printf("strike : %d \nball : %d\n", strike, ball);
			return false;			
		}
	}
	/**
	 * 잠실야구장
	 */
	public void play() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[1~9]사이의 원하시는 자리수를 입력하세요");
		pitch(sc.nextInt());
		System.out.println("디버깅용 정답표시"+Arrays.toString(set_num)); // 디버깅용 정답표시
		System.out.println("내보낼 타자의 수를 입력하세요");
		int chance = sc.nextInt();
		while (chance > 0) {
			System.out.printf("%d자리의 숫자를 입력하세요", set_num.length);
			int[] hitter = hit(sc.nextInt());
			System.out.println(Arrays.toString(hitter));
			if(is_strike(hitter)==true) {
				System.out.println("축하합니다 정답입니다");
				break;
			}
			--chance;
			System.out.printf("남은 기회 [%d]\n\n", chance);
		}
		if(chance == 0) {
			System.out.println("게임에서 패배하셨습니다.");				
		}
	
	}
}
