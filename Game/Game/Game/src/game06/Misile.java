package game06;

public class Misile extends Character {
	private boolean activeFlag = false;
	private Player myPlayer;

	public Misile() {
		x = 300;
		y = 400;
		xSize = 20;
		ySize = 40;
	}

	public void setPlayer(Player player) {
		myPlayer = player;
	}

	public void setActiveFlag() {
		activeFlag = true;
	}

	public boolean isActive() {
		return activeFlag;
	}

	public void fire(int mx, int my) {
		if (activeFlag == false) {
			x = mx;
			y = my;
			activeFlag = true;
		}
	}

	public void move() {
		if (activeFlag == true) {
			y = y - 3;
			if (y < 0) {
				y = 400;
				activeFlag=false;
			}
		}
	}

	public void attack() {
		if (activeFlag == true) {
			if(overlapWith(myPlayer)==true){
					myPlayer.setDeadFlag();
					activeFlag = false;
			}
		}
	}

	public boolean overlapWith(Player player){
		int px = player.getX();
		int py = player.getY();
		int pxSize = player.getXSize();
		int pySize = player.getYSize();
		if (x <= px + pxSize && px <= x + xSize) {
			if (y <= py + pySize && py <= y + ySize) {
				return true;
			}
		}
		return false;

	}

}
