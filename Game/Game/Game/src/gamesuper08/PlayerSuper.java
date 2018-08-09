package gamesuper08;

import java.util.LinkedList;

public class PlayerSuper extends Character {
	public PlayerSuper(int cx, int cy) {
		x = cx;
		y = cy;
	}

	private int score = 0;
	private int timeLimit = 1000;
	private boolean jumpFlag = false;
	private boolean deadFlag = false;
	private boolean launchedFlag = false;

	private LinkedList<Beam> myBeams = new LinkedList<Beam>();

	public void setBeam(Beam beam) {
		myBeams.add(beam);
	}

	public void goRight() {
		x += 5;
	}

	public void goLeft() {
		x -= 5;
	}

	public int getScore() {
		return score;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void move() {
		ySpeed = ySpeed - 2;
		y = y + ySpeed;
		if (y < 0) {
			dead();
		}
	}

	public void jump() {
		if (jumpFlag == false) {
			jumpFlag = true;
			ySpeed = 20;
		}
	}

	public void standAt(int standy) {
		jumpFlag = false;
		ySpeed = 0;
		y = standy;
	}

	public void launch() {
		for (Beam myBeam : myBeams) {
			if (launchedFlag == false) {
				if (myBeam.isAppear() == false) {
					myBeam.fire(x, y, 10);
					launchedFlag = true;
				}
			}
		}
	}

	// ====================
	// フラグ
	// ====================
	public void launched() {
		launchedFlag = true;
	}

	public void notLaunched() {
		launchedFlag = false;
	}

	public void dead() {
		deadFlag = true;
	}

	public boolean isDead() {
		return deadFlag;
	}

}
