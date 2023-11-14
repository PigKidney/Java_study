package myobj.yacht;

import java.util.ArrayList;
import java.util.HashSet;

public class Player{
	String name;
	int winCount;
	ArrayList<Integer> numList = new ArrayList<>();
	HashSet<Integer> numSet = new HashSet<>();
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
