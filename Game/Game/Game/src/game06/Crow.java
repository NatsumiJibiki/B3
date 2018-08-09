package game06;

public class Crow extends Character{
	private int xSpeed = 3;
	private Misile myMisile;

	public Crow(){
		x = 0;
		y = 300;
		xSize = 80;
		ySize = 40;
	}
	public void setMisile(Misile misile){
		myMisile=misile;
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

	public void attack(){
		myMisile.fire(x,y);
	}
}
