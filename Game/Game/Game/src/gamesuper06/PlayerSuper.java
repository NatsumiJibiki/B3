package gamesuper06;

public class PlayerSuper extends Character{
	private Flag myFlag;

	private int ySpeed = 0;
	private int score = 0;
	private int timeLimit = 1500;
	private boolean jumpFlag = false;
	private boolean deadFlag=false;
	private boolean goalFlag = false;

	public PlayerSuper(){
		x = 0;
		y = 20;
		//x = 300;
		//y = 300;
		xSize = 24;
		ySize = 24;
	}

	public void setFlag(Flag flag){
		myFlag=flag;
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
			setDeadFlag();
		}
		if(x > myFlag.getX()){
			myFlag.setRaisingFlag();
		}

	}

	public void jump() {
		if (jumpFlag == false) {
			jumpFlag = true;
			ySpeed = 20;
		}
	}

	public void standAt(int py){
		jumpFlag = false;
		ySpeed = 0;
		y = py;
	}

	public void scoreUp(int point){
		score = score + point;
	}

	// ====================
	// フラグ
	// ====================

	public void setGoalFlag() {
		goalFlag = true;
	}

	public boolean isGoal() {
		return goalFlag;
	}

	public void setDeadFlag() {
		deadFlag = true;
	}

	public boolean isDead() {
		return deadFlag;
	}

}
