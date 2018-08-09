package game02;

public class Player {
	private int x = 0;
	private int y = 20;
	private int xSize = 48;
	private int ySize = 48;
	private int hp = 200;

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

	public int getHp() {
		return hp;
	}

	public void goRight() {
		x += 3;
	}

	public void goLeft() {
		x -= 3;
	}
}
