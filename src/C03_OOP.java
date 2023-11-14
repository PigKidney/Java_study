
public class C03_OOP {
	/*
	 * 
	 * # 객체 지향 프로그래밍(Object Oriented Programming)
	 * 
	 * - 변수와 함수들을 하나의 개념으로 묶어서 생각하는 프로그래밍 방법 - 변수와 함수들을 무분별하게 사용하다보면 여러 문제점들이 발생하기
	 * 때문에 현실에 존재하는 하나의 개념(객체)으로 묶어서 생각하기 시작했다 - 변수는 객체의 현재 상태를 나타낸다 - 함수는 주로 해당 객체의
	 * 여러 기능(행동)들을 나타낸다 - 함수는 해당 객체의 현재 상태를 변화시킨다 - 객체 내부에서 해당 객체의 상태를 변화시키는 함수를
	 * 메서드라고 부른다
	 * 
	 * ex: 책(Book)
	 * 
	 * - 책의 현재 상태 (변수) : 현재 보고있는 페이지, 방행일, 제목, 글쓴이, 각 페이지의 낙서들, 각 낙서들의 좌표, 가격 - 책의
	 * 기능 (메서드) : 책을 다음 페이지로 넘긴다, 여러 페이지 넘긴다, 앞으로 넘긴다, 특정 페이지에 책갈피를 꽂는다 ,새로운 메로를
	 * 추가한다 등 책의 현재 상태를 변화시킬 수 있는 것들
	 * 
	 * # 클래스 (Class)
	 * 
	 * - 객체지향에서 말하는 객체라는 존재를 프로그래밍 언어로 표현하는 문법 - 클래스는 해당 객체의 설계도 역할을 한다 - 클래스를 정의한
	 * 시점에서는 실제 객체가 존재하지 않는다 - 클래스를 통해 만들어내는 실제 객체를 인스턴스(instance)라고 부른다 - 클래스를 통해
	 * 새로운 인스턴스를 생성할 때 new를 사용한다
	 * 
	 */
	public static void main(String[] args) {

		// Book 클래스의 인스턴스를 3개 생성했다
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();

		// 생성된 인스턴스에 .을 찍고 해당 클래스의 변수와 메서드를 사용할 수 있다

		// 책들마다 각자의 현재 상태를 다르게 설정할 수 있다
		b1.maxPage = 100;
		b1.currentPage = 37;

		b2.maxPage = 200;
		b2.currentPage = 3;

		b3.used = true;

		b1.printBookInfo();
		b2.printBookInfo();
		b3.printBookInfo();

		// 클래스에 정의한 메서드로 각 인스턴스를 변화시킬 수 있다

		for (int i = 0; i < 100; ++i) {
			b1.nextPage();
			b2.prevPage();
		}
		b1.printBookInfo();
		b2.printBookInfo();
		b3.printBookInfo();

		Iphone i1 = new Iphone();
		Iphone i2 = new Iphone();
		Iphone i3 = new Iphone();

		i1.fullcount = 99;
		i2.fullcount = 30;

		i1.battery = 90;
		i2.battery = 0;
		i3.battery = 70;

		i1.iphoneInfo();
		i2.iphoneInfo();
		i3.iphoneInfo();

		for (int i = 0; i < 30; i++) {
			i1.chargingBattery();
			i2.chargingBattery();
			i3.usingPhone();

		}

		i1.iphoneInfo();
		i2.iphoneInfo();
		i3.iphoneInfo();

		Vehicle v1 = new Vehicle();
		Gun g1 = new Gun();

		v1.price = 50000000;
		v1.gun = g1;
		v1.gun.bullet = 30;
		for (int i = 0; i < 10; ++i) {
			v1.gun.fire();
		}

		System.out.println(v1.getGrade());

	}
}

// 책 클래스 (설계도)
class Book {
	// 두 가지의 변수(현재 상태, 필드 = 멤버 변수,인스턴스 변수...)를 가지고 있다
	int maxPage;
	int currentPage;
	boolean used;
	String[] contents;

	// 클래스의 인스턴스 변수는 배열처럼 자동으로 초기화가 되어있다
	// int - 0, float, double - 0.0, boolean - false ...

	// 클래스 내부의 함수(메서드)
	// - 주로 현재 인스턴스(this)의 상태를 변화시키는 역할을 한다
	void nextPage() {
		if (this.currentPage < this.maxPage) {
			++this.currentPage;
		} else {
			System.out.println("[Warning] 이미 맨 뒤 페이지입니다.");

		}
	}

	void prevPage() {
		if (this.currentPage > 0) {
			--this.currentPage;
		} else {
			System.out.println("[Warning] 이미 맨 앞 페이지입니다.");
		}
	}

	void printBookInfo() {
		System.out.printf("현재 책 상태 : %d/%d(%s)\n", this.maxPage, this.currentPage, this.used ? "중고" : "새제품");
	}
}

/*
 * 
 * 실제로 존재하는 현실의 객체를 하나 참고하여 클래스를 생성한 후 해당 클래스의 인스턴스를 생성하고 각 인스턴스의 상태를 출력해보세요
 * (인스턴스 3개 이상, 필드 3개 이상, 메서드 2개 이상, 책 X)
 * 
 * 
 */

class Iphone {
	int battery;
	int power;
	int batteryEfficiency;
	int fullcount;
	int info;
	boolean charging;

	void chargingBattery() {
		if (this.battery < 100) {
			++this.battery;
			charging = true;
		} else if (this.battery == 100) {
			System.out.println("충전이 완료되었습니다.");
			++fullcount;
		}
	}

	void usingPhone() {
		if (this.battery > 0) {
			--this.battery;
		} else if (this.battery == 0) {
			System.out.println("배터리가 없어 종료합니다.");
		}
	}

	void iphoneInfo() {
		System.out.printf("현재 배터리 상태[%d] %s\n", this.battery, this.charging ? "충전중입니다" : "사용중입니다");
	}

//	boolean batteryEfficiency() {
//		if (fullcount == 100) {
//			this.batteryEfficiency = 0;
//			System.out.println("핸드폰 배터리의 수명이 다했습니다.");
//		}
//	}

}

class Gun {
	String name;
	int damage;
	int bullet;
	double attackSpeed;

	void fire() {
		if (bullet > 0) {
			System.out.printf("총을 발사했습니다 %d/30\n", --bullet);
		}
	}
}

class Vehicle {

	Gun gun;
	int price;
	String name;
	int fuel;

	void addFuel(int liter) {
		this.fuel += liter;
	}

	String getGrade() {
		if (price > 100000000) {
			return "세단";
		} else if (price > 80000000) {
			return "중형";
		} else {
			return "소형";
		}
	}
}