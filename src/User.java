
public class User {
	
	private Grid grid;
	private Boat[] boats;
	private int[] boatLength = new int[] {2, 3, 3, 4, 5};
	
	public User(Grid g) {
		grid = g;
	}
	
	public boolean addBoat(int l, int x, int y, int d) {
		Boat b = new Boat(l, x, y, d, grid);
		if (b.getSize() == 0 || !canMake(b)) {
			return false;
		}
		grid.makeBoat(b);
		boats[boats.length] = b;
		return true;
	}
	
	private boolean canMake(Boat b) {
		for (int i = 0; i < boatLength.length; i++) {
			if (boatLength[i] == b.getSize()) {
				boatLength[i] = 0;
				return true;
			}
		}
		return false;
	}
	
	private int numBoats() {
		int n = 0;
		for (int i = 0; i < boatLength.length; i++) {
			if (boatLength[i] != 0) {
				n++;
			}
		}
		return n;
	}

	public int shootUser(User u, int x, int y) {
		return u.getGrid().shot(x, y);
	}
	
	public Grid getGrid() {
		return grid;
	}
}