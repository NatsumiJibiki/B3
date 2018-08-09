package game08;

public class Character {
	protected int x = 0;
	protected int y = 0;
	protected int xSize = 48;
	protected int ySize = 48;
	protected int xSpeed = 0;
	protected int ySpeed = 0;

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

	public int getXSpeed() {
		return xSpeed;
	}

	public int getYSpeed() {
		return ySpeed;
	}

	protected boolean overlapWith(Player player) {
		int px = player.getX();
		int py = player.getY();
		int pxSize = player.getXSize();
		int pySize = player.getYSize();
		if (x <= px + pxSize && px <= x + xSize) {
			if (y <= py + pySize && py <= y + ySize) {
				return true;
			}
		}
		return false;
	}
}
