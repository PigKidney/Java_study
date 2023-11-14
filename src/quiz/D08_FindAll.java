package quiz;

public class D08_FindAll {
	
	public static void search(String text, char ch) {
		int foundIndex = -1;
		int i = 0;
		while ((foundIndex= text.indexOf(ch, foundIndex +1)) != -1) {
			System.out.printf("%d번째 %c의 위치 : %d\n", i++ , ch, foundIndex);
		}
		
		
		
//		int temp = 0; // 위치
//		int num3 = 0;
//		int temp1 = 0;
//		int num6 = 0;
//		while(str.length()>temp-1) { // 문자열 사라질때까지
//			if(str.indexOf(ch)!=-1) { // ch를 찾았을경우
//				int num1 = str.length(); 
//				str = str.substring(str.indexOf(ch)+1);
//				int num2 = str.length();
//				num3 = num1 - num2;
//				temp += num3; //위치 찾아서 더하기 
//				System.out.println(temp-1);
//			} else {
//				int num4 = str.length(); 
//				str = str.substring(str.indexOf(ch)+1);
//				int num5 = str.length();
//				num6 = num4 - num5;
//				temp1 += num6;
//				temp1--;
//				if(temp1==str.length()) {
//					break;
//				}
//			}
//			
//		}
		
	}
	
	public static void main(String[] args) {
		
		// 문자열과 찾을 문자를 전달하면 해당 문자의 모든 위치를 출력해주는 메서드를 만들어보세요
		// 메서드를 만들어보세요 (indexOf를 사용)
		
		String text = "apple/banana/orange/podo/gyul/pineapple/watermelon";
		           //  0123456789  
		
		String text1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		
//		search(text,'a');
		search(text1,'a');
		System.out.println(text1.length());
		
		
		
		
		
		
		
		
		
	}
}
