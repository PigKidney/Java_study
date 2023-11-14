import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class D13_SimpleDateFormat {
	/*
	  
	  	# SimpleDateFormate
	  	
	  	- Date타입 인스턴스를 서식을 사용해 문자열로 변환할 수 있는 클래스
	  	- y : 년
	  	- M : 월
	  	- d : 일
	  	- h : 12시
	  	- H : 24시
	  	- m : 분
	  	- s : 초
	  	- S : 밀리초
	  	- E : 요일(짧게)
	  	- EEEE : 요일(길게)
	  	- a : 오전/오후
	  	- z : 타임존
	  
	 */
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS EEEE");
		
		// 다른 나라 시간 뽑아보기
		for (String id : TimeZone.getAvailableIDs()) {
			System.out.println(id);
		}
	
		Calendar cocos = Calendar.getInstance(TimeZone.getTimeZone("US/Alaska"));
		String result = sdf.format(cocos.getTime());
		System.out.println(result);
		System.out.println(cocos.getTime());
		System.out.println(sdf.format(new Date()));
		
		
	}
}
