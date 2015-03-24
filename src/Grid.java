
public class Grid {
	
	private int[][] grid;
	
	public Grid(int x, int y) {
		grid = new int[x][y];
	}
	
	public int[][] getGrid() {
		return grid;
	}
	
	public int shoot(int x, char c) {
		int y = intToChar(c);
		if (!inBounds(x, intToChar(c))) {
			return 0;
		}
		if (grid[x][y] < 2) {
			grid[x][y] =+ 2;
			return grid[x][y];
		} else {
			return 0;
		}
	}
	
	public int charToInt(char c) {
		String all = "abcdefghijklmnopqrstuvwxyz";
		int y = -1;
		for (int i = 0; i < all.length(); i++) {
			if (c == all.charAt(i)) {
				y = i;
			}
		}
		return y;
	}
	public char intToChar(int y) {
		String all = "abcdefghijklmnopqrstuvwxyz";
		char c = 0;
		if (y >= 0 && y < all.length()) {
			c = all.charAt(y);
		}
		return c;
	}
	
	public boolean inBounds(int x, int y) {
		if (x < grid[0].length && x >= 0 && y < grid.length && y >= 0) {
			return true;
		}
		return false;
	}
	
}
