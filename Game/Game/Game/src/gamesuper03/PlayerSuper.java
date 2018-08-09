package gamesuper03;

public class PlayerSuper {
	private int x = 0;
	private int y = 20;
	private int xSize = 24;
	private int ySize = 24;
	private int score = 0;
	private int timeLimit = 1500;
	private Flag myFlag;
	private boolean goalFlag = false;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXSize() {
		return xSize;
	}

	public int getYSize() {
		return ySize;
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

	public void setFlag(Flag flag){
		myFlag = flag;
	}

	public void setGoalFlag(){
		goalFlag = true;
	}

	public boolean isGoal(){
		return goalFlag;
	}

	public void move(){
		int fx = myFlag.getX();
		if(x >= fx){
			myFlag.setRaisingFlag();
		}
	}

}
