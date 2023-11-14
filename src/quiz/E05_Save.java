package quiz;

import myobj.rsp.RpsGame;
import myobj.rsp.RspPlayer;

public class E05_Save {
	
RspPlayer[] player;


	
	
	
	
	
	public static void main(String[] args) {
		/*
	 	컴퓨터와 진행하는 간단한 가위바위보 게임을 만든 후
	 	프로그램 종료시 전적을 파일에 저장하고
	 	프로그램 실행시에는 파일에 저장된 전적 데이터를 읽어서
	 	예전 전적이 그대로 이어지도록 만들어보세요
		 */
//		Rsp g1 = new Rsp();
//		
//		g1.play("홍길동");
		
		// 0000 0000 / 0000 0000 / 0000 0000 / 1101 1111
		byte b1 = -33;
		
		// byte 타입의 부호 비트를 값으로 취급하기 위해 0xFF를 & 연산하여 int타입 양수로 바꾼다
		System.out.println(b1 << 8);
		
//		RpsGame game = new RpsGame();
//		
//		for(int i = 0; i < 100 ; ++i) {
//			game.fight(RpsGame.ROCK);			
//		}
//		game.save();
	}
}


