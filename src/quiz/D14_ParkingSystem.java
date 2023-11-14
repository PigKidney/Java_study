package quiz;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myobj.parkingSystem.Car;
import myobj.parkingSystem.Cars;

public class D14_ParkingSystem {
	final static String[][] unaccess = { { "1", "6" }, { "2", "7" }, { "3", "8" }, { "4", "9" }, { "5", "0" }, { "-1","-1" }, { "-1","-1" } }; 
	final static String weekKorName = "월화수목금토일"; // 월0 화1 수2 목3 금4 토5 일6
	final static String[] excldPrban = {"장애인",  "유아동승", "경차"};
	final static String[] dscntPrfsCars = {"경차","저탄소차","전기차"};
	final static int MIN_OF_PRICE = 200;
	final static int HOUR_AFTER_MIN_OF_PRICE = 300;
	static boolean availableToParking = true; // 주차 가능한가
	static int price = 0;
	final static int MAX_OF_PAKING_PLACE = 500;
	static Set<Car> cars = new HashSet<>(MAX_OF_PAKING_PLACE);

	public static int calculation(int dif) {
		if (dif < 30) {
			return price = 0;
		} else if (dif >= 30 && dif < 60) {
			return price = ((dif - 30) / 10 + 1) * MIN_OF_PRICE;
		} else if (dif >= 60) {
			return price = ((dif - 60) / 10 + 1) * HOUR_AFTER_MIN_OF_PRICE + 600;
		}
		return price;
	}

	public static long getUsedMin(LocalDateTime startTime, LocalDateTime exitTime) {
		Duration usedTime = Duration.between(startTime, exitTime);
		return usedTime.toMinutes();
	}

	private static void isAvailableToParking(String license) {

		Pattern carNumPattern = Pattern.compile("(\\d{2,3})[가-힣](\\d{3})(\\d)");
		Matcher matcher = carNumPattern.matcher(license);
		LocalDate now = LocalDate.now();
		DayOfWeek dow = now.getDayOfWeek();
		String dotw = dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
		int weekNUm = weekKorName.indexOf(dotw);
		while (matcher.find()) {
			for (int i = 0; i < unaccess[weekNUm].length; i++) {
				if (unaccess[weekNUm][i].equals(matcher.group(3))) {
					availableToParking = false;
					break;
				} else {
					availableToParking = true;
				}
			}
		}
		if (availableToParking) {
			System.out.println(license + "의 차량은 " + dotw + "요일에 주차가 가능합니다");
		} else {
			System.out.println(license + "의 차량은 " + dotw + "요일에 주차가 불가능합니다");
		}
	}

	private static void excldPrban(String carType) {
		for(int i=0 ; i < excldPrban.length ; i++) {
			if(excldPrban[i].equals(carType)) {
				availableToParking = true;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isCarParking = true;
		boolean isNotFind = true;
		while(isCarParking) {
			System.out.println("1)주차\n2)출차&요금정산");
			int num = sc.nextInt();
			switch(num){
			case 1 : 
				Car c1 = Cars.getParkedRandomCar();
				System.out.println(c1);
				isAvailableToParking(c1.getCarNum());
				if(!availableToParking) {
					excldPrban(c1.getCarType());
				}
				if(availableToParking) {
					cars.add(c1);			
					break;
				}
				break;
			case 2 :
				System.out.println("차량 번호 뒤 4자리를 입력하세요 > ");
				String exitCarNum = sc.next();
				for(Car car : cars) {
					if(car.getCarNumFour().equals(exitCarNum)) {
						car.setCarExitTime(); 
						int dif = (int)getUsedMin(car.getStartTime(), car.getExitTime());
						int price = calculation(dif);
						for(int i=0 ; i < dscntPrfsCars.length ; i++) {
							if(dscntPrfsCars[i].equals(car.getCarType())) {
								price = price/2;
								System.out.println("요금 50% 할인 대상입니다"); 
							}
						}
						System.out.printf("차량번호 - %s\n이용 시간 : [%d분]\n이용 요금 : [%d원] 입니다.\n",car.getCarNum() ,dif ,price); 
						isNotFind = false;
					} 
				}
				if(isNotFind) {
					System.out.println("일치하는 차량이 없습니다.");
					break;
				} else {
					System.out.println("이용해주셔서 감사합니다.");
					isCarParking = false;
				}
				
			}
			
		}
		
		
//		System.out.println(
//				calculation((int) getUsedMin(Cars.getRandomCar().getStartTime(), Cars.getRandomCar().getExitTime())));
	}

	
}