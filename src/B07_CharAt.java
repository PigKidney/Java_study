
public class B07_CharAt {
	public static void main(String[] args) {
		/*
		  
			# "문자열".charAt(index);
			
			 - 해당 문자열에서 원하는 위치의 문자를 char타입으로 꺼내는 메서드
		  	 - 시작 인덱스는 0이다
		  	 - 마지막 인덱스는 해당 문자열의 문자 개수 - 1 이다.
			 
			# "문자열".length();
			
			 - 해당 문자열의 길이(문자 개수)를 알 수 있다
		  	 
		*/
		char ch ="안녕하세여".charAt(0);
		
		System.out.println(ch);
		System.out.println("안녕하세여".charAt(1));
		System.out.println("안녕하세여".charAt(2));
		System.out.println("안녕하세여".charAt(3));
		System.out.println("안녕하세여".charAt(4));
		
		
		// length 을 
		String str = "O 아브렐슈드 골드 조정\r\n"
				+ ">아브 하드 매주6,000 / 2주에한번 9,000골(4관클)\r\n"
				+ " - 아브 하드 1~3관 각 2,000골\r\n"
				+ " - 아브 하드 4관문 3,000골(2주에 1회)\r\n"
				+ "\r\n"
				+ "> 카양겔하드 6,500\r\n"
				+ " - 카양겔 하드 1관문 1,500골\r\n"
				+ " - 카양겔 하드 2관문 2,000골\r\n"
				+ " - 카양겔 하드 3관문 3,000골\r\n"
				+ "\r\n"
				+ ">일리아칸 7,500골\r\n"
				+ " - 일리아칸 노말 1관문 1,500골 \r\n"
				+ " - 일리아칸 노말 2관문 2,000골\r\n"
				+ " - 일리아칸 노말 3관문 4,000골\r\n"
				+ "\r\n"
				+ "O 아브렐슈드 패턴 변경점\r\n"
				+ "> 아브렐슈드 메테오 딜컷\r\n"
				+ " - 첫 메테오만 체력 기반, 이후로는 시간 기반\r\n"
				+ " - 주요 기믹 수행 중엔 발생 X \r\n"
				+ " - 아브 6관(4관) 찬미 이후 모든패턴 스킵 가능\r\n"
				+ "\r\n"
				+ "> 그외\r\n"
				+ " - 아브 1관 투견 보호막 삭제 (딜로 밀면 끝)\r\n"
				+ " - 아브 3관 별패턴 : 별 1개, 육/팔은 각 두개로 변경\r\n"
				+ " - 비아키스 3관문 기믹 스킵 가능\r\n"
				+ " - 상아탑 2관문 구슬낙하위치 미리 확인 가능하도록 변경\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "O 신규군단장 카멘\r\n"
				+ "> 퍼클 이벤트 \"카멘, The FIRST\" \r\n"
				+ " - [퍼클] 전서버에 어나운스 및 유물칭호\r\n"
				+ "   -- 단, 카멘 레이드 중엔 띄우지 않음(시스템메세지만 출력)\r\n"
				+ " - [10클까지] 어나운스\r\n"
				+ " - [10클까지] 설치물도 제공 1/ 2~3/ 4~10위별 이펙트 차등\r\n"
				+ " - [10클까지] 카멘 트로피 제공 1/ 2~3/ 4~10위별 이펙트 차등\r\n"
				+ "\r\n"
				+ "> 노말 클골 13,000골\r\n"
				+ " - [노말 1관문] 3,500골\r\n"
				+ " - [노말 2관문] 4,000골\r\n"
				+ " - [노말 3관문] 5,500골\r\n"
				+ "\r\n"
				+ "> 하드 클골 1~3 20,000골, 1~4 41,000골\r\n"
				+ " - [하드 1관문] 5,000골\r\n"
				+ " - [하드 2관문] 6,000골\r\n"
				+ " - [하드 3관문] 9,000골\r\n"
				+ " - [하드 4관문] 21,000골(2주/1회)";
		
		System.out.println("마지막 글자 : "+ str.charAt(str.length()-1));
		
		// for문을 사용하면 문자열을 쉽게 탐색할 수 있다.
		String text = "다람쥐 헌 쳇바퀴에 타고파";
		
		for(int i = 0; i< text.length() ; ++i) {
			char c = text.charAt(i);
			System.out.printf("%d번째 문자 : %c\n",i,c);
		}
		
		// 연습 : 문자열 str을 거꾸로 출력해보세요.
		
		for(int i=str.length()-1; i>=0; --i) {
			System.out.print(str.charAt(i));
		}
		for(int i=0 ; i<str.length(); ++i) {
			System.out.print(str.charAt(str.length()-1-i));
		
		}
	}
}
