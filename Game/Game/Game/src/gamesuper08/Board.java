package gamesuper08;

public class Board extends CharacterWithPlayer {
	public Board(int cx, int cy, int cxSize, int cySize) {
		x=cx;
		y=cy;
		xSize=cxSize;
		ySize=cySize;
	}

	private Lever myLever;

	public void setLever(Lever lever) {
		myLever = lever;
	}

	public void support(){
		if( overlapWith(myPlayer)){
			myPlayer.standAt(y+ySize);
		}
	}

	public void erase() {
		if (myLever.isOff()) {
			xSize = xSize - 5;
			if (xSize < 0) {
				appearFlag = false;
			}
		}
	}
}
