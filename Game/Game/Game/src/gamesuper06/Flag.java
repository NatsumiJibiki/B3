package gamesuper06;

public class Flag extends Character {
	private Castle myCastle;

	private boolean raisingFlag = false;

	public Flag() {
		x = 630;
		y = 20;
		xSize = 40;
		ySize = 30;
	}

	public void setCastle(Castle castle) {
		myCastle = castle;
	}

	public void move() {
		if (isRaising()) {
			y = y + 2;
			if (y > 130) {
				y = 130;
				raisingFlag=false;
				myCastle.setAppearFlag();
			}
		}
	}

	// ====================
	// フラグ
	// ====================
	public void setRaisingFlag() {
		raisingFlag = true;
	}

	public boolean isRaising() {
		return raisingFlag;
	}
}
