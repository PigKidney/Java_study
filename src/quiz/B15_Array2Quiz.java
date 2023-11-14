package quiz;

public class B15_Array2Quiz {
	public static void main(String[] args) {

		int[][] myArr = { { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1 } };

		// 1. myArr의 모든 값을 1~500 사이의 랜덤 값으로 바꾸기

		// 2. 랜덤으로 바뀐 모든 값의 총합과 평균을 구하기

		// 3. myArr의 각 행(row)의 합을 구해서 출력하기

		// 4. myArr의 각 열(column)의 합을 구해서 출력하기
		int sum = 0;
		int len = myArr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				myArr[i][j] = (int) (Math.random() * 500 + 1);
				sum += myArr[i][j];
				System.out.printf("myArr[%d][%d]: %d\n", i, j, myArr[i][j]);
			}
			System.out.println("---------------------------");

		}
		double avg = sum / len;
		System.out.println("총합 : " + sum + "평균 : " + avg);

		int rowSum = 0;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				rowSum += myArr[i][j];
			}
			System.out.printf("myArr[%d]의 합 : [%d]\n", i, rowSum);
			rowSum = 0;

		}

		int columnSum = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				columnSum += myArr[i][j];
				if(j==myArr[j].length-1) {
					++i;	
					break;
				}
			}
			System.out.println(columnSum);
			columnSum = 0;

		}

	}
}
