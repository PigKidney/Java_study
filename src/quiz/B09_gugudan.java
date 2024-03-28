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
		for(int line = 2;  line < 10; line++){
			System.out.print(line + "단 : ");
			for(int mul = 1; mul < 10; mul++){
				System.out.printf("%d x %d = %2d\t",line, mul, line*mul);
			}
			System.out.println();
		}

		for(int dan = 2; dan < 10 ; dan++){
			System.out.printf("%d단\t\t",dan);
		}
		System.out.println();
		for(int step = 1; step < 10 ; step++){
			for(int dan = 2; dan < 10 ; dan++){
				System.out.printf("%d x %d = %2d\t",dan,step,dan*step);
			}
			System.out.println();
		}

	}

}
