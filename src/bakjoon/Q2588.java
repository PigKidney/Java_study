package bakjoon;
import java.util.Scanner;


public class Q2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int a = sc.nextInt();
		String strB = sc.next();
		
		for(int i = 0 ; i < strB.length(); i++) {
			char ch = strB.charAt(strB.length()-i-1);
			System.out.println(a*(ch-'0'));
		}
		System.out.println(a*Integer.parseInt(strB));
		// -> 글자를 int형으로 바꿔준다~!ㅏㅓㅏㅣㅓ니ㅏ머이ㅏㅗㅓㅃㅁ쪄뙴짜
		
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		
//		
//		
//		System.out.println(a*(b%10));
//		System.out.println(a*(b%100/10));
//		System.out.println(a*(b/100));
//		System.out.println(a*b);
		
		
		
	}
}
