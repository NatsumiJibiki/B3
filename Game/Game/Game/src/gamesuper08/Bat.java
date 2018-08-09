package gamesuper08;

public class Bat extends CharacterWithPlayer {

	public Bat() {
		x = 0;
		y = 0;
		xSize = 60;
		ySize = 40;
		appearFlag = false;
	}

	public void active(int ex, int ey) {
		if (appearFlag == false) {
			x = ex;
			y = ey;
			xSpeed = -((int) (Math.random() * 10) + 1);
			appearFlag = true;
		}
	}

	public void move() {
		if (appearFlag == true) {
			x = x + xSpeed;
			if (x < 0 && xSpeed < 0) {
				xSpeed = -xSpeed;
			}
			if (x + xSize > 700 && xSpeed > 0) {
				xSpeed = -xSpeed;
			}
		}
	}

	public void kill() {
		if (appearFlag == true) {
			if (overlapWith(myPlayer)) {
				myPlayer.dead();
			}
		}
	}

	public void dead() {
		appearFlag = false;
	}

}
