package gamesuper07;

public class Flower extends CharacterAttack{

	private int ySpeed = -1;

	public Flower(){
		x = 428;
		y = 130;
		xSize = 30;
		ySize = 35;
	}

	public void move() {
		y = y + ySpeed;
		if (y < 130 || y + ySize > 220) {
			ySpeed = -ySpeed;
		}
	}
}
