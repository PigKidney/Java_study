package quiz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D13_EventDay {
	final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE");
	/*
	 * 실행하면 오늘로부터 앞으로 1년간의 모든 이벤트 날짜를 출력해주는 프로그램을 만들어보세요
	 * 
	 * 1+1 이벤트 : 매월 18일 20% 할인 이벤트 : 홀수번째 금요일
	 * 
	 * 이벤트 날짜가 겹치는 날에는 둘 모두 적용됨을 알려줘야 한다
	 */
	
	public static void isEventDay(String date) {
		// 1+1 이벤트 : 매월 18일
		// 20% 할인 이벤트 : 홀수번째 금요일
		Calendar event = Calendar.getInstance();
		Pattern eventPattern = 
				Pattern.compile(".+-.+-(.+) (.+)");
		                    //"yyyy-MM-dd EEEE"
		Matcher matcher = eventPattern.matcher(date);
		int odd = event.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		while(matcher.find()) {
			String plusEvent= matcher.group(1);
			String discountEvent = matcher.group(2);
			if(plusEvent.equals("18") && discountEvent.equals("금요일") && odd%2==1) {
				System.out.print(date);
				System.out.println(" : 1+1 이벤트 & 20% 할인 이벤트");
			} else if (plusEvent.equals("18")) {
				System.out.print(date);
				System.out.println(" : 1+1 이벤트");
			} else if (discountEvent.equals("금요일") && odd%2==1) {
				System.out.print(date);
				System.out.println(" : 20% 할인 이벤트");
			}
		}
	}

	public static void main(String[] args) {
		
		Calendar date = Calendar.getInstance();
		Calendar target = Calendar.getInstance();
		target.add(Calendar.YEAR, 1);
		
		while(date.before(target)) {
			date.add(date.DATE, 1);
		
			String result = sdf.format(date.getTime());
			isEventDay(result);
		}
		
		Calendar today = Calendar.getInstance();
		SimpleDateFormat eventDayFormat = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0; i < 366; ++i) {
			int dayOfMonth = today.get(Calendar.DAY_OF_MONTH);
			int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
			int dayOfWeekInMonth = today.get(Calendar.DAY_OF_WEEK_IN_MONTH);
			
			if (dayOfMonth == 18 && dayOfWeek == Calendar.FRIDAY && dayOfWeekInMonth%2 ==1) {
				System.out.printf("[[ %s ]]",eventDayFormat.format(today.getTime()));
				System.out.println("[NOTICE] 1+1 이벤트 & 20% 할인 행사 진행중~!");
			} else if(dayOfMonth == 18) {
				System.out.printf("[[ %s ]]",eventDayFormat.format(today.getTime()));
				System.out.println("[NOTICE] 1+1 이벤트 행사 진행중~!");
			} else if(dayOfWeek == Calendar.FRIDAY && dayOfWeekInMonth%2 ==1) {
				System.out.printf("[[ %s ]]",eventDayFormat.format(today.getTime()));
				System.out.println("[NOTICE] 20% 할인 이벤트 행사 진행중~!");
			}
			
			today.add(Calendar.DATE , 1);
		}
	}
}
