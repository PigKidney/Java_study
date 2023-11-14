package myobj.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack extends TrumpCard {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> ownCard = new ArrayList<>();
	ArrayList<String> comCard = new ArrayList<>();
	boolean hit = true;
	boolean burst = false;
	boolean playerWin = false;
	int winCount = 0;
	int playTime = 0;
	
	private void drowCard() {
		getAllTrumpCard();
		for (int turn = 0; turn < 4; turn++) {
			if (turn < 2) {
				ownCard.add(cardAlltypeList.get(turn));
			} else if (turn < 4) {
				comCard.add(cardAlltypeList.get(turn));
			}
		}
		System.out.println("my card : " + ownCard);
		System.out.println("com card : [" + comCard.get(0) + " ?? ]\n");
		System.out.println("my start point [" + chkCard(ownCard)+"]\n");
	}

	public void hitOrStand() {
		int turn = 4;
		while (hit) {
			System.out.println("♠ · ◇ · ♣ · ♡ · ♠ · ◇ · ♣ · ♡\n");
			System.out.println("Hit or Stand => "); 
			String ans = sc.next();
			ans = ans.toUpperCase();
			if (ans.charAt(0) == 'H') { 
				ownCard.add(cardAlltypeList.get(turn));
				++turn;
				System.out.println("my card : " + ownCard);
				System.out.println("com card : [" + comCard.get(0) + "]\n");
				System.out.println("my point [" + chkPlayerCard()+"]\n");
			} else if (ans.charAt(0) == 'S') { 
				hit = false;
			} else if (ans.charAt(0) != 'H' && ans.charAt(0) != 'S') { 
				System.out.println("잘못된 입력입니다.");
			}
		}
		if (burst) {
			System.out.println("사용자의 버스트로 게임이 패배하였습니다");
		} else {
			comDrowCard();
			System.out.println("my point [" + chkPlayerCard()+"]\n");
			winChk();
			if (playerWin) {
				winCount++;
				System.out.println("player win!\n");
			} else if (chkCard(ownCard) == chkCard(comCard)) {
				System.out.println("Push\n");
			} else {
				System.out.println("com win!\n");
			}
		}
	}

	private int chkPlayerCard() {
		int total = chkCard(ownCard);
		if (total == 21) {
			hit = false;
		} else if (total > 21) {
			System.out.println("Com win\n");
			burst = true;
			hit = false;
		}
		return total;
	}

	private int chkCard(ArrayList<String> name) { //point
		int total = 0;
		for (int i = 0; i < name.size(); i++) {
			if (name.get(i).length() == 2) {
				if (name.get(i).charAt(1) == '1' && total < 21) {
					total += name.get(i).charAt(1) - '0' + 10;
				} else {
					total += name.get(i).charAt(1) - '0';
				}
			} else if (name.get(i).length() == 3) {
				total += 10;
			}
		}
		return total;
	}

	private void comDrowCard() {
		int total = chkCard(comCard);
		int turn = ownCard.size() + 2;
		System.out.println("com card : " + comCard);
		while (turn < 52) {
			if (total < 17) {
				comCard.add(cardAlltypeList.get(turn));
				++turn;
				total = chkCard(comCard);
			} else if (total >= 17 && total <= 21) {
				break;
			} else if(total > 21) {
				break;
			}
			System.out.println("com card : " + comCard);
		}
		System.out.println("Com point [" + total + "]\n");
	}

	private void winChk() {
		if (chkCard(comCard) > 21) {
			playerWin = true;
		} else if (chkCard(ownCard) != chkCard(comCard)) {
			playerWin = chkCard(ownCard) > chkCard(comCard);
		} 
	}

	private String manual() {
		return "Blackjack\n두 장의 카드 합이 21일 경우를 말한다.\n카드합으로 나올 수 있는 최대치"
				+ "\n\nBust\n카드 합이 21을 초과하여 게임에서 패배합니다."
				+ "\n\nPush\n플레이어와 딜러의 각각의 카드 합이 같을 경우 서로 비기게 됩니다."
				+ "\n\nStay\n플레이어가 추가 카드를 원하지 않을 경우를 말하며, \n딜러는 카드의 합이 17 이상이면 추가 카드를 받을 수 없습니다"
				+ "\n\nHit\n플레이어가 처음 두 장의 카드 외에 딜러에게 추가카드를 요청하는 경우를 말합니다.";
	}
	
	private String playerInfo() {
		return "PLAY TIME ["+playTime+"]" +"  NUMBER OF WINS ["+winCount+"]";
	}
		
	private void reset() {
		ownCard = new ArrayList<>();
		comCard = new ArrayList<>();
		hit = true;
		burst = false;
		playerWin = false;
		Collections.shuffle(cardAlltypeList);
	}
		
	public void play() {
		boolean gameover = false;
		while (!gameover) {
			System.out.println("         Black Jack");
			System.out.println("♠ · ◇ · ♣ · ♡ · ♠ · ◇ · ♣ · ♡\n");
			System.out.println("1)게임 시작\n\n2)게임 방법\n\n3)플레이어 전적\n\n4)게임 종료\n");
			System.out.println("♠ · ◇ · ♣ · ♡ · ♠ · ◇ · ♣ · ♡");
			int key = sc.nextInt();
			switch (key) {
			case 1: {
				++playTime;
				drowCard();
				hitOrStand();
				reset();
				break;
			}
			case 2: {
				System.out.println(manual()+'\n'); 
				break;
			}
			case 3: {
				System.out.println(playerInfo());
				break;
			}
			case 4: {
				gameover = true;
				break;
			}
			default:
				System.out.println("[ERROR]");
			}

		}

	}
}
