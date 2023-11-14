import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class D06_Comparator {
	/*
	 * # Comparable
	 * 
	 * - 이 인터페이스를 구현한 클래스는 크기 비교가 가능해 진다
	 * 
	 * # Comparator
	 * 
	 * - 이 인터페이스를 구현할 클래스는 크기 비교의 기준이 된다
	 * 
	 * 
	 */
	 static int compareGrade(String g1, String g2) {
	      char firstCh1 = g1.charAt(0);
	      char firstCh2 = g2.charAt(0);

	      if (firstCh1 == firstCh2) {
	         int len1 = g1.length();
	         int len2 = g2.length();
	         
	         if (len1 == len2) {
	            return 0;
	         } else if (len1 > len2) {
	            return 1;
	         } else {
	            return -1;
	         }
	      } else if (firstCh1 > firstCh2) {
	         return -1;
	      } else {
	         return 1;
	      }
	   }


	public static void main(String[] args) {

		System.out.println(10 > 20);

		Grape g1 = new Grape(3300, 33, 10, "대관령양때목장", 1);
		Grape g2 = new Grape(4000, 30, 8, "김씨네포도농장", 3);

		System.out.println(g1.compareTo(g2));

		List<Integer> numbers = new ArrayList<>();
		Collections.addAll(numbers, 99, 1, 88, -9, 13, 15, 8, 3, 99, 100);
		Collections.sort(numbers);

		System.out.println(numbers);

//		List<Peach> peaches = new ArrayList<>();
//		peaches.add(new Peach());
//		peaches.add(new Peach());
//		
		// 리스트 정렬을 하기 위해서는 해당 리스트의 내용물이
		// 크기 비교의 기준이 마련되어 있는 객체여야 한다
//		Collections.sort(peaches);
		List<Grape> grapes = new ArrayList<>();

		grapes.add(new Grape(3300, 33, 10, "대관령양때목장", 1));
		grapes.add(new Grape(2300, 31, 8, "김씨네복숭아농장", 3));
		grapes.add(new Grape(3500, 29, 5, "이씨네사과농장", 1));
		grapes.add(new Grape(6300, 40, 7, "박씨네닭장", 2));
		grapes.add(new Grape(5150, 55, 8, "최가네", 1));
		grapes.add(new Grape(3000, 60, 8, "김가네", 5));

		// Comparable 인터페이스가 구현된 클래스만 sort가 가능하다
//		Collections.sort(grapes);

		Collections.sort(grapes, new GrapeNofCompartor());
		Collections.reverse(grapes);

		System.out.println(grapes);

		List<Peach> peachs = new ArrayList<>();

		peachs.add(new Peach(2000, 15.5, "A+", "김씨네목장"));
		peachs.add(new Peach(2500, 17.5, "A+", "김씨네목장"));
		peachs.add(new Peach(2000, 14.3, "A", "이씨네목장"));
		peachs.add(new Peach(2300, 16.7, "A", "김씨네목장"));
		peachs.add(new Peach(1900, 14.0, "B+", "박씨네목장"));
		peachs.add(new Peach(1950, 14.5, "B+", "박씨네목장"));
		peachs.add(new Peach(1800, 13.3, "B", "박씨네목장"));
		peachs.add(new Peach(1870, 13.7, "B", "이씨네목장"));
//		peachs.add(new Peach(77, "박씨네목장"));
//		peachs.add(new Peach(118, "이씨네목장"));
//		peachs.add(new Peach(115, "이씨네목장"));
//		peachs.add(new Peach(98, "권씨네목장"));
//		peachs.add(new Peach(50, "양씨네목장"));

//		System.out.println(peachs);

		// 연습문제 2 : 복숭아를 정렬하면 기본적으로 무게를 기준으로 내림차순 정렬되게 만들어보세요
//		Collections.sort(peachs, new PeachGradeCompartor());

		// 익명 내부 지역 클래스로 Comparator 상속받아 만들기 (추상메서드라 인스턴스화를 하지 못한다)
		Comparator<Peach> myComparator1 = new Comparator<>() {
	         @Override
	         public int compare(Peach o1, Peach o2) {
	            int result1 = compareGrade(o1.grade, o2.grade);
	            if (result1 == 0) {
	               // 등급이 완전히 같으면 도착하는 곳에서
	               // 추가로 가격을 비교해준다
	               return Integer.compare(o2.price, o1.price);
	            } else {
	               return result1;
	            }
	         }
	      };


		// 연습문제 3 : 복숭아를 등급 기준으로 오름차순 정렬하고, 등급이 같은 경우 가격 기준으로 내림차순 정렬 해보세요
		Collections.sort(peachs, myComparator1);
		System.out.println(peachs);

		// 연습문제 4 : 복숭아를 농장이름 오름차순으로 정렬하고 같은 농장인 경우 등급 기준 오름차순 정렬 해보세요.
		Collections.sort(peachs, new Comparator<Peach>() {
			@Override
			public int compare(Peach o1, Peach o2) {
				int result1 = o1.farm.compareTo(o2.farm);

				if (result1 == 0) {
					return compareGrade(o2.grade, o1.grade);
				} else {
					return result1;
				}
			}
		});

		System.out.println(peachs);

	}
}

class GrapeNofCompartor implements Comparator<Grape> {
	@Override
	public int compare(Grape o1, Grape o2) {
		if (o1.numOfFruits == o2.numOfFruits) {
			return 0;
		} else if (o1.numOfFruits > o2.numOfFruits) {
			return 1;
		} else {
			return -1;
		}
	}
}

class Grape implements Comparable<Grape> {
	int price;
	int numOfFruits;
	int sweet;
	String farm;
	int grade;

	@Override
	public String toString() {
		return String.format("[%d / %d / %d / %s / %d]\n", price, numOfFruits, sweet, farm, grade);
	}

	public Grape(int price, int numOfFruits, int sweet, String farm, int grade) {
		this.price = price;
		this.numOfFruits = numOfFruits;
		this.sweet = sweet;
		this.farm = farm;
		this.grade = grade;
	}

	@Override
	public int compareTo(Grape o) {
		// 이곳에서 현재 이스턴스와 전달되는 인스턴스의 비교 결과를 정의한다

		// 두 객체의 크기가 같다면 0을 리턴
		// 두 객체 중 현재 객체의 크기가 더 크다면 1을 리컨
		// 두 객체 중 매개변수로 전달받은 객체의 크기가 더 크면 -1을 리턴

		if (this.price == o.price) {
			return 0;
		} else if (this.price < o.price) {
			return 1;
		} else {
			return -1;
		}
	}
}
// 연습문제1 : 복숭아 클래스를 마저 정의해보세요. 
//			 복숭아는 가격, 등급, 무게, 농장이름 필드값을 가지고 있습니다.
//  		 (등급은 A+, A, B, C, D... 등 영어로 매긴다)	
// 연습문제 2 : 복숭아를 정렬하면 기본적으로 무게를 기준으로 내림차순 정렬되게 만들어보세요
// 연습문제 3 : 복숭아를 등급 기준으로 오름차순 정렬하고, 등급이 같은 경우 가격 기준으로 내림차순 정렬 해보세요
// 연습문제 4 : 복숭아를 농장이름 오름차순으로 정렬하고 같은 농장인 경우 등급 기준 오름차순 정렬 해보세요.

class Peach implements Comparable<Peach> {
	int price;
	double weight;
	String farm;
	String grade;

	public Peach(int price, double weight, String grade, String farm) {
		this.weight = weight;
		this.farm = farm;
		this.grade = grade;
		this.price = price;
	}

	public int compareTo(Peach o1) {
		// Integer, Double, String 등은 이미 Comparable이 구현된 클래스 이다
		return Double.compare(o1.weight, this.weight);
	}

	@Override
	public String toString() {
		return String.format("[%d/%.2f/%s/%s]\n", price, weight, grade, farm);
	}

	
}



