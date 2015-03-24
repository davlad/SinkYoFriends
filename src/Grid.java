
public class Grid {
	
	private int[][] grid;
	
	public Grid(int x, int y) {
		grid = new int[x][y];
	}
	
	public int[][] getGrid() {
		return grid;
	}
	
	public int shoot(int x, char y) {
		if ()
		
		
		return 1;
	}
	
	public int charToInt(char y) {
		String all = "abcdefghijklmnopqrstuvwxyz";
		int index = -1;
		for (int i = 0; i < all.length(); i++) {
			if (y == all.charAt(i)) {
				index = i+1;
			}
		}
		return index;
	}
	public char intToChar(int y) {
		String all = "abcdefghijklmnopqrstuvwxyz";
		char c = 0;
		if (y > 0 && y <= all.length()) {
			c = all.charAt(y-1);
		}
		return c;
	}
	
	public boolean inBounds(int x, int y) {
		if (x <= grid[0].length && x > 0 && y <= grid.length && y > 0) {
			return true;
		}
		return false;
	}
	
}
