package game07;

public class Character {
	protected int x = 0;
	protected int y = 300;
	protected int xSize = 80;
	protected int ySize = 40;

	public int getX(){
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
