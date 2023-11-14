package quiz;

import java.util.Scanner;

public class B07_IncludeUppercase {
	public static void main(String[] args) {
		
		
		//사용자가 단어를 입력했을 때 해당 단어에 대문자가 포함되어 있는지 여부
		System.out.print("단어를 입력 >  ");
		String word = new Scanner(System.in).nextLine();
		
		boolean isUpper = false;
		int uppercount = 0;
		for(int i=0 ; i<word.length(); i++) {
			char ch = word.charAt(i);
			if(ch >= 'A' && ch <= 'Z') {
				isUpper = true;
			} 
		}
		
		
		if(isUpper) {
			System.out.println("단어에 대문자가 포함되어 있습니다.");
		} else {
			System.out.println("단어에 대문자가 포함되어 있지 않습니다.");
		}

		
		
		
		
	}
}
