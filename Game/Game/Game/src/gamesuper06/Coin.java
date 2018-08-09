package gamesuper06;

public class Coin extends Character{
	private PlayerSuper myPlayer;

	private boolean appearFlag = true;

	public Coin(){
		x = 300;
		y = 300;
		xSize = 40;
		ySize = 40;
	}


	public void setMyPlayer(PlayerSuper myPlayer) {
		this.myPlayer = myPlayer;
	}


	public void taked() {
		if (appearFlag == true) {
			if (overlapWith(myPlayer)) {
				appearFlag = false;
				myPlayer.scoreUp(100);
			}
		}
	}

	// ====================
	// フラグ
	// ====================
	public void setAppearFlag() {
		appearFlag = false;
	}

	public boolean isAppear() {
		return appearFlag;
	}
}
