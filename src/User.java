
public class User {
	
	private Grid grid = new Grid(10, 10);
	private Boat[] boats;
	private int[] boatLength = new int[] {2, 3, 3, 4, 5};
	
	public User() {
	}
	
	public boolean addBoat(int l, int x, int y, int d) {
		Boat b = new Boat(l, x, y, d, this);
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
		int shot = u.getGrid().shot(x, y);
		if (shot == 2) {
			boatAt(x, y).markHit(x, y);
		}
		return shot;
	}
	
	private Boat boatAt(int x, int y) {
		for (int i = 0; i < boats.length; i++) {
			for (int l = 0; l < boats[i].getSize(); l++) {
				if (boats[i].getCoords()[0][i] == x && boats[i].getCoords()[1][i] == y) {
					return boats[i];
				}
			}
		}
		return null;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public int[][] getGridData() {
		return grid.gridData();
	}
}