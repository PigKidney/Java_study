package quiz;

public class B09_gugudan {
	/*
	 * 1. 구구단을 다음과 같이 가로로 출력해 보세요.
	 * 
	 * 2단 : 2x1=2 2x2=4 ... 3단 : ...
	 * 
	 * 
	 * 2. 구구단을 다음과 같이 세로로 출력해보세요.
	 * 
	 * 2단 3단 .... 2x1=2 3x1=3 2x2=4 3x2=6 ... ....
	 * 
	 */
	public static void main(String[] args) {
		// 1. 구구단을 다음과 같이 가로로 출력해 보세요.
		for (int line = 0; line < 8; ++line) {
			int step = line + 2;
			// 한 줄의 시작
			System.out.printf("%d단 : ", step);
			for (int mul = 1; mul <= 9; ++mul) {
				System.out.printf("%dx%d=%-2d ", step, mul, step * mul);
			}
			System.out.println();
		}
		// 2. 구구단을 다음과 같이 세로로 출력해보세요.
		for(int line = 0 ; line < 10 ; ++line) {
			int mul = line;
			for(int step = 2 ; step <= 9 ; ++step) {
				if(line == 0) {
					System.out.printf("%d단\t\t",step);
				} else {
					System.out.printf("%d x %d = %-2d\t", step, mul, step * mul);
				}
				
			}System.out.println();
		}
// -------------------------------------------------------------------------------------------------내가한거		
//		
////		1. 구구단을 다음과 같이 가로로 출력해 보세요.
//		for(int i=2; i<=9; i++) {
//			System.out.print(i+"단 : ");
//			for(int j=1; j<=9; j++) {
//				System.out.printf("%dx%d = %d \t",i,j,i*j);
//			} System.out.println();
//		}
//		System.out.println();
//		
//		
//		
////		2. 구구단을 다음과 같이 세로로 출력해보세요.
////		for(int i = 2 ; i <= 9 ; i++) {
////			System.out.printf("%d단\t\t",i);
////		}
////		
////		for (int i = 1; i <= 9; i++) {
////			for (int j = 2; j <= 9; j++) {
////				System.out.printf("%d x %d = %d \t", j, i, i * j);
////				if(j==9) {
////					System.out.println();
////				}
////			} 
////		}
//		for(int i=0; i<=9; i++) {
//			for(int j=2; j<=9; j++) {
//				if(i==0) {
//					System.out.printf("%d단\t\t",j);
//				} else {
//					System.out.printf("%d x %d = %d \t", j, i, i * j);
//				}
//				
////				System.out.printf("%dx%d = %d \n",i,j,i*j);
//			} System.out.println();
//		}

	}

}
