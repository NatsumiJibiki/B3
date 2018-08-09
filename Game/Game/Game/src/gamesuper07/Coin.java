package gamesuper07;

public class Coin extends Character {
	private PlayerSuper myPlayer;
	private boolean appearFlag = true;

	public Coin(int cx,int cy) {
		x = cx;
		y = cy;
		xSize = 40;
		ySize = 40;
	}

	public void setPlayerSuper(PlayerSuper player) {
		myPlayer = player;
	}

	public boolean isAppear() {
		return appearFlag;
	}

	public void taked() {
		if (appearFlag == true) {
			if (overlapWith(myPlayer)) {
				myPlayer.scoreUp(100);
				appearFlag = false;
			}
		}
	}

}
