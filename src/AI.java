import java.util.Random;

public class AI {
	
	private User user;
	private int[] shot;
	
	public AI(User u) {
		user = u;
	}
	
	public int[] shoot() {
		if (noHits()) {
			shootRandom();
		}
		return shot;
	}

	private void shootRandom() {
		int x = randInt(0, user.getGridData()[0].length);
		int y = randInt(0, user.getGridData().length);
		if (user.getGridData()[x][y] < 2) {
			shot[0] = x;
			shot[1] = y;
		} else {
			shootRandom();
		}
	}
	
	private boolean noHits() {
		int hits = 0;
		for (int x = 0; x < user.getGridData().length; x++) {
			for (int y = 0; y < user.getGridData().length; y++) {
				if (user.getGridData()[x][y] > 1) {
					hits++;
				}
			}
		}
		if (hits > 0) {
			return false;
		}
		return true;
	}
	
	private int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
}
