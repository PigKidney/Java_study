package myobj.school;

public class SubLiberal extends Subject{
	int kor;
	int eng;
	int math1;
	int koreaHistory;
	int morality;
	int worldHistory;
	
	static int getRandomScore() {
		return (int)(Math.random()*101);
	}
	
	//기본 생성자로 만들면 과목 점수를 랜덤으로 채워준다
	public SubLiberal() {
		kor = getRandomScore();
		eng = getRandomScore();
		math1 = getRandomScore();
		koreaHistory = getRandomScore();
		morality = getRandomScore();
		worldHistory = getRandomScore();
	}
	
	@Override
	public double getAvg() {
		return getTotal()/6.0;
	}
	
	@Override
	public int getTotal() {
		return (kor + eng + math1 + koreaHistory + morality + worldHistory);
	}
	
	@Override
	public String getGrade() {
		double avg = getAvg();
		if(avg >= 90) {
			return "A";
		} else if(avg >= 80) {
			return "B";
		} else if(avg >= 70) {
			return "C";
		} else if(avg >= 60) {
			return "D";
		} else {
			return "F";
		}
	}
	
	@Override
	public void printScores() {
		System.out.println("국어\t영어\t수1\t국사\t도덕\t세계사\n");
		System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\n",kor,eng,math1,koreaHistory,morality,worldHistory);
	}
}
