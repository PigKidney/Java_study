package myobj.parkingSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
	String carNum;
	String carType;
	LocalDateTime startTime;
	LocalDateTime exitTime;
	String carNumFour;

	// SimpleDateFormat - java.util.Date 타입 전용
//    private static SimpleDateFormat parkingTimeFormat = new SimpleDateFormat("MM-dd(e)/HH:mm");

	// DateTimeFormatter - java.time 패키지 전용 포맷
	private static DateTimeFormatter parkingTimeFormat = DateTimeFormatter.ofPattern("MM-dd(E)/HH:mm");

	Car(String carNum, String carType, LocalDateTime startTime, LocalDateTime exitTime) {
		this.carNum = carNum;
		this.carType = carType;
		this.startTime = startTime;
		this.exitTime = exitTime;
		getFourNum(carNum);
	}

	public String getCarNum() {
		return carNum;
	}

	public LocalDateTime getExitTime() {
		return exitTime;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	public LocalDateTime setCarExitTime() {
//		this.exitTime = LocalDateTime.now();
//		return exitTime;
		// 데이터 테스트용 랜덤 시간적용
		this.exitTime = LocalDateTime.now().plus((int)(Math.random()*1000),ChronoUnit.MINUTES); 
		System.out.format("출차시간 : "+ exitTime.format(parkingTimeFormat)+"\n");
		return exitTime;
	}
	
	
	public String getFourNum(String num){
		Pattern carNumPattern = Pattern.compile("(\\d{2,3})[가-힣](\\d{4})");
		Matcher matcher = carNumPattern.matcher(num);
		while(matcher.find()) {
			this.carNumFour = matcher.group(2);
		}
		return this.carNumFour;
	}
	
	public String getCarNumFour() {
		return carNumFour;
	}
	
	public String getCarNumFour(String num) {
		return carNumFour=num;
	}

	public String getCarType() {
		return carType;
	}
	
//	@Override
//	public String toString() {
//		return String.format("[%s  %s  %s  %s]", carNum, carType, startTime.format(parkingTimeFormat),
//				exitTime.format(parkingTimeFormat));
//	}

	@Override
	public String toString() {
		return String.format("[%s  %s  %s]", carNum, carType, startTime.format(parkingTimeFormat));
	}
}