package quiz;

public class A06_Star {
	public static void main(String[] args) {
		
		String star =  "＊＊＊＊＊＊＊＊＊";
		String star1 = "　＊＊＊＊＊＊＊　";
		String star2 = "　　＊＊＊＊＊　　";
		String star3 = "　　　＊＊＊　　　";
		String star4 = "　　　　＊　　　　";

		
		System.out.printf("%s\n",star);
		System.out.printf("%s\n",star1);
		System.out.printf("%s\n",star2);
		System.out.printf("%s\n",star3);
		System.out.printf("%s\n",star4);
		
		String star5 =  "＊";
		
		System.out.printf("%s\n","＊＊＊＊＊＊＊＊＊");
		System.out.printf("%s\n","　＊＊＊＊＊＊＊");
		System.out.printf("%s\n","　　＊＊＊＊＊");
		System.out.printf("%s\n","　　　＊＊＊");
		System.out.printf("%s\n","　　　　＊");

		System.out.printf("%s\n","*********");
		System.out.printf("%8s\n","*******");
		System.out.printf("%7s\n","*****");
		System.out.printf("%6s\n","***");
		System.out.printf("%5s\n","*");
		
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<9; j++) {
				System.out.print('*');
				
			}
			System.out.println();

		}
		
		
		
		
	}
}
