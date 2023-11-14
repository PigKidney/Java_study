package quiz;

public class B12_TempPassword {
	public static void main(String[] args) {
		/*
		 * 4자리 랜덤 알파벳 대문자로 구성된 비밀번호를 생성하여 출력하는 프로그램을 만들어보세요 
		 * 
		 */
		
		//26개
//		System.out.println((int)'A');
//		System.out.println((int)'Z');
		
		// 숫자의 개수 구하기 (최대 - 최소 + 1)
		String password = "";
		for(int i=0 ; i < 4; i++) {
			password += ((char)(Math.random()*26+65));
		}
		
		System.out.println("생성된 비밀번호 : "+password+"\n비밀번호를 만들어드리지만 진짜로 이걸? 쓴다고? 진짜?");
		
		
		
		
		
		
		
		
	}
}
