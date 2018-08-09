package gamesuper07;

public class Dog extends CharacterAttack {
	private int xSpeed = -3;

	public Dog() {
		x = 540;
		y = 20;
		xSize = 50;
		ySize = 25;
	}

	public int getXSpeed() {
		return xSpeed;
	}

	public void move() {
		x = x + xSpeed;
		if (x < 500 || x + xSize > 600) {
			xSpeed = -xSpeed;
		}
	}
}
