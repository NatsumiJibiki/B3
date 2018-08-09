package game07;

public class Crow extends CharacterFire{
	private int xSpeed = 3;
	public Crow(){
		x = 0;
		y = 300;
		xSize = 80;
		ySize = 40;
	}

	public int getXSpeed(){
		return xSpeed;
	}

	public void move() {
		x = x + xSpeed;
		if (x < 0 || x > 600-xSize) {
			xSpeed = -xSpeed;
		}
	}
}
