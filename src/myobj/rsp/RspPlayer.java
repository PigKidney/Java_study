package myobj.rsp;

public class RspPlayer {
	String name;
	int win = 0;
	int lose = 0;
	int draw = 0;
	
	public RspPlayer(String name) {
		this.name = name;
	}
	
	public RspPlayer(String name , int winCount, int loseCount, int drawCount) {
		this.name = name;
		this.win = winCount;
		this.lose = loseCount;
		this.draw = drawCount;
	}
	
	public int getDraw() {
		return draw;
	}
	
	public int getLose() {
		return lose;
	}
	
	public int getWin() {
		return win;
	}
	
	public void wincheck(String userRsp , String comRsp) {
		if(userRsp.equals("바위")) {
			if(userRsp.equals(comRsp)) {
				draw++;
				System.out.println("비겼습니다");
			} else if (comRsp.equals("가위")) {
				win++;
				System.out.println("이겼습니다");
			} else {
				lose++;
				System.out.println("졌습니다");
			}
		} else if(userRsp.equals("가위")) {
			if(userRsp.equals(comRsp)) {
				draw++;
				System.out.println("비겼습니다");
			} else if (comRsp.equals("보")) {
				win++;
				System.out.println("이겼습니다");
			} else {
				lose++;
				System.out.println("졌습니다");
			}
		} else if(userRsp.equals("보")) {
			if(userRsp.equals(comRsp)) {
				draw++;
				System.out.println("비겼습니다");
			} else if (comRsp.equals("바위")) {
				win++;
				System.out.println("이겼습니다");
			} else {
				lose++;
				System.out.println("졌습니다");
			}
		}
		
	}


	@Override
	public String toString() {
		return String.format("[%s : 승 [%d] / 패 [%d] / 무 [%d]]",name,win,lose,draw) ;
	}
}
