package gamesuper04;

public class PlayerSuper {
	private int x = 0;
	private int y = 150;
	private int xSize = 24;
	private int ySize = 24;
	private int score = 0;
	private int timeLimit = 1500;
	private Lever mylever;
	private Princess myprincess;
	private boolean deadFlag = false;

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

	public void setLever(Lever lever){
		mylever = lever;
	}

	public void setPrincess(Princess princess){
		myprincess = princess;
	}

	public void setDeadFlag(){
		deadFlag = true;
	}

	public boolean isDead(){
		return deadFlag;
	}

	public void move(){
		if(x >= mylever.getX()){
			mylever.setOffFlag();
		}
		if(x >= myprincess.getX()){
			myprincess.setRescuedFlag();
		}
	}

}
