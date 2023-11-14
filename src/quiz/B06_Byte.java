package quiz;
// 반복문을 사용해 모든 byte 타입의 값을 출력해보세요.
public class B06_Byte {
	public static void main(String[] args) {
		//byte byte_min=-128, byte_max=127;  Byte.MIN_VALUE  Byte.MAX_VALUE
//		for(int bytetype=-128 ; bytetype<=127 ; bytetype++) {
//			System.out.println(bytetype);
//		}
		for(byte bytetype=Byte.MIN_VALUE ; bytetype<=Byte.MAX_VALUE ; ) {
			System.out.println(bytetype++);
			
			if (bytetype == Byte.MAX_VALUE) {
				break;
			}
			
		}
		
	
		
		
		
		
//		for(byte bytetype=Byte.MIN_VALUE ; bytetype<=Byte.MAX_VALUE ; bytetype++) {
//			System.out.println(bytetype);
//			
//			if (bytetype == Byte.MAX_VALUE) {
//				break;
//			}
//			
//		}
	}
}
