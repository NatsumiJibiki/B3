package game07;

public class Misile extends Character {
	private int xSpeed = 0;
	private int ySpeed = 0;
	private int xFireSpeed = 0;
	private int yFireSpeed = 0;
	private boolean activeFlag = false;
	private Player myPlayer;

	public Misile(int mxFireSpeed, int myFireSpeed) {
		x = 300;
		y = 400;
		xSize = 20;
		ySize = 40;
		xFireSpeed = mxFireSpeed;
		yFireSpeed = myFireSpeed;
	}

	public void setPlayer(Player player) {
		myPlayer = player;
	}

	public boolean isActive() {
		return activeFlag;
	}

	public void fire(int mx, int my) {
		if (activeFlag == false) {
			x = mx;
			y = my;
			xSpeed = xFireSpeed;
			ySpeed = yFireSpeed;
			activeFlag = true;
		}
	}

	public void move() {
		if (activeFlag == true) {
			x = x + xSpeed;
			y = y + ySpeed;
			if (y < 0 || 400 < y) {
				activeFlag = false;
			}
		}
	}

	public void attack() {
		if (activeFlag == true) {
			if (overlapWith(myPlayer)) {
				myPlayer.setDeadFlag();
			}
		}
	}

}
