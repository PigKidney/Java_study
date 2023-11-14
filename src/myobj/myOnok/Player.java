package myobj.myOnok;

public class Player{
	String name;
	char color;
	int chance ;
	int winCount = 0;
	
	
	public Player(String name , char color , int chance) {
		this.name = name;
		this.color = color;
		this.chance = chance;
	}
	
	public Player(String name , char color ) {
		this.name = name;
		this.color = color;
		this.chance = 1;
	}
	
	@Override
	public String toString() {
		return name+"의 남은 무르기 기회 : "+chance;
	}
	
	public void info() {
		System.out.printf("%f : 승리[%d회] 남은무르기[%d회]",name,winCount,chance);
	}
	
	
	public String getName() {
		return name;
	}
	
	public char getColor() {
		return color;
	}

}
