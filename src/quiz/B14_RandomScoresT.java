package quiz;

public class B14_RandomScoresT {
	public static void main(String[] args) {
		// 300개의 정수를 담을 수 있는 배열을 생성한다.
		int[] scores = new int[300];

		// 0~299번 방까지 숫자를 랜덤으로 채운다.
		for (int i = 0; i < scores.length; i++) {
			scores[i] = (int) (Math.random() * 20001);

		}
		// 출력하면서 총합 구하기
		int sum = 0;

		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
			// 콘솔에 출력하기(5개마다 줄바꿈)
			System.out.print(scores[i] + "\t");
			if (i % 5 == 4) {
				System.out.println();
			}
		}
		System.out.println("----------------------------------------");
		System.out.println("총합: " + sum);
		System.out.printf("평균: %.2f점\n", sum / (double) scores.length);

		// 제일 높은 점수와 제일 낮은 점수를 구한다.
		// -> 첫 번째 점수로 초기화 해놓고 두 번째 점수부터 하나씩 비교한다.
		int bestScore = scores[0];
		int worstScore = scores[0];
		
		for (int i = 1; i < scores.length; i++) {
			if(scores[i]>bestScore) {
				bestScore = scores[i];
				//현재 최고 점수보다 i번째 점수가 더 크다면 그 점수를 최고 점수로 바꾼다.
			}
			
			if(scores[i]<worstScore) {
				worstScore = scores[i];
				//현재 최저 점수보다 i번째 점수가 더 작다면 그 점수를 최저 점수로 바꾼다.
			}
		}
		
		System.out.println("최고 점수 : "+bestScore);
		//최고 점수인 사람들을 모두 출력한다
		for(int i = 0; i<scores.length;i++) {
			int score = scores[i];
			if(score == bestScore) {
				System.out.printf("%d번째 참가자[%d점]\n",i,score);
			}
		}
		System.out.println("최저 점수 : "+worstScore);
		//최저 점수인 사람들을 모두 출력한다
		for(int i = 0; i<scores.length;i++) {
			int score = scores[i];
			if(score == worstScore) {
				System.out.printf("%d번째 참가자[%d점]\n",i,score);
			}
		}
	}
}
