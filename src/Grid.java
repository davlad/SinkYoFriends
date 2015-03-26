
public class Grid {
	
	private int[][] grid;
	
	public Grid(int x, int y) {
		grid = new int[x][y];
	}
	
	public int[][] getGrid() {
		return grid;
	}
	
	public void makeBoat(Boat b) {
		int[][] coords = b.getCoords();
		for (int i = 0; i < b.getCoords()[0].length; i++) {
			grid[ coords[0][i] ] [ coords[1][i] ] = 1;
		}
	}
	
	public int shoot(int x, int y) {
		if (!inBounds(x, y)) {
			return 0;
		}
		if (grid[x][y] < 2) {
			grid[x][y] =+ 2;
			return grid[x][y];
		} else {
			return 0;
		}
	}
	
	
	public boolean inBounds(int x, int y) {
		if (x < grid[0].length && x >= 0 && y < grid.length && y >= 0) {
			return true;
		}
		return false;
	}
	
}
