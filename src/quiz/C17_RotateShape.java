package quiz;

import java.util.Scanner;

import myobj.tetris.Block;

public class C17_RotateShape {
	/*
	 * 
	 *  2차원 배열로 이루어진 어떤 모양이 있을 때
	 *  해당 모양을 오른쪽으로 90도 회전시키는 프로그램을 만들어보세요.
	 *  
	 *  테트리스
	 *  □ ■ ■ □     
	 *  □ □ ■ □  
	 *  □ □ ■ □
	 *  □ □ □ □
 	 * 
 	 * 
 	 *  □ □ □ □
	 *  □ □ □ ■ 
	 *  □ ■ ■ ■ 
	 *  □ □ □ □
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Block g1 = new Block();
		System.out.println("블록 랜덤 생성 : ");
		g1.getShape(g1.getRandom());
		System.out.println();
		System.out.println("생성 블록 회전 : ");
		g1.getSpin();
		
	}
}
