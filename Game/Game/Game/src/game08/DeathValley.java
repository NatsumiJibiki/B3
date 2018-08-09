package game08;

public class DeathValley extends Character {

	private Player myPlayer;

	public DeathValley(int gx,int gy) {
		x = gx;
		y = gy;
		xSize = 50;
		ySize = 21;
	}

	public void setPlayer(Player player) {
		myPlayer = player;
	}

	public void kill() {
		if (overlapWith(myPlayer)) {
			myPlayer.setDeadFlag();
		}
	}

}
