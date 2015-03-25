
public class Boat {

	private int length;
	private int xPos;
	private int yPos;
	private int dir;
	
	public Boat(int l, int x, int y, int d, Grid g) {
		if (checkParams(l, x, y, d, g)) {
			length = l;
			xPos = x;
			yPos = y;
			dir = d;
		}
	}
	
	private boolean checkParams(int l, int x, int y, int d, Grid g) {
		if (l < 2 || l > 5) {
			System.out.println("Can't create boat: illegal length");
			return false;
		} else if (!g.inBounds(x, y)) {
			System.out.println("Can't create boat: invalid location");
			return false;
		} else if (!goodDir(l, x, y, d, g)) {
			System.out.println("Can't create boat: bad direction");
			return false;
		} else if() {
			System.out.println("Can't create boat: overlaps other boat(s)");
		} else {
			return true;
		}
	}
	
	private boolean goodDir(int l, int x, int y, int d, Grid g) {
		if (d == 1) {
			return y-l+1 >= 0; 
		} else if (d == 2) {
			return x+l-1 < g.getGrid()[0].length; 
		} else if (d == 3) {
			return y+l-1 < g.getGrid().length;
		} else if (d == 4) {
			return x-l+1 >= 0;
		} else {
			return false;
		}
	}
	
	private boolean overBoat() {
		
	}
	
	
	public int getLength() {
		return length;
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
