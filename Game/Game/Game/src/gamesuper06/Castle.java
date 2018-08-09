package gamesuper06;

public class Castle extends Character{
	private PlayerSuper myPlayer;

	private boolean appearFlag = false;

	public Castle(){
		x = 650;
		y = 20;
		xSize = 150;
		ySize = 150;
	}

	public void setPlayerSupper(PlayerSuper player) {
		myPlayer = player;
	}

	public void move() {
		if (appearFlag == true) {
			int px = myPlayer.getX();
			if (px > x + xSize / 2) {
				myPlayer.setGoalFlag();
			}
		}
	}

	// ====================
	// フラグ
	// ====================
	public void setAppearFlag() {
		appearFlag = true;
	}

	public boolean isAppear() {
		return appearFlag;
	}
}
