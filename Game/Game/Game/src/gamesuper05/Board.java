package gamesuper05;

public class Board extends Character{
	private Dragon myDragon;

	public Board(){
		x = 200;
		y = 140;
		xSize = 400;
		ySize = 10;
	}

	private boolean smallFlag = false;

	public void setDragon(Dragon dragon) {
		myDragon = dragon;
	}

	public void move() {
		if (smallFlag == true) {
			xSize = xSize - 5;
			if (xSize < 0) {
				xSize = 0;
				myDragon.setFallFlag();
			}
		}
	}

	// ====================
	// フラグ
	// ====================
	public void setSmallFlag() {
		smallFlag = true;
	}

	public boolean isSmall() {
		return smallFlag;
	}
}
