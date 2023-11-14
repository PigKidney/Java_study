package myobj;

public class Iphone {
	String color;
	int battery = 80;
	int batteryhealth = 100;
	int cycle = 0;
	boolean powerOn;
	boolean charging;
	

	public Iphone() {

	}

	public Iphone(int battery, int batteryhealt, int cycle) {
		this.battery = battery;
		this.batteryhealth = batteryhealt;
		this.cycle = cycle;
	}

//	boolean powerOn() {
//		while(battery>0) {
//			--battery;
//		}
//		return ture;
//	}
	public void chargingBattery() {
		if (this.battery < 100) {
			++this.battery;
			charging = true;
		} else if (this.battery == 100) {
			System.out.println("충전이 완료되었습니다.");
			++cycle;
		}
	}

	public void getbatteryEfficiency() {

	}

	public void usingPhone() {
		if (this.battery > 0) {
			--this.battery;
			powerOn = true;
		} else if (this.battery == 0) {

			System.out.println("배터리가 없어 종료합니다.");
		}
	}

	public void iphoneInfo() {
		System.out.printf("------Info------\n현재 배터리 잔량[%d]\n사이클 수[%d]\n배터리 효율[%d]\n----------------\n", battery,
				cycle, batteryhealth);
	}

//		boolean batteryEfficiency() {
//			if (fullcount == 100) {
//				this.batteryEfficiency = 0;
//				System.out.println("핸드폰 배터리의 수명이 다했습니다.");
//			}
//		}

}

class Iphone15 extends Iphone {
	String[] color= {"블랙","블루","그린","옐로","핑크"};
	double width = 71.6;
	double height = 147.7;
	double thick = 7.8;
	double weight = 171.0;
	
	public Iphone15(int battery, int batteryhealt, int cycle,int colorNum) {
		super(battery,batteryhealt,cycle);
		String color = this.color[colorNum];

	}
	
}
