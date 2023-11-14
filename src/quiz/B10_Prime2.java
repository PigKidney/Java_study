package quiz;

import java.util.Scanner;

public class B10_Prime2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int inNum = 2;
//		int count = 0;

		while (inNum <= num) {
			boolean isPrime = true;
			int chk = 2;
			while (chk <= Math.sqrt(inNum)) {
				if (inNum % chk == 0) {
					isPrime = false;
					break;
				}
				++chk;
			}
			if (isPrime) {
				System.out.print(inNum + " ");
			}
			++inNum;
		}

	}
}
