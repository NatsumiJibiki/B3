package game09;

public class Player extends Character {

	public Player(int px, int py, int pxSize, int pySize) {
		x=px;
		y=py;
		xSize=pxSize;
		ySize=pySize;
	}

	public void goUp() {
		ySpeed = 10;
	}

	public void goDown() {
		ySpeed = -10;
	}

	public void goRight() {
		xSpeed = 10;
	}

	public void goLeft() {
		xSpeed = -10;
	}

	public void stop() {
		xSpeed = 0;
		ySpeed = 0;
	}

	public void move() {
		x = x + xSpeed;
		y = y + ySpeed;
	}
}
