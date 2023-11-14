package quiz;

public class B06_ForQuiz {
	public static void main(String[] args) {
		// 1000부터 2000사이의 8의 배수를 모두 출력해보세요.
		// 100부터 300까지 총합을 구해보세요.
		// 1000부터 2000까지의 10의 배수를 한줄에 5개씩 출력해보세요.
		
		for(int i=1000; i<=2000 ; i+=8) {
			System.out.println(i);
		}
		
		int num;
		int num1=0;
		for(num = 100 ; num<=300 ;num++) {
			num1 = num1 + num;
		}
		System.out.println(num1);
		
		
		int j;
		for(j=1000; j <= 2000 ;j++) {
			if(j%10 == 0) {
				System.out.print(j+"\t");
				
			} 
			if(j%50 == 40) {
				System.out.println();
			}
	
		}
		
		System.out.println("------------------------------------");
		
//		int k;
//		for(k=0; k <5 ;k++) {
//			for(int d=1000; d<=2000 ; d++) {
//				if(d%10 == 0) {
//					System.out.print(d);
//				}
//			} System.out.println();
//		}
		
		
		
	}
}
