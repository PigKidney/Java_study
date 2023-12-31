package myobj.lotto;

import java.util.Arrays;

public class LottoNumber {
	
	// 해당 메서드에서 this를 사용할 예정이라면 static을 사용하지 않는다
	
	// 당첨 번호는 7개, 뽑는 번호는 6개
	int[] numbers;
	
	// 내가 고른 int[]을 전달하면 인스턴스가 생성됨
	public LottoNumber(int[] numbers) {
		this.numbers = numbers;
	}
	
	
	// 로또번호 출력을 한번에 (추첨번호 7개 내번호 6개 나누기)
	public LottoNumber(boolean winNum) {
		if(winNum) {
			numbers = new int[7];
		} else {
			numbers = new int[6];
		}
		
		generate();
	}
	
	//받은 번호 프린트 해주는 메서드
	public void print() {
		System.out.println(Arrays.toString(numbers));
	}

	// 현재 인스턴스의 numbers 배열을 중복없는 랜덤 숫자로 가득 채움
	public void generate() {
		int len = numbers.length;
		for(int i = 0 ; i < len; i++) {
			numbers[i]=getRandomNumber();
			for(int j=0 ; j<i ; j++) {
				if(numbers[i]==numbers[j]) {
					--i;
					break;
				}
			}
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				int temp = 0;
				if (numbers[i] < numbers[j]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}

	//랜덤번호 받기
	int getRandomNumber() {
		return (int)(Math.random()*45+1);
	}

	// 당첨번호 인스턴스를 전달 받으면 등수 값을 리턴하는 메서드
	public int check(LottoNumber winNum) {
		int winLen = winNum.numbers.length;
		int guessLen = this.numbers.length;
		
		int winCount = 0;
		boolean hasBonus = false;
				
		if(winLen !=7) {
			return -1;
		}
		
		for(int i = 0 ; i<guessLen ; ++i) {
			for(int j = 0 ; j < winLen; ++j) {
				if(this.numbers[i] == winNum.numbers[j]) {
					++winCount;
					
					// 당첨 번호의 마지막 번호와 일치한다면 bonus번호를 맞춘 것
					if(!hasBonus && j==winLen -1) {
						hasBonus = true;
					}
					break;
				}
			}
		}

		if(winCount == 6) {
			if(hasBonus) {
				return 2;//2등
			} else {
				return 1;//1등
			}
		} 
		// 보너스 번호를 가지고 있다면 맞춘 번호를 1 뺀다
		winCount = hasBonus ? winCount -1 : winCount;
		
		if(winCount == 5) {
			return 3; //3등
		} else if(winCount ==4) {
			return 4; //4등
		} else if(winCount == 3) {
			return 5; //5등
		} else {
			return 0; //낙첨
		}
	}



}
