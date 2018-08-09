package game08;

public class Princess extends Character {
	private boolean rescuedFlag = false;
	private Player myPlayer;

	public Princess(int px,int py) {
		x = px;
		y = py;
	}

	public void setPlayer(Player player) {
		myPlayer = player;
	}

	public boolean isRescued() {
		return rescuedFlag;
	}

	public void rescue() {
		if (overlapWith(myPlayer)) {
			rescuedFlag = true;
		}
	}

}
