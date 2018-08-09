package gamesuper08;

public class Cage extends CharacterWithPlayer {
	public Cage(int cx, int cy) {
		x = cx;
		y = cy;
		xSize=60;
		ySize=60;
	}

	private Dragon myDragon;

	public void setDragon(Dragon dragon) {
		myDragon = dragon;
	}

	public void up() {
		if (!myDragon.isAppear()) {
			y = y + 2;
		}
	}

	public void kill() {
		if (overlapWith(myPlayer)) {
			myPlayer.dead();
		}
	}
}
