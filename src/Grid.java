
public class Grid {
	
	private int[][] grid;
	
	public Grid(int w, int h) {
		grid = new int[w][h];
		for (int x = 0; x < grid[0].length; x++) {
			for (int y = 0; y < grid.length; y++) {
				grid[x][y] = 0;
			}
		}
	}
	
	public int[][] gridData() {
		return grid;
	}
	
	public void makeBoat(Boat b) {
		int[][] coords = b.getCoords();
		for (int i = 0; i < b.getCoords()[0].length; i++) {
			int x = coords[0][i];
			int y = coords[1][i];
			grid[x][y] = 1;
		}
	}
	
	public int shot(int x, int y) {
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
