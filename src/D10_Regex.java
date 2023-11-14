import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D10_Regex {

	/*
	 * # 정규표현식 (Regular Expression)
	 * 
	 * - 문자열이 특정 패턴과 일치하는지 검사할 수 있는 표현식 - 특정 프로그래밍 언어에만 있는 것이 아닌 공통의 규칙
	 * 
	 * 
	 * # 자바에서 정규표현식을 활용하기 위한 클래스
	 * 
	 * - java.util.regex.Pattern
	 * 
	 */
	public static void main(String[] args) {

		// Pattern.matches(regex, text)
		// : 해당 문자열이 정규표현식에 해당하는 문자열인지 검사하는 메서드
		System.out.println(Pattern.matches("sleep", "sleep"));

		// [] : 해당 위치에 들어올 수 있는 문자를 정의하는 정규표현식 문법
		System.out.println(Pattern.matches("s[lh]eep", "sheep"));
		System.out.println(Pattern.matches("s[lh]eep", "steep"));
		System.out.println(Pattern.matches("s[lh]e[ea]p", "sleap"));

		// \는 정규표현식 내부에서도 특수한 문법으로 사용되기 때문에
		// 정규표현식에서도 \\로 해석되도록 자바 문자열에서는 4개를 적어줘야한다
		System.out.println(Pattern.matches("s[abc/\\\\]e[ea]p", "s\\eap"));
		System.out.println(Pattern.matches("s[abc/\\n]e[ea]p", "s\neap"));

		/*
		 * 
		 * # [] 내부에서 사용하는 문법들
		 * 
		 * [abc] : a 또는 b 또는 c를 허용 
		 * [a-z] : a 부터 z를 모두 허용
		 * [A-Z] : A 부터 Z를 모두 허용 
		 * [a-zA-Z] : 모든 알파벳을 허용 
		 * [a-g&&c-p] : 두 조건을 모두 만족하는 문자만 허용
		 * 
		 * 
		 */
		System.out.println(Pattern.matches("[a-z]at", "hat"));
		System.out.println(Pattern.matches("[a-z]at", "cat"));
		System.out.println(Pattern.matches("[a-z]at", "Eat"));

		/*
		 * 
		 * # 하나로 여러 문자를 나타내는 문법들
		 * 
		 * . : 모든 문자 허용 => [.] 또는 
		 * \. 을 사용해야 .만 허용한다는 뜻이 된다 
		 * \d : 모든 숫자를 허용 
		 * \D : 숫자를 제외한 나머지를 모두 허용 
		 * \s : 모든 공백을 허용 (\t, \n, \r, ' ') 
		 * \S : 공백을 제외한 나머지를 모두 허용 
		 * \w : 일반적인 문자들을 허용. [a-zA-Z0-9_]와 같음 
		 * \W : \w를 제외한 나머지를 모두 허용
		 * 
		 * 
		 * 
		 */
		System.out.println(Pattern.matches(".at", "⊙at"));
		System.out.println(Pattern.matches(".at", "⊙at"));
		System.out.println(Pattern.matches(".co.kr", "acokkr")); // true 로 나온다
		System.out.println(Pattern.matches("\\deleven", "0eleven"));
		System.out.println(Pattern.matches("\\deleven", "7eleven"));
		System.out.println(Pattern.matches("\\deleven", "9eleven"));

		/*
		 * 
		 * # 앞의 패턴을 여러번 적용시키기 위한 문법
		 * 
		 * .{n} 	: {}앞의 패턴이 n개 일치해야 한다 
		 * .{n,m} 	: {}앞의 패턴이 n개 이상 m개 이하 일치해야 한다 
		 * .{n,} 	: {}앞의 패턴이 n개 이상 일치해야 한다 
		 * .? 		: ? 앞의 패턴이 0번 또는 한 번 나와야 한다 
		 * .+ 		: + 앞의 패턴이 1번 이상 나와야 한다
		 * .* 		: * 앞의 패턴이 0번 이상 나와야 한다
		 * 
		 */
		System.out.println(Pattern.matches("[0-5]{5}\\d", "012349"));
		System.out.println(Pattern.matches("[.]{2,3}에휴", "..에휴"));
		System.out.println(Pattern.matches("[.]{2,3}에휴", "...에휴"));
		System.out.println(Pattern.matches("[.]{2,3}에휴", "...에휴"));
		System.out.println("is hp? " + Pattern.matches("010-?[\\d]{4}-?[\\d]{4}", "010-1234-1234"));
		System.out.println("is hp2? " + Pattern.matches("(010)?-?[\\d]{4}-?[\\d]{4}", "010-1234-1234"));

		// 문법을 소괄호로 묶어서 적용하는 것이 가능

		System.out.println("() test : " + Pattern.matches("([a-z]\\d)?", "a7"));

		// 여러개 중 하나를 선택하게 만들기

		System.out.println("choice test : " + Pattern.matches("(123|456|789)", "123")); // => || 안에 값을 무조건 써야한다

		System.out.println("is phone? : " + Pattern.matches("010(-\\d{4}-|\\d{4})\\d{4}", "010-1234-1234"));

		// 연습 1 : 해당 문자열이 핸드폰 번호인지 검사할 수 있는 정규표현식을 만들어보세요 (옛날 번호 포함)
		System.out.println(
				"is phone? : " + Pattern.matches("01[016789](-\\d{3,4}-|\\d{3,4})\\d{4}", "019-1242-1234"));
		// 연습 2 : 해당 문자열이 이메일인지 검사할 수 있는 정규표현식을 만들어보세요
		System.out.println(
				"is email? : " + Pattern.matches("\\w[\\w-]+@[\\w+]+(\\.[a-zA-Z]+)*", "ez124@naver.co.kr"));
		// 연습 3 : 해당 문자열이 IP주소인지 검사할 수 있는 정규표현식을 만들어보세요.
		// (0.0.0.0 ~ 255.255.255.255)
		System.out.println("is IP ? : " + Pattern.matches(
				"((2[0-4][\\d]|1[\\d]{2}|[1-9]?\\d|25[0-5])[.]){3}(2[0-4][\\d]|1[\\d]{2}|[1-9]?\\d|25[0-5])",
				"168.0.18.0"));

		// 연습 4 : 비밀번호 생성 규칙을 만족하는 비밀번호인지 검사하는 정규표현식을 정의해보세요
		
		/*
		 
		 	# Matcher
		 	
		 	- 전체 문자열을 탐색하면서 정규표현식과 매치하는 부분을 찾는 기능을 수행하는 클래스
		 	- Pattern 클래스에서 만들어낸 정규표현식 인스턴스를 장착하여 사용한다 
		 	- Pattern 클래스는 문자열 정규표현식을 컴파일 하여 Pattern 인스턴스를 생성할 수 있다
		 
		 */
		
		String fruits = "apple/banana/orange/"+ "kiwi/sagwa/peach/pineapple/waterapple/goldapple/"+"apple/banana/orange/apple/banana/orange";
		
		//1. 정규표현식을 컴파일하여 Pattern 인스턴스 생성
		Pattern phonePattern = 
				Pattern.compile("(\\w*)(apple)");
	
		//2. Pattern 인스턴스에 검사할 문자열을 넣어 matcher 생성
		Matcher matcher = phonePattern.matcher(fruits);
		
		//3. 반복문을 통해 패턴과 매치하는 문자열의 위치를 찾는다
		// matcher.find() : 패턴과 일치하는 다음 문자열을 찾는다. 찾은게 있으면 true
		while(matcher.find()) {
			System.out.println("---------------------------------------");
			System.out.println("이번에 찾은 전체 문자열: "+ matcher.group());
			System.out.println("시작 위치 : "+ matcher.start());
			System.out.println("끝나는 위치 : "+ matcher.end());
			
			// 괄호를 이용해 패턴과 일치하는 일부분만 꺼낼 수 있다
			System.out.println("group(0): " + matcher.group(0));
			System.out.println("group(1): " + matcher.group(1));
			System.out.println("group(2): " + matcher.group(2));
			
			System.out.printf("group(1)의 위치 :  %d~%d\n",matcher.start(1),matcher.end(1));
			System.out.printf("group(2)의 위치 :  %d~%d\n",matcher.start(2),matcher.end(2));
		}
		
		
	}

}
