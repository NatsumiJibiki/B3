package gamesuper08;

public class Ground extends CharacterWithPlayer {
	private int yMin = -100;
	private int yMax = 0;
	private boolean moveFlag = false;

	public Ground(int cx, int cy, int cxSize, int cySize) {
		x = cx;
		y = cy;
		xSize = cxSize;
		ySize = cySize;
		ySpeed = 3;
		moveFlag = false;
	}

	public Ground(int cx, int cy, int cxSize, int cySize, int cyMax) {
		x = cx;
		y = cy;
		xSize = cxSize;
		ySize = cySize;
		yMax = cyMax;
		ySpeed = 3;
		moveFlag = true;
	}

	public void move() {
		if (moveFlag == true) {
			y = y + ySpeed;
			if (y < yMin && ySpeed < 0) {
				ySpeed = -ySpeed;
			}
			if (y + ySize > yMax && ySpeed > 0) {
				ySpeed = -ySpeed;
			}
		}
	}

	public void support() {
		if (overlapWith(myPlayer)) {
			if (myPlayer.getY() > y + ySize - 40) {
				myPlayer.standAt(y + ySize);
			}
		}
	}
}
