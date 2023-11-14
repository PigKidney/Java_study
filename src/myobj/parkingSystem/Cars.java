package myobj.parkingSystem;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Cars {
	
	final private static String[] carType = {"장애인", "유아동승", "일반", "화물차", "경차", "중형", "소형"};
	
	final private static String symbols = "가나다라마바사아자하호허";
	
	private static LocalDateTime getRandomExitTime() {
		return LocalDateTime.now().plus((int)(Math.random()*1000),ChronoUnit.MINUTES);
	}
	
	
	private static String getRandomCarType() {
		return carType[(int)(Math.random()*carType.length)];
	}
	
	private static String getRandomCarNumber() {
		StringBuilder carNum = new StringBuilder();
		carNum.append(String.format("%02d",(int)(Math.random()*999+1)));
		carNum.append(symbols.charAt((int)(Math.random()*symbols.length())));
		carNum.append(String.format("%04d",(int)(Math.random()*9899+1)));
		return carNum.toString();
	}
	
	public static Car getRandomCar() {
		return new Car(getRandomCarNumber(), getRandomCarType(), LocalDateTime.now(), getRandomExitTime());
	}
	
	public static Car getParkedRandomCar() {
		return new Car(getRandomCarNumber(), getRandomCarType(), LocalDateTime.now(), LocalDateTime.now());
	}
	
}
