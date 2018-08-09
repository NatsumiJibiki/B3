package game09;

public class Character {
	protected int x = 0;
	protected int y = 0;
	protected int xSize = 48;
	protected int ySize = 48;
	protected int xSpeed = 0;
	protected int ySpeed = 0;

	// ======================
	// getter
	// ======================
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

	// ======================
	// 位置情報取得・設定
	// ======================
	public int getLeft() {
		return x;
	}

	public int getRight() {
		return x + xSize - 1;
	}

	public int getTop() {
		return y + ySize - 1;
	}

	public int getBottom() {
		return y;
	}

	public int getCenterX() {
		return x + xSize / 2;
	}

	public int getCenterY() {
		return y + ySize / 2;
	}

	// ======================
	// 衝突判定
	// ======================
	public boolean overlapX(Character c) {
		if (getRight() < c.getLeft()) {
			return false;
		}
		if (c.getRight() < getLeft()) {
			return false;
		}
		return true;
	}

	public boolean overlapY(Character c) {
		if (getTop() < c.getBottom()) {
			return false;
		}
		if (c.getTop() < getBottom()) {
			return false;
		}
		return true;
	}

	public boolean overlapWith(Character c) {
		return overlapX(c) && overlapY(c);
	}
}
