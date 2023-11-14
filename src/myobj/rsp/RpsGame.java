package myobj.rsp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RpsGame {
	final private static String[] SHAPE_LABELS = {"바위", "가위", "보"};
	final public static int ROCK = 0;
	final public static int SCISSORS = 1;
	final public static int PAPER = 2;
	
	private int win;
	private int lose;
	private int draw;
	
	
	public RpsGame() {
		try {
			FileInputStream in = new FileInputStream("myfiles/record.sav");
			
			byte[] arr = new byte[4];
			
			in.read(arr);
			win = byteArrayToInt(arr);
			in.read(arr);
			draw = byteArrayToInt(arr);
			in.read(arr);
			lose = byteArrayToInt(arr);
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fight(int shape) {
		int userShape = shape;
		int comShape = (int)(Math.random()*3);
		
		System.out.println("YOU\t\tCOM");
		System.out.printf("%s\tVS\t%s\n",SHAPE_LABELS[userShape],SHAPE_LABELS[comShape]);
		
		if((userShape + 1) % 3 == comShape) {
			System.out.print("사용자가 이겼습니다. ");
			++win;
		} else if ((comShape + 1) % 3 == userShape) {
			System.out.print("패배했습니다. ");
			 ++lose;
		} else {
			System.out.print("무승부입니다. ");
			++draw;
		}
		System.out.printf("사용자가 이겼습니다. (현재 %d승 %d무 %d패)\n", win, draw, lose);
	}
	
	final public static int byteArrayToInt(byte[] arr) {
		int value = 0;
		
//		for(int i = 0 ; i < arr.length; ++i) {
//			value += (arr[i] << (32 - (i + 1)*8));
//		}
		
		value |= arr[0] << 24;
		value |= (arr[1] & 0xFF) << 16;
		value |= (arr[2] & 0xFF) << 8;
		value |= (arr[3] & 0xFF);
		return value;
	}
	
	public static final byte[] inToByteArray(int value) {
		// 255승 일때 (0000 0000 / 0000 0000 / 0000 0000 / 1111 1111)
		
		// byte[]로는 {0, 0, 0, -128}
		
		return new byte[] {
				(byte)(value >>> 24),
				(byte)(value >>> 16),
				(byte)(value >>> 8),
				(byte)(value)};
	}	
	
	
	
	// 파일에 현재 전적을 기록하는 기능
	public void save() {
		try {
			FileOutputStream out = new FileOutputStream("myfiles/record.sav");
			out.write(inToByteArray(win));
			out.write(inToByteArray(draw));
			out.write(inToByteArray(lose));
			
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
