package quiz;

import java.util.HashSet;

public class D04_isJavaVariable {
	/*
	 * 문자열을 매개변수로 전달하면 해당 문자열이 자바 변수로 사용할 수 있는 문자열인지 검사해주는 메서드를 만들어보세요
	 * 
	 */
	
	static HashSet<String> reservedKeywords =  new HashSet<>();

	static String [] kws = {
	        "abstract", "continue",     "for",          "new",          "switch",
	        "assert",   "default",      "if",           "package",      "synchronized",
	        "boolean",  "do",           "goto",         "private",      "this",
	        "break",    "double",       "implements",   "protected",    "throw",
	        "byte",     "else",         "import",       "public",       "throws",
	        "case",     "enum",         "instanceof",   "return",       "transient",
	        "catch",    "extends",      "int",          "short",        "try",
	        "char",     "final",        "interface",    "static",       "void",
	        "class",    "finally",      "long",         "strictfp",     "volatile",
	        "const",    "float",        "native",       "super",        "while",
	        // literals
	        "null",     "true",         "false"
	    };
	
	static {
		// 배열의 모든 내용을 Set에 추가
		for (String kw : kws) {
			reservedKeywords.add(kw);
		}
	}
	static boolean isVariableName(String str) {
		if(reservedKeywords.contains(str)) {
			return false;
		} 
		if (!Character.isJavaIdentifierStart(str.charAt(0))) {
			return false;
		} else {
			for (int i = 1; i < str.length(); i++) {
				if (!Character.isJavaIdentifierPart(str.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}

	boolean checkName(String varName) {
		if(reservedKeywords.contains(varName)) {
			System.out.printf("%s는 자바 예약어이므로 변수명으로 사용할 수 없습니다.\n",varName);
			return false;
		}
		if (Character.isJavaIdentifierStart(varName.charAt(0))) {
			for (int i = 1; i < varName.length(); i++) {
				char ch = varName.charAt(i);
				if (!Character.isJavaIdentifierPart(ch)) {
					System.out.printf("%d 번째 문자 %c는 변수명으로 사용할 수 없습니다.\n",i,ch);
					return false;
				}
			}
			return true;
		} else {
			System.out.printf("첫 번째 문자 %c는 변수명으로 사용할 수 없습니다.\n",varName.charAt(0));
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		String [] name = {"321", "qkqh", "바보", "되나요?", "\"@____", "<[>", "I'M_GOD", "Fly", "int"};

		int size = name.length-1;
		while (size > 0) {
			System.out.println("["+name[size] +"]의 사용가능성 : " +isVariableName(name[size]));
			size--;
		}
		
		D04_isJavaVariable quiz = new D04_isJavaVariable();
		System.out.println(quiz.checkName("abcd"));
		System.out.println(quiz.checkName("7eleven"));
		System.out.println(quiz.checkName("channel#3"));
		System.out.println(quiz.checkName("int"));
		System.out.println(quiz.checkName("_"));
		
	}
}
