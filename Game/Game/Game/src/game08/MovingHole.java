package game08;

public class MovingHole extends CharacterFire {
	private int xSpeed = -2;
	private Player myPlayer;

	public MovingHole(int mx,int my) {
		x = mx;
		y = my;
		xSize = 15;
		ySize = 16;
	}

	public void setPlayer(Player player) {
		myPlayer = player;
	}

	public void move() {
		x = x + xSpeed;
		if (x < 0) {
			x = 600;
		}
	}

	public void attack() {
		if (overlapWith(myPlayer)) {
			myPlayer.addDamage(2);
		}
	}
}
