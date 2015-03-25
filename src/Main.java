
public class Main {

	public static void main(String[] args) {

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

}
