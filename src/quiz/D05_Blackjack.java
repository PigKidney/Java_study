package quiz;

import java.util.Scanner;

import myobj.blackjackT.Card;
import myobj.blackjackT.CardDeck;
import myobj.blackjackT.Player;

public class D05_Blackjack {
	/*
	 
	  	# 블랙잭을 만들어보세요 (http://www.247blackjack.com)
	  
	  1. 컴퓨터(딜러)와 사람(플레이어)이 카드를 뽑는다
	  
	  2. 처음에는 둘 모두 2장씩 받는다. 이 때 딜러의 카드는 한장 가려 놓는다.
	  
	  3. 플레이어는 받은 카드를 보고 더 뽑을지(Hit) 그만 뽑고 여기서 멈출지(Stand)를 결정해야 한다.
	  	 hit를 선택하면 플레이어만 카드를 한 장 더 받는다.
	  	 
	  4. 플레이어가 stand를 선택하면 딜러가 가려놨던 카드를 오픈하고 정해진 규칙에 따라 카드를 계속 뽑는다.
	     딜러는 의사결정을 할 수 없고 정해진 규칙에만 따라야 한다.
	     
	     딜러의 규칙 - 가진 카드의 합이 16이하라면 뽑는다. 17 이상이면 멈춘다.
	     
	  
	  5. J, Q, K는 모두 10의 가치를 지닌다
	  
	  6. A는 1이나 11 중 선택해서 사용가능하다. (A는 처음에는 11의 가치를 가지고 있다가 버스트를 당하면 1로 바뀔 수 있다)
	  
	  7. 가진 카드 가치의 합이 21을 넘으면 버스트.
	     21을 딱 맞추면 블랙잭. 21을 맞추고나면 hit가 불가능하고 딜러가 바로 카드를 뽑는다.
	     플레이어가 버스트를 당하면 딜러는 카드를 뽑지도 않고 승리한다.
	 */
	
	public static void main(String[] args) {
		CardDeck deck = Card.getDeck(3);
	
		
		Player player = new Player("철수");
		Player dealer = new Player("딜러");
		
		Scanner sc = new Scanner(System.in);
		
		player.addCard(deck.draw());
		dealer.addCard(deck.draw());
		player.addCard(deck.draw());
		dealer.addCard(deck.draw());
		dealer.hide(0);
		
		while (true) {
			System.out.println(player);
			System.out.println("-- 플레이어 --");
			player.showHands();
			System.out.println("플레이어 패의 가치 : "+ player.getHandValue());
			System.out.println("-- 딜러 --");
			dealer.showHands();
			
			System.out.print("1. Hit\n2. Stand\n>>");
			int select = sc.nextInt();
			
			if(select == 1) {
				player.addCard(deck.draw());
				int value = player.getHandValue();
				if(value == -1 || value == 21) {
					break;
				}
			} else if (select == 2) {
				break;
			} else {
				System.out.println("[Warning] 1번 또는 2번을 선택해주세요");
			}
		}
		int playerHandValue = player.getHandValue();
		if(playerHandValue == -1) {
			player.showHands();
			System.out.println("플레이어의 버스트로 패배!");
			return;
		}
		
		int v;
		while ((v=dealer.getHandValue()) < 17 && v != -1) {
			dealer.addCard(deck.draw());
		}
		dealer.open(0);
		
		
		int dealerHandValue = dealer.getHandValue();
		
		System.out.println("## 결과 ##");
		player.showHands();
		System.out.println("플레이어 패의 가치 : "+ player.getHandValue());
		dealer.showHands();
		System.out.println("딜러 패의 가치 : "+ dealer.getHandValue());
		
		if(dealerHandValue == -1) {
			System.out.println("딜러의 버스트로 플레이어의 승리!");
		} else if(playerHandValue == dealerHandValue) {
			System.out.println("무승부!");
		} else if (playerHandValue > dealerHandValue) {
			System.out.println("플레이어의 승리!");
		} else if (playerHandValue < dealerHandValue) {
			System.out.println("딜러의 승리!");
		}
		
		
//		for(int i = 0 ; i < 1000 ; i ++) {
//			System.out.println(i+"번째 드로우 : "+deck2.draw());
//		}
	}
}
