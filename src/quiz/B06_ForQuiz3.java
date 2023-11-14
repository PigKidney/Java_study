package quiz;

public class B06_ForQuiz3 {
	public static void main(String[] args) {
		/*
		 * for 문을 사용해 숫자를 다음과 같이 출력해보세요
		 * 
		 * 1. 0 3 6 9 12 ... 93 96 99
		 * 
		 * 2. -35 -28 -21 .... 0 7 14 ... 35
		 * 
		 * 3. 100 200 300 .... 1000
		 * 
		 * 4. 100 99 98 ....5 4 3 2 1 0
		 * 
		 * 5. 0 1 2 3 4 .... 6 7 8 9 0 1 2 3 .... 7 8 9 ...(30번)
		 * 
		 * 6. 10 9 8 7 .... 3 2 1 10 9 8 ... 3 2 1 10 9 ... (30번)
		 * 
		 * 7. 7 77 777 7777 7777 .... 7777777777
		 * 
		 * 
		 * 
		 */
		int i;

		for (i = 0; i <= 100; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}

		}
		System.out.println();

		for (i = -35; i <= 35; i += 7) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (i = 100; i <= 1000; i += 100) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (i = 100; i >= 0; i--) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (i = 0; i < 30; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(j + " ");
			}
		}
		System.out.println();

		for (i = 0; i < 30; i++) {
			for (int j = 10; j > 0; j--) {
				System.out.print(j + " ");
			}
		}
		System.out.println();

		for (i = 0; i < 10; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("7");
			}
			System.out.print(" ");
		}
		
		System.out.println();
		
		int num = 10;
		int num1 = 10;
		for (i = 0; i < 10000 ; i++) {
			if(((num)-1)/9 == 1) {
				System.out.println(7*i);
				num1 = num1*num;	
			}
			
			System.out.print(" ");
		}
		
		
	}
}
