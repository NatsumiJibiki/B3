package game08;

public class Player extends Character {
	private int ySpeed = 0;
	private int hp = 200;
	private boolean deadFlag = false;
	private boolean jumpFlag = false;

	public Player(int px,int py) {
		x = px;
		y = py;
	}

	public int getHp() {
		return hp;
	}

	public void addDamage(int damage) {
		hp = hp - damage;
	}

	public void setDeadFlag() {
		deadFlag = true;
	}

	public boolean isDead() {
		return deadFlag;
	}

	public void goRight() {
		x += 3;
	}

	public void goLeft() {
		x -= 3;
	}

	public void move() {
		ySpeed = ySpeed - 2;
		y = y + ySpeed;
		if (y < 0) {
			ySpeed = 0;
			deadFlag = true;
		}
	}

	public void jump() {
		if (jumpFlag == false) {
			jumpFlag = true;
			ySpeed = 20;
		}
	}

	public void standAt(int py) {
		jumpFlag = false;
		ySpeed = 0;
		y = py;
	}

}
