package myobj.parking;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Management {
	final static String [][] unaccess = {{"1","6"}, {"2","7"}, {"3","8"}, {"4","9"}, {"5","0"}, {null}, {null}}; //월0 화1 수2 목3 금4 토5 일6
	final static String weekKorName = "월화수목금토일"; //월0 화1 수2 목3 금4 토5 일6
	final static int MIN_OF_PRICE = 200;
	final static int HOUR_AFTER_MIN_OF_PRICE = 300;
	public boolean availableToParking = true; // 주차 가능한가
	
	public void isAvailableToParking(String license) {
	
		Pattern carNumPattern = 
				Pattern.compile("(\\d{2,3})[가-힣](\\d{3})(\\d)");
		Matcher matcher = carNumPattern.matcher(license);
		LocalDate now = LocalDate.now();
		DayOfWeek dow = now.getDayOfWeek();
		String dotw = dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
		int weekNUm = weekKorName.indexOf(dotw);
		while(matcher.find()) {
			for(int i = 0 ; i < unaccess[weekNUm].length ; i++) {
				if(unaccess[weekNUm][i].equals(matcher.group(3))) {
					availableToParking = false;
					break;
				} else {
					availableToParking = true;
				}
			} 					
		}
		if(availableToParking) {
			System.out.println(license+"의 차량은 "+dotw+"요일에 주차가 가능합니다");
		} else {
			System.out.println(license+"의 차량은 "+dotw+"요일에 주차가 불가능합니다");
		}		
	}
	
	
	
	
}
