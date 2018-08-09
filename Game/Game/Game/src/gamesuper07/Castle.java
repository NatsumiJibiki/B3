package gamesuper07;

public class Castle extends Character {
	private boolean goalFlag = false;

	private Flag myFlag;
	private PlayerSuper myPlayer;
	private Ghost myGhost;

	public void setMyGhost(Ghost myGhost) {
		this.myGhost = myGhost;
	}

	public Castle() {
		x = 700;
		y = 200;
		xSize = 100;
		ySize = 100;
		appearFlag=false;
	}

	public void setFlag(Flag flag){
		myFlag=flag;
	}

	public void setPlayerSupper(PlayerSuper player) {
		myPlayer = player;
	}

	public boolean isAppear() {
		return appearFlag;
	}

	public boolean isGoal() {
		return goalFlag;
	}

	public void appear() {
		if (!myGhost.isAppear() && myFlag.isRaised()) {
			appearFlag=true;
		}
	}

	public void welcome() {
		if (appearFlag==true) {
			int px = myPlayer.getX();
			if (px > x + xSize / 2) {
				goalFlag=true;
			}
		}
	}


}
