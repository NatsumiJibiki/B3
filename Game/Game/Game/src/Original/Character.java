package Original;

public class Character {
	protected int x = 0;
	protected int y = 0;
	protected int xSize = 24;
	protected int ySize = 24;
	protected int xSpeed = 0;
	protected int ySpeed = 0;
	protected boolean appearFlag = true;

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


	public boolean overlapWith(Character c) {
		int cx = c.getX();
		int cy = c.getY();
		int cxSize = c.getXSize();
		int cySize = c.getYSize();
		if (x <= cx + cxSize && cx <= x + xSize) {
			if (y <= cy + cySize && cy <= y + ySize) {
				return true;
			}
		}
		return false;
	}

	// ====================
	// フラグ
	// ====================
	public void appear() {
		appearFlag = true;
	}

	public void disappear() {
		appearFlag = false;
	}

	public boolean isAppear() {
		return appearFlag;
	}



}
