package quiz;

import java.util.Scanner;

public class B14_ShuffleText {
	public static void main(String[] args) {
		/*
		 * 
		 * 사용자로부터 문자열을 입력받으면 해당 단어를 랜덤으로 섞어주는 프로그램을 만들어보세요.
		 * 
		 * 123456789 -> 8531292... 바보멍청이 -> 이멍청바보 abcdefg -> fegcdab
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		String date = sc.nextLine();
		// 데이터를 입력받는다
		int len = date.length();
		int [] text = new int[len];
		// Array 생성 [사용자가 입력한 글자수 크기만큼] 
		//		=> date.charAt();를 사용해 몇번째 char값을 가져올지를 랜덤으로 돌리기위해서
		
		
		// text[i]의 값을 입력받은 데이터의 글자수에서 랜덤으로 넣고 이중for문에서 중복검사를 한다.
		// ex) text[0]=5 ,text[1] = 3 , text[2] =1 이런식으로 text값 순서대로 다른 숫자가 들어가게 된다!
		for(int i = 0 ; i < len ; i++) {
			text[i] = (int)(Math.random()*len);
			for(int j = 0 ; j < i ; j++) {
				if(text[i]==text[j]) {
					--i;
					break;
				}
			}
		}
		
		// 위에서 중복 검사를 마친 text[]는 모두 다른 i값을 가진 후 입력 받았던 date를
		//		랜덤으로 생성된 text[i]의 값으로 랜덤으로 출력된다.
		for(int i = 0 ; i < text.length; i++) {
			System.out.print(date.charAt(text[i]));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//		int len = date.length();
//		int [] reword = new int[len];
//		for (int i = 0; i < len; i++) {
//			reword[i] = (int)(Math.random()*len);
//			for(int j=0; j<i ; ++j) {
//				if(reword[i]==reword[j]) {
//					--i;
//					break;
//				}
//			}
//		}
//		for (int i = 0; i < reword.length; i++) {
//			System.out.print(date.charAt(reword[i]));
//		}
	}

}
