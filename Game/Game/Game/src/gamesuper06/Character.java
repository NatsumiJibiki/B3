package gamesuper06;


public class Character {
	protected int x = 0;
	protected int y = 0;
	protected int xSize = 24;
	protected int ySize = 24;

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

	public boolean overlapWith(PlayerSuper player) {
		int cx = player.getX();
		int cy = player.getY();
		int cxSize = player.getXSize();
		int cySize = player.getYSize();

		if (x <= cx + cxSize && cx <= x + xSize) {
			if (y <= cy + cySize && cy <= y + ySize) {
				return true;
			}
		}
		return false;
	}
}
