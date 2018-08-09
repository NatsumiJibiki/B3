package gamesuper08;

public class Fire extends CharacterWithPlayer {
	public Fire(int cx, int cy) {
		x = cx;
		y = cy;
		xSize = 40;
		ySize = 40;
		appearFlag = false;
	}

	public void active(int fx, int fy) {
		if (appearFlag == false) {
			x = fx;
			y = fy;
			xSpeed = -(int) (Math.random() * 15);
			ySpeed = (int) (Math.random() * 20) + 1;
			appearFlag = true;
		}
	}

	public void move() {
		if (appearFlag == true) {
			ySpeed = ySpeed - 1;
			x = x + xSpeed;
			y = y + ySpeed;
			if (x < 0 || y < 0) {
				appearFlag = false;
			}
		}
	}

	public void kill() {
		if (appearFlag == true) {
			if (overlapWith(myPlayer)) {
				myPlayer.dead();
				appearFlag = false;
			}
		}
	}

}
