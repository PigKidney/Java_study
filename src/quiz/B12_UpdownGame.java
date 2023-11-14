package quiz;

import java.util.Scanner;

public class B12_UpdownGame {
	/*
	 * 
	 * # Updown 게임 만들기
	 * 
	 * 1. 게임이 시작되면 1~100 사이의 랜덤 숫자를 정답으로 선택한다 (사용자에게는 비밀로 한다)
	 * 
	 * 2. 사용자가 숫자를 입력하면 UP인지 DOWN인지 정답인지 알려준다.
	 * 
	 * 3. 정답이 입력한 숫자보다 크다면 사용자에게 UP이라고 알려준다 정답이 입력한 숫자보다 작다면 사용자에게 DOWN이라고 알려준다 정답이
	 * 력한 숫자와 일치하면 정답이라고 알려준 후 플레이어가 승리한다.
	 * 
	 * 
	 * 4. 5번안에 못 맞추면 정답이 뭐였는지 알려주고 플레이어의 패배로 프로그램을 종료한다.
	 * 
	 * 5. 정답을 맞추면 몇 번만에 맞췄는지 알려주고 프로그램을 종료한다.
	 * 
	 * 
	 */
	public static void main(String[] args) {

		int randomNum = (int) (Math.random() * 100 + 1);
		Scanner sc = new Scanner(System.in);
		System.out.println(randomNum );
		System.out.print("숫자를입력하세요 : ");
		int count = 0;
		boolean userWin = false;
		int MAX_CHANCE = 5;
		
		for(int chance = 0 ; chance < MAX_CHANCE ; chance++) {
			int select = sc.nextInt();
			if(chance<0 || chance >100) {
				System.out.print("범위 외 숫자를 입력하셨습니다. 다시 입력바랍니다 : ");
				--chance;
				continue;
			}
			++count;
			if(select==randomNum) {
				userWin = true;
				break;
			} else if(select>randomNum) {
				System.out.print("당신이 입력한 숫자보다 Down\n숫자를 다시 입력해주세요 : ");
			} else if(select<randomNum) {
				System.out.print("당신이 입력한 숫자보다 Up\n숫자를 다시 입력해주세요 : ");
			} 
			
			if(userWin) {
				System.out.printf("%d번만에 %d을 맞추셨습니다!",count,randomNum);
			} else if(count==MAX_CHANCE){
				System.out.printf("기회 %d를 모두 사용하셨지만 %d를 맞추지 못하셨습니다.",count,randomNum);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		boolean userWin = false;
//		int count = 1;
//		System.out.println(randomNum);
//		System.out.print("숫자를 입력해주세요 : ");
//		for (int chance = 0; chance < 5; chance++) {
//			int answer = sc.nextInt();
//
//			if (answer < 0 || answer > 100) {
//				System.out.print("올바른 숫자를 입력해 주세요.");
//				--chance;
//				continue;
//			}
//
//			if (answer > randomNum) {
//				System.out.println("Down");
//			} else if (randomNum > answer) {
//				System.out.println("Up");
//			} else {
//				userWin = true;
//				break;
//			}
//			++count;
//
//		}
//		if (userWin) {
//			System.out.printf("%d번 만에 정답을 맞추셨습니다.", count);
//		} else {
//			System.out.printf("고생하셨습니다. 정답은 %d입니다.", randomNum);
//		}

// ------------------------------------------------------------------------------------------------------------		

//		for (int select = 0; select < 10; select++) {
//			int ans1 = new Scanner(System.in).nextInt();
//			
//			if (count == 4) {
//				System.out.printf("정답은 %d였습니다 고생하셨습니다.", ANSWER);
//				break;
//			}
//			if (ans1 == ANSWER) {
//				++count;
//				System.out.printf("딩동댕~ %d번만에 정답(%d)을 맞추셨습니다.", count, ANSWER);
//			} else if (ans1 > ANSWER && ans1 <= 100) {
//				++count;
//				System.out.print("당신이 입력한 숫자보다 Down\n다시입력해주세요 : ");
//			} else if (ans1 < ANSWER && ans1 >= 1) {
//				++count;
//				System.out.print("당신이 입력한 숫자보다 UP\n다시입력해주세요 : ");
//			} else {
//				System.out.print("정확한 숫자를 입력해주세요\n");
//			}
//			System.out.print("당신이 입력한 숫자보다 UP");
//			System.out.print("당신이 입력한 숫자보다 Down");
//			System.out.printf("%d회수만에 맞추셨습니다.",count);
//		}

	}
}
