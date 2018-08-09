package gamesuper05;

public class Dragon extends Character{
	private PlayerSuper myPlayer;
	private Cage myCage;
	private Fire myFire;

	public Dragon(){
		x = 450;
		y = 200;
		xSize = 120;
		ySize = 120;
	}

	private int ySpeed = 5;
	private boolean fallFlag = false;

	public void setPlayerSuper(PlayerSuper player) {
		myPlayer = player;
	}

	public void setCage(Cage cage) {
		myCage = cage;
	}

	public void setFire(Fire fire) {
		myFire = fire;
	}

	public void move() {
		y = y + ySpeed;
		if (fallFlag == true) {
			ySpeed = -20;
			if (y + ySize < 0) {
				myCage.setUpFlag();
			}
		} else if (y < 150 || y > 280) {
			ySpeed = -ySpeed;
		}
	}

	public void kill() {
		int px = myPlayer.getX();
		int py = myPlayer.getY();
		int pxSize = myPlayer.getXSize();
		int pySize = myPlayer.getYSize();

		if (x <= px + pxSize && px <= x + xSize) {
			if (y <= py + pySize && py <= y + ySize) {
				myPlayer.setDeadFlag();
			}
		}
	}

	public void fire(){
		if(!myFire.isActiveFlag()){
			myFire.setXY(x, y);
		}
	}

	// ====================
	// フラグ
	// ====================
	public void setFallFlag() {
		fallFlag = true;
	}

	public boolean isFall() {
		return fallFlag;
	}
}
