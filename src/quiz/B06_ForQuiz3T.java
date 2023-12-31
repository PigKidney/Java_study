package quiz;

public class B06_ForQuiz3T {
	public static void main(String[] args) {
		// 1. 0 3 6 9 12 ... 93 96 99
		for (int i = 0; i <= 99; i += 3) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 2. -35 -28 -21 .... 0 7 14 ... 35
		for (int i = -35; i <= 35; i += 7) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 3. 100 200 300 .... 1000
		for (int i = 100; i <= 1000; i += 100) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 4. 100 99 98 ....5 4 3 2 1 0
		for (int i = 100; i >= 0; --i) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 5. 0 1 2 3 4 .... 6 7 8 9 0 1 2 3 .... 7 8 9 ...(30번)
		for (int i = 0; i < 300; i++) {
			System.out.print(i % 10 + " ");
		}
		System.out.println();

		// 6. 10 9 8 7 .... 3 2 1 10 9 8 ... 3 2 1 10 9 ... (30번)
		for (int i = 0; i < 300; i++) {
			System.out.print(10-(i % 10) + " ");
		}
		System.out.println();

		// 7. 7 77 777 7777 7777 .... 7777777777
		long num = 7;
		for (int i = 0 ; i < 10; i++) {
			System.out.print(num+" ");
			num = (num*10)+7;
		}
		System.out.println();

	}
}
