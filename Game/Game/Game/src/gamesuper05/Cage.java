package gamesuper05;

public class Cage extends Character{
	private PlayerSuper myPlayer;
	private boolean upFlag = false;
	
	public Cage(){
		x = 730;
		y = 150;
		xSize = 60;
		ySize = 60;
	}

	public void setPlayerSuper(PlayerSuper player) {
		myPlayer = player;
	}

	public void move() {
		if (upFlag == true) {
			y = y + 2;
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

	// ====================
	// フラグ
	// ====================
	public void setUpFlag() {
		upFlag = true;
	}

	public boolean isUp() {
		return upFlag;
	}
}
