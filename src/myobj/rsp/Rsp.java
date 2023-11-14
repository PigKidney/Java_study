package myobj.rsp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Rsp {
	final static String[] RSP = { "바위", "가위", "보" };
	Pattern domainPattern = Pattern.compile("승 [(.+)] / 패 [(.+)] / 무 [(.+)]");
	RspPlayer[] player;

	public String getRanRSP() {
		return RSP[(int) (Math.random() * RSP.length)];
	}

	public void play(String name) throws isAnsRsp {
		Scanner sc = new Scanner(System.in);
		Scanner nc = new Scanner(System.in);
		RspPlayer p1 = new RspPlayer(name); 
		boolean keepPaly = true;
		while(keepPaly) {
			System.out.println("1)가위 바위 보!\n2)플레이어 전적\n3)세이브\n4)불러오기\n5)게임종료");
			switch (sc.nextInt()) {
			case 1 :
				boolean duel = true;
				while(duel) {
					try {
						System.out.println("가위! 바위! 보! >");
						String userRsp = nc.nextLine();
						if(!userRsp.equals("가위") && !userRsp.equals("바위") && !userRsp.equals("보")) {
							throw new isAnsRsp();
						} else {
							String comAns = getRanRSP();
							System.out.println(comAns);
							p1.wincheck(userRsp ,comAns);
							duel = false;
						}
					} catch(isAnsRsp e) {
						System.out.println("'가위' '바위' '보' 중에 입력하세요");
					} 
				}
				break;
			case 2 :
				System.out.println(p1.toString());
				break;
			case 3 :
				try {
					FileOutputStream out = new FileOutputStream("myfiles/rsp_save.txt");
					out.write(p1.toString().getBytes());
					out.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4 :
				try {
					FileInputStream in = new FileInputStream("myfiles/rsp_save.txt");
					String userData = new String(in.readAllBytes());
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				break;
			case 5 :
				keepPaly = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}

	
	public void loadUserData(String name) {
		
		
	}
	
}



class isAnsRsp extends RuntimeException {
	public isAnsRsp() {
		super("'가위' '바위' '보' 중에 입력하세요");
	}
}