package quiz;

import java.util.Random;

public class B14_RandomScores {

	/*
	 * 1. 100개의 랜덤 점수를 생성한다.(0~20000)
	 * 
	 * 2. 해당 점수들을 한 줄에 5개씩 보기 좋게 출력한다
	 * 
	 * 3. 모든 점수들의 평균을 출력한다 (소수 셋째 자리에서 반올림)
	 * 
	 * 4. 가장 높은 점수와 가장 낮은 점수 찾아 그 점수가 몇 번째 사람인지를 출력한다.(중복인 경우 모두 출력한다)
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
//		Random ran = new Random();
//		double scores = (double)Math.random()*20000; 
//		Math.round(a)
		double scores[] = new double[100];
		double scoresSum = 0;
		int count = 0;
		for (int i = 0; i < scores.length; i++) {
//			scores[i] = (double) Math.random() * 20001;
			scores[i] = (double) Math.random() * 20001;
			System.out.printf("점수 : %.2f\t", scores[i]);
			++count;
			if (count % 5 == 0) {
				System.out.println();
			}
			scoresSum += scores[i];

//			for (int j = 0; j < 5; j++) {
//				scores[i] = Math.round(scores[i]*100)*0.01;
//				System.out.printf("점수 : %.2f\t",scores[i]);
//			}
//			System.out.println();	

		}
		double scoresAvg = scoresSum / scores.length;
		System.out.printf("평균점수 : %.2f\n", scoresAvg);

		double topScore = scores[0];
		int topScoreNum = 0;
		double lastScore = scores[0];
		int lastScoreNum = 0;

		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > topScore) {
				topScore = scores[i];
				topScoreNum = i + 1;
			} else if (scores[i] < lastScore) {
				lastScore = scores[i];
				lastScoreNum = i + 1;
			}
		}

		System.out.printf("가장 높은점수는 %d번째 %.2f이고 가장 낮은 점수는 %d번째 %.2f입니다.", 
				topScoreNum, topScore, lastScoreNum,lastScore);

	}

}
