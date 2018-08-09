package gamesuper07;

public class Cloud extends CharacterSupport {
	private int ySpeed = -1;

	public Cloud() {
		x = 200;
		y = 200;
		xSize = 30;
		ySize = 15;
	}

	public void move() {
		y = y + ySpeed;
		if (y < 150 || y + ySize > 250) {
			ySpeed = -ySpeed;
		}
	}
}
