package game08;

public class Crow extends CharacterFire {
	public Crow(int cx,int cy) {
		x = cx;
		y = cy;
		xSize = 80;
		ySize = 40;
		xSpeed = 3;
	}

	public void move() {
		x = x + xSpeed;
		if (x < 0 || x > 600 - xSize) {
			xSpeed = -xSpeed;
		}
	}
}
