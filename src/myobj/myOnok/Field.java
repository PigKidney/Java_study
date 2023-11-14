package myobj.myOnok;

public class Field {
	int size;
	char[][] map;
	

	Field(int size) {
		this.size = size;
		map = new char[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				map[row][col] = '┼';
			} 
		}
	}

	public void print() {
		System.out.print("  ");
		for (char i = 'A', j = 0; j < size; i++, j++) {
			System.out.printf(" %c", i);
		}
		System.out.println();
		for (int row = 0; row < size; row++) {
			System.out.printf("%2d", row);
			for (int col = 0; col < size; col++) {
				System.out.print(" " + map[row][col]);
			}
			System.out.println();
		}

	}


	
}
