package gamesuper05;

public class PlayerSuper extends Character{
	private Lever myLever;
	private Princess myPrincess;

	public PlayerSuper(){
		x = 0;
		y = 150;
		xSize = 24;
		ySize = 24;
	}

	private int score = 0;
	private int timeLimit = 1000;
	private boolean deadFlag = false;

	public void setLever(Lever lever){
		myLever=lever;
	}
	public void setPrincess(Princess princess) {
		myPrincess = princess;
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
		if (deadFlag == false) {
			if( myLever.getX()< x){
				myLever.setOffFlag();
			}
			if (myPrincess.getX() < x) {
				myPrincess.setRescuedFlag();
			}
		}
	}

	// ====================
	// フラグ
	// ====================
	public void setDeadFlag() {
		deadFlag = true;
	}

	public boolean isDead() {
		return deadFlag;
	}



}
