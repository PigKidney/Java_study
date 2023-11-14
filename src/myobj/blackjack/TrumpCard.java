package myobj.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TrumpCard {
	String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
	char[] shapes = {'♠','◇','♣','♡'};
	HashSet<String> cardAlltype= new HashSet<>();
	ArrayList<String> cardAlltypeList= new ArrayList<>();
	
	public String getCard(){
		String num = nums[(int)(Math.random()*13)];
		char shape = shapes[(int)(Math.random()*4)];
		return shape+num;
	}
	
	public void getAllTrumpCard() {
		while(cardAlltype.size()<52) {
			cardAlltype.add(getCard());
		}
		cardAlltypeList.addAll(cardAlltype);
		Collections.shuffle(cardAlltypeList);
	}
}
