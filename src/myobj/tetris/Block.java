package myobj.tetris;

import java.util.Scanner;

public class Block {
	final int MAX_HEIGHT = 4;
	final int MAX_WIDTH = 4;
	Scanner sc = new Scanner(System.in);
	char[][] L = { { '□', '□', '□', '□' }, { '□', '■', '□', '□' }, { '□', '■', '□', '□' }, { '□', '■', '■', '□' }

	};

	char[][] I = { { '□', '□', '□', '■' }, { '□', '□', '□', '■' }, { '□', '□', '□', '■' }, { '□', '□', '□', '■' }

	};

	char[][] T = { { '□', '□', '□', '□' }, { '□', '□', '□', '□' }, { '□', '■', '□', '□' }, { '■', '■', '■', '□' }

	};

	char[][] S = { { '□', '□', '□', '□' }, { '□', '□', '□', '□' }, { '□', '■', '■', '□' }, { '■', '■', '□', '□' }

	};

	char[][] Z = { { '□', '□', '□', '□' }, { '□', '□', '□', '□' }, { '■', '■', '□', '□' }, { '□', '■', '■', '□' }

	};

	char[][] J = { { '□', '□', '□', '□' }, { '□', '□', '■', '□' }, { '□', '□', '■', '□' }, { '□', '■', '■', '□' }

	};

	char[][] O = { { '□', '□', '□', '□' }, { '□', '□', '□', '□' }, { '□', '■', '■', '□' }, { '□', '■', '■', '□' }

	};

	char dropShape[][];
	
//	enum Type {
//		 Empty,
//		 Up,
//		 Down,
//		 ..
//	}
	

	public char[][] getRandom() {
		char[][][] shape = { T, L, S, Z, O, I, J };
		int num = (int) (Math.random() * shape.length);
		dropShape = shape[num];

		return dropShape;
	}

	public void getShape(char[][] shape) {

		for (int i = 0; i < MAX_HEIGHT; i++) {
			for (int j = 0; j < MAX_WIDTH; j++) {
				System.out.print(shape[i][j]);
			}
			System.out.println();
		}
		dropShape = shape;
	}

	public char[][] getDropShape() {
		return dropShape;
	}

	public void turn90(char[][] shape) {
		for (int i = MAX_HEIGHT - 1; i >= 0; i--) {
			for (int j = 0; j < MAX_WIDTH; j++) {
				System.out.print(shape[j][i]);
			}
			System.out.println();
		}
		dropShape = shape;
	}
	
	public void turn180(char[][] shape) {
		for (int i = MAX_HEIGHT - 1; i >= 0; i--) {
			for (int j = MAX_WIDTH -1; j >= 0; j--) {
				System.out.print(shape[i][j]);
			}
			System.out.println();
		}
		dropShape = shape;
	}
	
	public void turn270(char[][] shape) {
		for (int i = 0; i < MAX_HEIGHT; i++) {
			for (int j = MAX_WIDTH -1; j >= 0; j--) {
				System.out.print(shape[j][i]);
			}
			System.out.println();
		}
		dropShape = shape;
	}
	
	public void spin(int turnTime) {
		if(turnTime%4==0) {
			getShape(dropShape);
		} else if(turnTime%4==1) {
			turn90(dropShape);
		} else if(turnTime%4==2) {
			turn180(dropShape);
		} else if(turnTime%4==3) {
			turn270(dropShape);
		}
	}
	
	public void getSpin() {
		int spinCount = 0;
		while(true) {
			String userPut = sc.next();
			userPut = userPut.toUpperCase();
			if(userPut.charAt(0)=='A') {
				spinCount++;
			}
			spin(spinCount);
		}
	}
}
