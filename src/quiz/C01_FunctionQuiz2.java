package quiz;

public class C01_FunctionQuiz2 {
	/*
	 * 
	 * 1. 실행하면 4자리 임시 비밀번호를 생성하여 반환해주는 함수
	 * 
	 * 2. 문자열을 전달하면 해당 문자여을 마구 뒤섞은 문자여을 반환해주는 함수
	 * 
	 * 3. 문자열을 전달하면 해당 문자열의 대소문자를 반전시킨 문자열을 반환해주는 함수
	 * 
	 * 4. 문자열을 전달하면 해당 문자열이 숫자로만 이루어져 있는지 여부를 알려주는 함수
	 * 
	 * 
	 */
	/**
	 * 영문 대문자로 이루어진 랜덤 4글자의 비밀번호 생성
	 * 
	 * @return
	 */
	public static String makePassword() {
		String password = "";
		for (int i = 0; i < 4; ++i) {
			password += ((char) (Math.random() * 26 + 65));
		}
		return password;
	}

	/**
	 * String 값을 입력하면 순서를 랜덤으로 섞어서 출력
	 * 
	 * @param text
	 * @return
	 */
	public static String mixText(String text) {
		// "".toCharArray() : 문자열로 char[]을 만들어 변환한다.
		char[] arr = text.toCharArray();
		for (int i = 0 ; i < 1000; i++) {
			int ranIndex = (int)(Math.random()*(arr.length-1)+1);
			char temp = arr[0];
			arr[0] = arr[ranIndex];
			arr[ranIndex] = temp;
		}
		// char[]을 재료로 전달하여 새 문자열을 생성한다.
		// new String(arr);
		
		// System.in을 재료로 전달하여 새 스캐너를 생성한다.
		// new Scanner(System.in);
		
		return new String(arr);
		
		
//		String reword = "";
//		int len = text.length();
//		for (int i = 0; i < len; i++) {
//			reword += text.charAt((int) (Math.random() * len));
//		}
//		return reword;
	}

	/**
	 * String에 영문 대소문자를 뒤집어서 출력함
	 * 
	 * @param text
	 * @return
	 */
	public static String reAlp(String text) {
		String reAlp = "";
		int len = text.length();
		for (int i = 0; i < len; i++) {
			char ch = text.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				ch -= 32;
			} else if (ch >= 'A' && ch <= 'Z') {
				ch += 32;
			}
			reAlp += ch;
		}
		return reAlp;
	}

	/**
	 * 입력 String값이 숫자로만 이루어져 있나 확인
	 * 
	 * @param text
	 * @return 모두 숫자면 true 그렇지 않다면 false
	 */
	public static boolean isAllNum(String text) {
		//숫자가 아닌게 하나라도 나오면 바로 return false
		int len = text.length();
		for (int i = 0; i < len; i++) {
			char ch = text.charAt(i);
			if (ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// 1번
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(makePassword());
		}

		// 2번
		System.out.println(mixText("Lost Ark"));

		// 3번
		System.out.println(reAlp("Lost Ark"));

		// 4번
		if (isAllNum("129Q30")) {
			System.out.println("숫자만 있습니다.");
		} else {
			System.out.println("숫자말고 다른문자도 있습니다.");
		}

	}
}
