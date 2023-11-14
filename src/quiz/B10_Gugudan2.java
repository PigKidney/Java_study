package quiz;

public class B10_Gugudan2 {
	// for문으로 출력했던 구구단 2개를 while문으로 출력해보세요.
	public static void main(String[] args) {
		int dan = 2;
		int mul = 1;

//		while (dan < 10) {
//			System.out.printf("%d단 : ",dan);
//			mul = 1;
//			while(mul<=9) {
//				System.out.printf("%d x %d = %-2d \t", dan, mul, dan * mul);
//				++ mul;
//			}
//			System.out.println();
//			++dan;
//		}

//		while (dan < 10) {
//			System.out.printf("%d단\t\t", dan);
//			++dan;
//		}
//		dan = 2;
//		System.out.println();
//		while (mul <=9) {
//			dan = 2;
//			while (dan <= 9) {
//				System.out.printf("%d x %d = %-2d \t", dan, mul, dan * mul);
//				++dan;
//			}
//			System.out.println();
//			++mul;
//		}
		int gop2 = 1;
		
		while(gop2 <=9) {
			int dan2 = 2;
			
			while (dan2 <= 9 ) {
				System.out.printf("%d x %d = %-2d \t", dan2, gop2, dan2 * gop2);
				++dan2;
			}
			System.out.println();
			++gop2;
		}
		
	}
}
