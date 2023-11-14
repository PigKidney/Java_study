package quiz;

import java.util.Arrays;

public class C01_FunctionQuiz {
	public static void main(String[] args) {
		// boolean타입 함수는 만들어두면 조건 대신 사용할 수 있어 굉장히 유용하다.
		if (isAlphabet('a')) {
			System.out.println("알파벳이었습니다.");
		} else {
			System.out.println("알파벳이 아니였습니다.");
		}

		System.out.printf("10은 %s\n", chkEvenOdd(10));

		for (int num = 100; num <= 200; num++) {
			System.out.printf("%d의 약수들 : %s\n", num, Arrays.toString(getDivisor(num)));

		}
		multiPrint(" /)/)\n(  ..)\n(  >@)",3);
		
		System.out.println((int)'A'-'a');
		System.out.println((int)'a');

	}

	/*
	 * # 다음 함수를 정의하고 올바르게 동작하는지 테스트 해보세요
	 * 
	 * 1. 전달한 문자가 알파벳이면 true를 반환, 아니면 false를 반환하는 함수
	 * 
	 * 2. 전달한 숫자가 3의 배수이면 true를 반환, 아니면 false를 반환하는 함수
	 * 
	 * 3. 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수입니다"를 반환하는 함수
	 * 
	 * 4. 숫자를 전달하면 해당 숫자의 모든 약수를 int[]로 반환하는 함수
	 * 
	 * 5. 전달한 정수가 소수(prime)라면 true를 반환하고 아니면 false를 반환하는 함수
	 * 
	 * 6. 메세지와 횟수를 전달하면 해당 메세지를 전달한 횟수만큼 반복하는 함수
	 * 
	 * 
	 */
	/**
	 * chkAlp에 문자를 입력하면 알파벳인지 아닌지 확인해준다
	 * 
	 * @param chkAlp - 확인 원하는 문자를 입력
	 * @return 알파벳이면 - true 아니면 false 를 출력
	 */
	public static boolean isAlphabet(char chkAlp) {
		return chkAlp >= 'a' && chkAlp <= 'z' || chkAlp >= 'A' && chkAlp <= 'Z';

//		if (chkAlp >= 'a' && chkAlp <= 'z' || chkAlp >= 'A' && chkAlp <= 'Z') {
//			return true;
//		} else {
//			return false;
//		}

	}

	/**
	 * 입력한 숫자가 3의 배수인지 확인해준다
	 * 
	 * @param a
	 * @return 3의 배수면 true 아니라면 false를 출력
	 */
	public static boolean isMul3(int a) {
		return a % 3 == 0 && a != 0;

//		if (a % 3 == 0) {
//			return true;
//		} else {
//			return false;
//		}
	}

	/**
	 * 입력한 숫자가 짝수인지 홀수인지 알려준다
	 * 
	 * @param a
	 * @return 입력한 숫자가 짝수이면 "짝수입니다" 홀수라면 "홀수입니다"의 문자열을 출력함ㄴ다.
	 */
	public static String chkEvenOdd(int num) {
		return num % 2 == 0 ? "짝수입니다" : "홀수입니다";

//		if (num % 2 == 0) {
//			return "짝수입니다";
//		} else {
//			return "홀수입니다";
//		}
	}

	/**
	 * 숫자를 입력하면 그 숫자에 대한 소수값을 int[]값에 출력해준다
	 * 
	 * @param num
	 * @return int[소수의 갯수] = {소수들};
	 */
	public static int[] getDivisor(int num) {
		// 1부터 num까지 나누어 떨어지면 배열에 추가한다
		// 배열은 한번 만들면 크기 변경이 불가능하나다

		// 약수의 개수를 먼저 세서 배열의 크기를 정해야 한다
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		int[] divisor = new int[count];
		int index = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				divisor[index++] = i;
			}
//			for(int j=0; j<num ; j++) {
//				if(num % j == 0) {
//					divisor[i]=j;
//				}
//			}
		}
		return divisor;
	}

	/**
	 * 숫자를 입력하면 소수인지 아닌지 확인해준다
	 * 
	 * @param inPutNum
	 * @return 입력숫자가 prime값이면 true 아니라면 false를 출력
	 */
	public static boolean isPrime(int inPutNum) {
		for (int i = 2; i <= Math.sqrt(inPutNum); i++) {
			if (inPutNum % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 원하는 메세지랑 횟수를 입력하면 그 수치만큼 출력해준다
	 * 
	 * @param mes - 원하는 메세지
	 * @param a   - 원하는 횟수
	 */
	public static void multiPrint(String mes, int a) {

		for (int i = 0; i < a; i++) {
			System.out.printf("%s [%d time(s) repeat]\n",mes,i+1);
		}
	}

}