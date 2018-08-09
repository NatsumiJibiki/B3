package gamesuper07;

public class Bullet extends CharacterAttack{

	private int xSpeed = -4;

	public Bullet(){
		x = 800;
		y = 100;
		xSize = 36;
		ySize = 36;
	}

	public void move() {
		x = x + xSpeed;
		if(x<0){
			x = 800;
		}
	}

}
