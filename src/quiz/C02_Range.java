package quiz;

import java.util.Arrays;

public class C02_Range {
	/*
	 * 1. 정수값을 (인자)전달 받으면 0부터 해당 값 미만의 int[]을 생성하여 반환하는 range 함수를 만들어보세요
	 * 
	 * ex) range(8) 의 결과 -> [0, 1, 2, 3, 4, 5, 6, 7]
	 * 
	 * 2. 정수 최소값과 정수 최대값을 전달받으면 최소값부터 최대값 미만인 int[]을 생성하여 반환하는 range 함수를 만들어 보세요
	 * 
	 * ex) range(10, 15) -> [10, 11, 12, 13, 14] range(15, 10) -> [15, 14, 13, 12,
	 * 11]
	 * 
	 * 3. 최소값 최대값 증감값을 인자로 전달받으면 최소값부터 최대값 미만까지 증감값만큼 증가하는 int[]을 생성하여 반환하는 range
	 * 함수를 만들어 보세요
	 * 
	 * ex) range(10, 20, 2) -> [10, 12, 14, 16, 18] range(40, 30, -3) -> [40, 37,
	 * 34, 31] range(20, 10, 5) -> []
	 * 
	 */
	// int[값]을 받으면 크기만큼 생성해주는 메서드
	public static int[] range(int num) {
		int[] range = new int[num];
		for (int i = 0; i < range.length; i++) {
			range[i] = i;
		}
		return range;
	}

	// int[a,b]를 a->b 순서로 생성해주는 메서드
	public static int[] range(int start, int end) {
		int size = Math.abs(start-end);
		int[] arr = new int[size];
		int increment = start < end ? 1: -1;
		// 삼항연산자를 이용해 두 int값을 비교하여 값을 내릴지 올릴지 결정
		for(int i = 0 ; i < arr.length; i++) {
			arr[i]= start + (increment*i);
		}
		return arr;
	}
	
	public static int[] range(int start, int end, int increment) {
		int size = (int)Math.ceil((end - start) / (double)increment);
		// 위 계산에서 size가 -가 나온다면 방향이 잘못된 것이다.
		if(size <0) {
			return null;
		}
		int[] arr = new int[size];
		for(int i = 0 ; i < arr.length; i++) {
			arr[i]= start + (increment*i);
		}
		return arr;
	}
	
	
	
	
//	public static int[] range(int fstNum, int scdNum) {
//		int len = Math.abs(fstNum - scdNum);
//		int[] range = new int[len];
//
//		if (fstNum > scdNum) {
//			for (int i = fstNum, j = 0; i > scdNum; i--) {
//				range[j++] = i;
//			}
//
//		} else if (fstNum < scdNum) {
//			for (int i = fstNum, j = 0; i < scdNum; i++) {
//				range[j++] = i;
//			}
//		}
//		return range;
//	}

//	public static int[] range(int fstNum, int scdNum, int var) {
//
//		int len = Math.abs((fstNum - scdNum) / var) + 1;
//		if ((fstNum - scdNum) % var == 0) {
//			--len;
//		}
//		int[] range = new int[len];
//
//		if (fstNum < scdNum && var > 0) {
//			for (int i = fstNum, j = 0; i < scdNum; i += var) {
//				range[j++] = i;
//			}
//		} else if (fstNum > scdNum && var < 0) {
//			for (int i = fstNum, j = 0; i > scdNum; i += var) {
//				range[j++] = i;
//			}
//		} else {
//			return null;
//		}
//
//		return range;
//
//	}

	public static void main(String[] args) {
		System.out.println("1번 문제 : range(8) => " + Arrays.toString(range(8)) + "\n");
		System.out.println("2번 문제 : range(15, 10) => " + Arrays.toString(range(15, 10)) + "\n");
		System.out.println("2번 문제 : range(10, 15) => " + Arrays.toString(range(10, 15)) + "\n");
		System.out.println("3번 문제 : range(20, 10, 5) => " + Arrays.toString(range(20, 10, 5)) + "\n");
		System.out.println("3번 문제 : range(40, 30, -3) => " + Arrays.toString(range(40, 30, -3)) + "\n");
		System.out.println("3번 문제 : range(10, 20, 2) => " + Arrays.toString(range(10, 20, 2)) + "\n");
		
		// 해당 함수에서 null을 리턴할 가능성이 있는경우
		// null이 아닐때만 해당 값을 활용하도록 코드를 작성하는 것이 좋다.
		int[] result = range(10,80,-1);
		if(result != null) {
			System.out.println(Arrays.toString(result));
		} else {
			System.out.println("null이 나왔습니다");
		}
		
//		System.out.println(Arrays.toString(range(10, 30, 2)));
//		System.out.println(Arrays.toString(range(-10, 30, 2)));
//		System.out.println(Arrays.toString(range(10, -30, -2)));
	}

}
