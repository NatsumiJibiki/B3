package gamesuper08;

import java.util.LinkedList;

public class Dragon extends CharacterWithPlayer {
	private boolean deadFlag = false;

	private Board myBoard;
	private Fire myFire;
	private LinkedList<Bat> myBats = new LinkedList<Bat>();

	public Dragon(int cx, int cy) {
		x = cx;
		y = cy;
		xSize = 120;
		ySize = 120;
		ySpeed = 4;
	}

	public void setBoard(Board board) {
		myBoard = board;
	}

	public void setFire(Fire fire) {
		myFire = fire;
	}

	public void setBat(Bat bat) {
		myBats.add(bat);
	}

	public void move() {
		if (myBoard.isAppear()) {
			y = y + ySpeed;
			if (y < 150 && ySpeed < 0) {
				ySpeed = -ySpeed;
			}
			if (y + ySize > 400 && ySpeed > 0) {
				ySpeed = -ySpeed;
			}
		} else {
			y = y+ySpeed;
		}
	}

	public void kill() {
		if (overlapWith(myPlayer)) {
			myPlayer.dead();
		}
	}

	public void fire() {
		myFire.active(x, y + ySize / 2);
	}

	public void launch() {
		for (Bat myBat : myBats) {
			myBat.active(x, y);
		}
	}

	public void fall() {
		if (myBoard.isAppear() == false) {
			ySpeed = -20;
			if (y + ySize < 0) {
				deadFlag = true;
			}
		}
	}

	public boolean isDead() {
		return deadFlag;
	}
}
