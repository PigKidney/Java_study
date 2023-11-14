package myobj.parking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParkingCar extends Management{
	String licensePlate; // 차량 번호판
	int price = 0;	// 차량에 대한 주차요금
	boolean isExclude = false; // 면제 차량
	boolean isUseingTicket = false; // 정기권
	public boolean discmplt = true;
	public LocalDateTime startTime;
	public LocalDateTime exitTime;
	
	public ParkingCar() {
		getLicensePlate();
		getStratTime();
	}	
	
	public String getCarNum() {
		Pattern carNumPattern = 
				Pattern.compile("(\\d{2,3})[가-힣](.*)");
		Matcher matcher = carNumPattern.matcher(licensePlate);
		while(matcher.find()) {
			return matcher.group(2);
		} 
		
		return null;
	}
	
	public void setLicensePlate(String license) {
		this.licensePlate = license;
	}
	
	
	public String getLicensePlate() {
		return licensePlate;
	}

	public int getPrice() {
		return price;
	}
	
	public String getStratTime() {
//		startTime = LocalDateTime.now();
		startTime = LocalDateTime.of(2023, 10, 20, 14, 00, 28, 212794300);
		return startTime.toString();
	}
	
	public String getExitTime() {
//		exitTime = LocalDateTime.now();
		exitTime = LocalDateTime.of(2023, 10, 20, 15, 10, 28, 212794300);

		return exitTime.toString();
	}
	
	public int calculation(int dif) {
		if(dif<30) {
			return price=0;
		} else if(dif>=30 && dif<60) {
			return price=((dif-30)/10+1)*MIN_OF_PRICE;
		} else if(dif>=60) {
			return price=((dif-60)/10+1)*HOUR_AFTER_MIN_OF_PRICE+600;
		}
		return price;
	}
	
	public long getUsedMin(LocalDateTime startTime,LocalDateTime exitTime) {
		Duration usedTime = Duration.between(startTime, exitTime);
		return usedTime.toMinutes();
	}
	
	public LocalDateTime getStartTime(String time) {
		
		return startTime;
	}
}
