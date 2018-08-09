package gamesuper07;

public class PlayerSuper extends Character{
	private int ySpeed = 0;
	private int score = 0;
	private int timeLimit = 1500;
	private boolean jumpFlag = false;
	private boolean deadFlag=false;

	public PlayerSuper(){
		x = 0;
		y = 20;
		xSize = 24;
		ySize = 24;
	}

	public int getScore() {
		return score;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void scoreUp(int point) {
		score = score + point;
	}

	public void goRight() {
		x += 5;
	}

	public void goLeft() {
		x -= 5;
	}

	public void move() {
		ySpeed = ySpeed - 2;
		y = y + ySpeed;
		if (y < 0) {
			deadFlag=true;
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

	public void setDeadFlag() {
		deadFlag = true;
	}

	public boolean isDead() {
		return deadFlag;
	}

}
