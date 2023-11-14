package quiz;

public class B06_ForQuizT {
	public static void main(String[] args) {
		int num;
		// A between B : A와 B를 모두 포함한다.
		for (num= 1000; num <=2000 ; num++) {
			// 8의 배수만 출력문을 만날 수 있다.(num의 시작점이 어디든)
			
			if(num % 8 == 0) {
				System.out.println(num);
			}
		}
		System.out.println("반복문이 끝난 후의 num 값" + num);
		int total = 0;
		for (num = 100; num<=300; ++num) {
			total += num;
		}
		System.out.println("다 더해진 결과 : "+ total);
		int count = 0;
		for(num=1000; num<=2000; ++num) {
			if(num%10 == 0) {
			System.out.print(num+" ");
			// 숫자를 출력하는 횟수를 세서 5의 배수라면 줄바꿈을 출력  count -> 숫자를 출력하고 1증가(숫자를 출력한 횟수)
			if(++count %5 == 0) {
				System.out.println();
			}
			}
		}
	}
}
