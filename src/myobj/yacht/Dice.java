package myobj.yacht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Dice extends Player{

	public Dice(String name) {
		super(name);
	}

	Scanner sc = new Scanner(System.in);
	boolean debugMode = true;
	final int MAX_DROP = 5;
	Player[] player = { new Player("홍길동"),new Player("김신")};
//	ArrayList<Integer> numList = new ArrayList<>();
//	HashSet<Integer> numSet = new HashSet<>();

	public ArrayList<Integer> dropDice() {
		while (numList.size() < MAX_DROP) {
			int ranNum = (int) ((Math.random() * 6) + 1);
			numList.add(ranNum);
		}
		return numList;
	}

	public ArrayList<Integer> debugDropDice() {
		System.out.println("확인하실 숫자를 입력해주세요 > ");
		while (numList.size() < MAX_DROP) {
			numList.add(sc.nextInt());
		}
		return numList;
	}

	public void chkNum(ArrayList<Integer> nums) {
		numSet.addAll(nums);
		for (int i = 1; i <= 6; i++) {
			int count = Collections.frequency(numList, i);
			if (count == 5 && numSet.size() == 1) {
				System.out.println("Yacht");
				pickWhoWin(nums,1);
				break;
			} else if (count == 4 && numSet.size() == 2) {
				System.out.println("Four");
				pickWhoWin(nums,5);
				break;
			} else if (count == 3 && numSet.size() == 3) {
				System.out.println("Three");
				pickWhoWin(nums,6);
				break;
			} else if (count == 3 && numSet.size() == 2) {
				System.out.println("Full");
				pickWhoWin(nums,4);
				break;
			}
		}

		if (numSet.size() == 5 && numSet.contains(2) && numSet.contains(3) && numSet.contains(4)
				&& numSet.contains(5)) {
			System.out.println("Large");
			pickWhoWin(nums,2);
		} else if (numSet.size() >= 4 && numSet.contains(3) && numSet.contains(4)) {
			if (numSet.contains(1) && numSet.contains(2) || numSet.contains(2) && numSet.contains(5)
					|| numSet.contains(5) && numSet.contains(6)) {
				System.out.println("small");
				pickWhoWin(nums,3);
			}
		}

	}

	public int pickWhoWin(ArrayList<Integer> nums,int rank) {
		Collections.fill(nums, 0);
		if(rank == 1) {
			nums.add(6);
		} else if(rank == 2) {
			nums.add(5);
		} else if(rank == 3) {
			nums.add(4);
		} else if(rank == 4) {
			nums.add(3);
		} else if(rank == 5) {
			nums.add(2);
		} else if(rank == 6) {
			nums.add(1);
		} 
		return 0;
	}
	
	public void play() {
		if (debugMode) {
			debugDropDice();
			System.out.println(numList);
			chkNum(numList);
		} else {
			for(Player turn : player) {
				dropDice();
				System.out.println(numList);
				chkNum(numList);
			}
		}
//		player[0].numList
	}

}
