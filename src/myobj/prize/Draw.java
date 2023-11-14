package myobj.prize;

import java.util.Arrays;
import java.util.Scanner;

public class Draw extends Prize {

	// 등수별로 나올 수 있는 확률이 다르고 소진된 상품은 더이상 나오지 않는다
	// 확률 {1,3,5,10,15,30...}
	int [] setProb;
	
	public int[] setProb() {
		setProb = new int [totalPrize];
		for(int i = 0 ; i < totalPrize ; i++) {
			setProb[i]=1;
		}
		return setProb;
	}

	public void released() {
		int drow = (int)((Math.random()*totalPrize)+1);
		if(setProb[drow]==1) {
			setProb[drow]-=1;
		} 
		
	}

	public void play() {
		prize();
		info();
		System.out.println();
		System.out.println(Arrays.toString(setProb));
		while (true) {
			System.out.println("\n1) 뽑기 \n2) 뽑기정보\n3) 종료");
			Scanner sc = new Scanner(System.in);
			int selet = sc.nextInt();
			if (selet == 1) {
				released();
			
			} else if (selet == 2) {
				info();
			} else if (selet == 3) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

}
