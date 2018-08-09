package gamesuper07;

public class Flag extends Character {
	private Pole myPole;

	private boolean raisedFlag = false;

	public Flag() {
		x = 630;
		y = 20;
		xSize = 40;
		ySize = 30;
	}

	public void setPole(Pole pole) {
		myPole = pole;
	}

	public boolean isRaised() {
		return raisedFlag;
	}

	public void move() {
		if (myPole.isActive()) {
			y = y + 2;
			if (y > 130) {
				y = 130;
				raisedFlag=true;
			}
		}
	}

}
