package gamesuper02;

public class PlayerSuper {
	private int x = 0;
	private int y = 20;
	private int xSize = 24;
	private int ySize = 24;
	private int score = 0;
	private int timeLimit = 1500;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXSize() {
		return xSize;
	}

	public int getYSize() {
		return ySize;
	}

	public void goRight() {
		x += 5;
	}

	public void goLeft() {
		x -= 5;
	}

	public int getScore() {
		return score;
	}

	public int getTimeLimit() {
		return timeLimit;
	}
}
