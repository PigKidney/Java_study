package quiz;

public class A02_SwapValue {
	public static void main(String[] args) {
		
	
		int a=(int)(Math.random()*30), b=(int)(Math.random()*30);
		
		System.out.println("a에 들어있는값: "+a);
		System.out.println("b에 들어있는값: "+b);

		// 코드를 추가해 두 변수의 값을 서로 바꿔서 출력해보세요
			
		
		// b에 a를 넣기전에 임시 변수를 만들어서 a 값을 뺴놓는다.
		int temp=a; 
		a=b;
		b=temp; //  임시 변수에 저장해놨던 a의 원래 값을 b에 넣는다.
		
	
	
		
		System.out.println("바꾼 후 a : "+a);
		System.out.println("바꾼 후 b : "+b);
		
	}
	
	
}
