package quiz;

import java.util.ArrayList;

public class D01_ArrayListPractice {
	/*
	 * 1. 리스트에 1000~ 2000 사이의 랜덤 정수를 100개 추가하기
	 * 
	 * 2. 원본에서 짝수를 모두 제거한 후 총합을 구하기
	 * 
	 * 3. 원본에서 홀수를 모두 제거한 후 총합을 구하기
	 * 
	 */
	public static void main(String[] args) {
		// 제네릭에는 일반형 변수 타입을 사용할 수 없다
		
		
		ArrayList<Integer> numbers = new ArrayList<>();

		int evenSum = 0;
		int oddSum = 0;
		
		// 랜덤 정수 100개 추가
		for (int i = 0; i < 100; i++) {
			numbers.add((int) (Math.random() * 1001) + 1000);
		}
		System.out.println("랜덤 숫자 : "+numbers.size());
		System.out.println(numbers);

		for (int i = 0; i < numbers.size(); i++) {
			int num = numbers.get(i);
			if (num  % 2 == 0) {
				evenSum += numbers.remove(i--);
			}
		}
		System.out.println("짝수가 제거된 후의 numbers >> ");
		System.out.println(numbers);
		System.out.println("제거한 짝수의 합 : "+evenSum);
		
		for (int i = 0; i < numbers.size(); i++) {
			int num = numbers.get(i);
			if (num  % 2 == 1) {
				oddSum += numbers.remove(i--);
			}
		}
		System.out.println("홀수가 제거된 후의 numbers >> ");
		System.out.println(numbers);
		System.out.println("제거한 홀수의 합 : "+oddSum);

//		ArrayList<Integer> evenNumbers = new ArrayList<>();
//		ArrayList<Integer> oddNumbers = new ArrayList<>();
//		for (int i = 0; i < numbers.size(); i++) {
//			if (numbers.get(i) % 2 == 0) {
//				evenNumbers.add(numbers.get(i));
//			} else {
//				oddNumbers.add(numbers.get(i));
//			}
//		}
//		numbers.removeAll(evenNumbers);
//		numbers.removeAll(oddNumbers);
//		
//		for (int e = 0; e < evenNumbers.size(); e++) {
//			evenSum += evenNumbers.get(e);
//		}
//		
//		for (int o = 0; o < oddNumbers.size(); o++) {
//			oddSum += oddNumbers.get(o);
//		}

//		System.out.println("짝수 개수 : "+evenNumbers.size());


//		System.out.println("홀수 개수 : "+oddNumbers.size());
//		System.out.println(oddNumbers);
//		System.out.println(oddSum);

//		System.out.println(numbers.size());
//		System.out.println(numbers);

//		

//
//		for (int i = 0; i < numbers.size(); i++) {
//			oddNumbers.add(numbers.get(i));
//			numbers.remove(i);
//
//		}
//

//
//

	}
}

//		for (int i = 0; i < 100; i++) {
//			int num = numbers.get(i);
//			oddNumbers += num;
//		}
//		

//		int evenNumbers = 0;
//		int oddNumbers = 0;
//		for (int i = 0; i < 100; i++) {
//			int num = numbers.get(i);
//			if (num % 2 == 0) {
//				evenNumbers += num;
//			} else {
//				oddNumbers += num;
//			}
//		}