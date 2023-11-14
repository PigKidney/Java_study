package myobj.tongGame;

import java.util.Scanner;

public class TongGameT {
	int stabCount = 0;
	int[] answerArr;

	public TongGameT() {
		answerArr = makeAnswerArr(20);
	}

	public TongGameT(int size) {
		answerArr = makeAnswerArr(size);
	}

	/**
	 * 정답 배열을 만들어서 리턴해주는 메서드. 정답의 개수는 size의 1/5개로 설정됨. 0은 그냥 구멍, 1은 폭탄, 2는 이미 찔렀던
	 * 구멍.
	 * 
	 * @param size - 전체 구멍의 개수
	 * @return 생성된 정답 배열
	 */
	public int[] makeAnswerArr(int size) {
		int[] arr = new int[size];

		int answerCount = size / 5;

		for (int i = 0; i < answerCount; ++i) {
			arr[i] = 1;
		}

		return shuffle(arr);
	}

	// 전달한 배열의 내용물을 스까주는 기능
	public int[] shuffle(int[] arr) {
		for (int i = 0; i < 100; ++i) {
			int ran = (int) (Math.random() * (arr.length - 1)) + 1;
			int temp = arr[0];
			arr[0] = arr[ran];
			arr[ran] = temp;
		} 
		return arr;
	}

	public void print() {
		for (int i = 0; i < answerArr.length; ++i) {

			switch(answerArr[i]){
			case 2:
				System.out.printf("%-2d : [X] ", i + 1);
				break;
			default :
				System.out.printf("%-2d : [ ] ", i + 1);
				break;
			}


			if (i % 5 == 4) {
				System.out.println();
			}
		}
		System.out.println("시도 횟수 : " + stabCount);
	}

	// 찌른 후 찔렀던 곳에 있던 숫자를 반환한다 (잘못찌른경우 -1)
	public int stab(int num) {
		int index = num - 1;

		if(index < 0 || index >= answerArr.length) {
			return -1;
		}
		int answer = answerArr[index];

		if(answer==0) {
			answerArr[index] = 2;			
		}
		return answer;
		

	}
	
	public void play() {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			this.print();
			System.out.print("찌를 곳을 선택해주세요 > ");
			int result = this.stab(sc.nextInt());
			
			if(result == 0) {
				System.out.println("살아남았습니다..");
				++stabCount;
			} else if (result == 1) {
				System.out.println("통아저씨가 갑자기 하늘로 날아갔습니다!!!!!!");
				System.out.println(++stabCount + "번만에 아저씨를 날려보냈습니다");
				break;
			} else if (result == 2) {
				System.out.println("찌른 곳은 다시 찌를 수 없습니다.");
			} else if (result == -1) {
				System.out.println("올바른 곳을 골라주세요");
			}
		}
	}

}
