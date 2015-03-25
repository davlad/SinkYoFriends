
public class Boat {

	private int length;
	private int xPos;
	private int yPos;
	private int dir;
	
	public Boat(int l, int x, int y, int d, Grid g) {
		
		checkParams(l, x, y, d, g);
	}

	private void checkParams(int l, int x, int y, int d, Grid g) {
		if (l < 2 || l > 5) {
			System.out.println("Can't crate boat: illegal length");
		} else if (!g.inBounds(x, y)) {
			
		}
		
	}
	
}
