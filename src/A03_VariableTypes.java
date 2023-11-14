
public class A03_VariableTypes {
	public static void main(String[] args) {
		
		byte byte_min=-128, byte_max=127;
		short short_min=-32768, short_max=32767;
		char char_min=0, char_max=65535;  // 0~65535까지의 값을 사용할 수 있다(65536가지의 양수 값)
		int	int_min=-2147483648, int_max=2147483647;  // int int_min= Tnteger.MIN_VALUE
		long long_min=-9223372036854775808L, long_max=9223372036854775807L;
		
		// AC00 -> 44032
		
		// char 타입에 넣는 정수값은 우리에게 보여줄때 문자로 바꿔서 보여준다.
		char ch1 = 44032, ch2 = 5528;
		char ch3 = '가'; // ''문자도 실제로는 정수 값을 가지고 있다.
		// 문자 타입 리터럴은 실제로 정수값이기 때문에 다른 정수타입에도 저장 할 수 있다.
		
		
		int num2 = 'F';
		int num3 = '값';
		
		// 숫자 타입에 저장한 문자 리터럴을 출력하면 해당 문자의 실제 값을 확인할 수 있다.
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println((int)ch3);
		System.out.println(num2);
		System.out.println(num3);
		
		
		// ASCII 코드 : 0 ~ 127번까지의 코드
		char ch4 = 65;
		
		System.out.println(ch4);
		
		
		
		System.out.println("byte 타입의 최소값은 " + byte_min + "이고 " +"최대값은"+byte_max+"입니다.");
		System.out.println("short 타입의 최소값은 " + short_min + "이고 " +"최대값은"+short_max+"입니다.");
		System.out.println("char 타입의 최소값은 " + (int)char_min + "이고 " +"최대값은"+(int)char_max+"입니다.");
		System.out.println("int 타입의 최소값은 " + int_min + "이고 " +"최대값은"+int_max+"입니다.");
		System.out.println("long 타입의 최소값은 " + long_min + "이고 " +"최대값은"+long_max+"입니다.\n");

		System.out.println("byte 타입의 최소값은 " + Byte.MIN_VALUE + "이고 " +"최대값은"+Byte.MAX_VALUE+"입니다.");
		System.out.println("short 타입의 최소값은 " + Short.MIN_VALUE + "이고 " +"최대값은"+Short.MAX_VALUE+"입니다.");
		System.out.println("char 타입의 최소값은 " + (int)Character.MIN_VALUE + "이고 " +"최대값은"+(int)Character.MAX_VALUE+"입니다.");
		System.out.println("int 타입의 최소값은 " + Integer.MIN_VALUE + "이고 " +"최대값은"+Integer.MAX_VALUE+"입니다.");
		System.out.println("long 타입의 최소값은 " + Long.MIN_VALUE + "이고 " +"최대값은"+Long.MAX_VALUE+"입니다.");

		// 그냥 소수만 적는 것은 double 타입이기 때문에
		// Float에 저장하려고 할 때는 F를 붙여 크기를 줄여줘야 한다
		
		float avg_score = 96.F;
		double avg_weight = 85.9999; // double은 그냥 적어도 된다.
		System.out.println("평균 점수 :\t"+avg_score);
		System.out.println("평균 몸무게 :\t"+avg_weight);
		
		// boolean 타입은 변수의 이름이 아주 중요하다

		boolean ismale = true;
		boolean goonpil = true;
		boolean powerOn = true;
		boolean rich = false;
		
		
		// 문자열
		
		String welcomeMessage = "어서오세요 환영합니다!";
		System.out.println(welcomeMessage);
		
	}
	/*
	    # 정수 타입 Byte.MIN_VALUE
	    
	     - byte		(1byte, 8bit) 2^8(256)가지의 값을 표현할 수 있다. -128 ~ 127
	     - short	(2byte, 16bit) 2^16(65536)가지의 값을 표현할 수 있다. -32,768 ~ 32,767
	     - char		(2byte, 16bit) +
	     - int		(4byte, 32bit) 2^32(4,294,967,296)가지의 값을 표현할 수 있다. -2,147,483,648 ~ 2,147,483,647
	     - long		(8byte, 64bit) 2^64(18,446,744,073,709,551,616)가지의 값을 표현할 수 있다. 
	     						   -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
	    
	    # 실수 타입 
	    
	     - 부동 소수점 방식을 이용한다
	     - float (4byte)
	     - double (8byte)
	    
	    
	    
	    # 참/거짓 타입
	    
	     - boolean
	     		
	    # 문자열
	  
	     - String
	 */

}
