
public class Boat {

	private int size = 0;
	private int xPos;
	private int yPos;
	private int dir;
	private Grid grid;
	private int[][] coords;
	
	public Boat(int l, int x, int y, int d, Grid g) {
		grid = g;
		if (checkParams(l, x, y, d)) {
			size = l;
			xPos = x;
			yPos = y;
			dir = d;
			makeCoords(l, x, y, d);
		}
	}
	
	private boolean checkParams(int l, int x, int y, int d) {
		if (l < 2 || l > 5) {
			System.out.println("Can't create boat: illegal length");
			return false;
		} else if (!grid.inBounds(x, y)) {
			System.out.println("Can't create boat: invalid location");
			return false;
		} else if (!goodDir(l, x, y, d)) {
			System.out.println("Can't create boat: bad direction");
			return false;
		} else if(overBoat(l, x, y, d)) {
			System.out.println("Can't create boat: overlaps other boat(s)");
		}
		return true;
	}
	
	private boolean goodDir(int l, int x, int y, int d) {
		if (d == 1) {
			return y-l+1 >= 0; 
		} else if (d == 2) {
			return x+l-1 < grid.getGrid()[0].length; 
		} else if (d == 3) {
			return y+l-1 < grid.getGrid().length;
		} else if (d == 4) {
			return x-l+1 >= 0;
		} else {
			return false;
		}
	}
	
	private void makeCoords(int l, int x, int y, int d) {
		if (d == 1) {
			for (int i = 0; i < l; i++) {
				coords[0][i] = x;
				coords[1][i] = y+i;
				coords[2][i] = 1;
			}
		} else if (d == 2) {
			for (int i = 0; i < l; i++) {
				coords[0][i] = x+i;
				coords[1][i] = y;
				coords[2][i] = 1;
			}
		} else if (d == 3) {
			for (int i = 0; i < l; i++) {
				coords[0][i] = x;
				coords[1][i] = y-i;
				coords[2][i] = 1;
			}
		} else if (d == 4) {
			for (int i = 0; i < l; i++) {
				coords[0][i] = x-i;
				coords[1][i] = y;
				coords[2][i] = 1;
			}
		}
	}
	
	public void markHit(int x, int y) {
		for (int i = 0; i < getSize(); i++) {
			if (coords[0][i] == x && coords[1][i] == y) {
				coords[2][i] = 0;
			}
		}
	}
	
	private boolean overBoat(int l, int x, int y, int d) {
		int[][] temp = new int[2][l];
		if (d == 1) {
			for (int i = 0; i < l; i++) {
				temp[0][i] = x;
				temp[1][i] = y+i;
			}
		} else if (d == 2) {
			for (int i = 0; i < l; i++) {
				temp[0][i] = x+i;
				temp[1][i] = y;
			}
		} else if (d == 3) {
			for (int i = 0; i < l; i++) {
				temp[0][i] = x;
				temp[1][i] = y-i;
			}
		} else if (d == 4) {
			for (int i = 0; i < l; i++) {
				temp[0][i] = x-i;
				temp[1][i] = y;
			}
		}
		if (this.compareCoords(temp)) {
			return true;
		}
		return false;
	}
	
	private boolean compareCoords(int[][] b) {
		for (int i = 0; i < b.length; i++) {
			if (grid.getGrid()[ b[0][i] ] [ b[1][i] ] == 1) {
				return true;
			}
		}
		return false;
	}
	
	public double boatHealth() {
		int h = 0;
		for (int i = 0; i < size; i++) {
			if (coords[2][i] == 1) {
				h++;
			}
		}
		return h/size;
	}
	
	public int[][] getCoords() {
		return coords;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
 	
	public int getDir() {
		return dir;
	}
	
}
