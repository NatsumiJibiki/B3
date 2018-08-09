package gamesuper08;

import java.util.LinkedList;

public class Beam extends Character {

	public Beam() {
		x = 0;
		y = 0;
		xSize = 30;
		ySize = 10;
		appearFlag = false;
	}

	private LinkedList<Bat> myBats = new LinkedList<Bat>();

	public void setBat(Bat bat) {
		myBats.add(bat);
	}

	public void fire(int bx, int by, int bxSpeed) {
		if (appearFlag == false) {
			x = bx;
			y = by;
			xSpeed = bxSpeed;
			appearFlag = true;
		}
	}

	public void move() {
		if (appearFlag == true) {
			x = x + xSpeed;
			if (x > 1300) {
				x = 0;
				appearFlag = false;
			}
		}
	}

	public void kill() {
		if (appearFlag == true) {
			for (Bat myBat : myBats) {
				if (overlapWith(myBat)) {
					if (myBat.isAppear()) {
						myBat.dead();
						appearFlag = false;
					}
				}
			}
		}
	}
}
