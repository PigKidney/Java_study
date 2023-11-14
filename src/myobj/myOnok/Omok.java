package myobj.myOnok;

import java.util.Scanner;

public class Omok {
	Scanner sc = new Scanner(System.in);
	Player[] player = { new Player("black", '♠'), new Player("white", '○') };
	Field field = new Field(15);
	int count = 0;
	boolean win = false;
	int row;
	int low;

	private void turn() {
		int turn = count % 2;

		System.out.printf("[%d번째] %s의 차레입니다.\n", count + 1, player[turn].getName());
		System.out.println("알파벳을 입력하세요 > ");
		String chk = sc.next();
		int rowNum = chk.charAt(0);
		if (rowNum == 'Z' && player[turn].chance > 0) {
			getChance();

		} else {
			low = chk.charAt(0) - 'A';
			System.out.println("숫자를 입력하세요 > ");
			this.row = sc.nextInt();
			if (field.map[row][low] != '┼' || field.map[row][low] == player[turn].getColor()) {
				--count;
				System.out.println("이미 위치에 다른 말이 위치해있습니다.");
			} else {
				field.map[row][low] = player[turn].getColor();
			}
			field.print();
			chkWin(row, low);
			if (win) {
				player[turn].winCount += 1;
				System.out.println(player[turn].getName() + "의 " + player[turn].winCount + "번째 승리입니다.");
			}
		}
		count++;

	}

	private boolean chkWin(int row, int low) {
		char chkColor = field.map[row][low];
		int bulk = field.size;
		// 가로
		for (int i = 0; i < bulk - 4; i++) {
			for (int j = 0; j < bulk; j++) {
				if (field.map[i][j] == chkColor && field.map[i + 1][j] == chkColor && field.map[i + 2][j] == chkColor
						&& field.map[i + 3][j] == chkColor && field.map[i + 4][j] == chkColor ) {
					win = true;
				}
			}
		}
		// 세로
		for (int j = 0; j < bulk - 4; j++) {
			for (int i = 0; i < bulk; i++) {
				if (field.map[i][j] == chkColor && field.map[i][j + 1] == chkColor && field.map[i][j + 2] == chkColor
						&& field.map[i][j + 3] == chkColor && field.map[i][j + 4] == chkColor) {
					win = true;
				}
			}
		}
		// 1->3
		for (int i = 0; i < bulk - 4; i++) {
			for (int j = 0; j < bulk - 4; j++) {
				if (field.map[i][j] == chkColor && field.map[i + 1][j + 1] == chkColor
						&& field.map[i + 2][j + 2] == chkColor && field.map[i + 3][j + 3] == chkColor
						&& field.map[i + 4][j + 4] == chkColor) {
					win = true;
				}
			}
		}
		// 4->2
		for (int i = 0; i < bulk - 4; i++) {
			for (int j = 0; j < bulk - 4; j++) {
				if (field.map[bulk - i - 1][j] == chkColor && field.map[bulk - i - 2][j + 1] == chkColor
						&& field.map[bulk - i - 3][j + 2] == chkColor && field.map[bulk - i - 4][j + 3] == chkColor
						&& field.map[bulk - i - 5][j + 4] == chkColor) {
					win = true;
				}
			}
		}
		return !win;

	}

	public void play() {
		boolean end = false;

		while (!end) {
			System.out.println("1)게임 시작\n2)게임설명 & 유저 정보확인\n3)게임종료");
			int user = sc.nextInt();

			switch (user) {
			case 1:
				field.print();
				while (!win) {
					turn();
				}
				field = new Field(15);
				break;
			case 2:
				System.out.println("1)오목게임 설명\n2)유저 정보확인");
				info(sc.nextInt());
				break;
			case 3:
				end = true;
			default:
				break;
			}

		}

	}

	private void getChance() {
		int turn = count % 2;
		player[turn].chance -= 1;
		count -= 2;
		field.map[row][low] = '┼';
		field.print();
	}

	private void info(int select) {

		switch (select) {
		case 1:
			System.out.println("플레이 방법\n" + "--------------------------------------------\n"
					+ "플레이어가 서로 번갈아가며 말을 놓아 5개가 연속으로 놓이면 이기는 게임입니다."
					+ "\n단 말을 놓을때 6개가 되면 승리하지 못하고 또한 3x3형태가 되게 놓지 못합니다."
					+ "\n그리고 플레이어는 무르기를 사용하실 수 있는데 상대방의 수를 한 수 무르게 할 수있는 기능입니다"
					+ "\n무르기 사용 방법은 자신의 턴에 Z(대문자)를 입력하면 사용가능합니다.\n");
			break;
		case 2:
			System.out.println("확인하고 싶은 유저 이름을 입력해주세요 > ");
			
			for (int i = 0 ; i < player.length ; i++) {
				System.out.println(i + ") "+player[i].getName());
			}
			
			int whoPlayer = sc.nextInt();
			System.out.println(player[whoPlayer].getName() + " : [" + player[whoPlayer].winCount + "회 승리] "
					+ "남은 무르기 기회 [" + player[whoPlayer].chance +  "회]\n");
			break;

		}

	}

}