package Original;

import java.util.LinkedList;

public class Playership extends Character{
	private int score = 0;
	private int life = 5;
	private int p_xSpeed = 4;
	private boolean deadFlag=false;
	private boolean launchedFlag = false;
	private boolean lancerdFlag = false;

	private LinkedList<Bullet> mybullets = new LinkedList<Bullet>();

	private Lance mylance;

	public Playership(){
		x = 0;
		y = 150;
		xSize = 80;
		ySize = 80;
	}

	public void setBullet(Bullet bullet) {
		mybullets.add(bullet);
	}

	public void setLance(Lance lance) {
		mylance = lance;
	}

	public int getScore() {
		return score;
	}

	public int getLife() {
		return life;
	}

	public void scoreUp(int point) {
		score = score + point;
	}

	public void bulletUp() {
		p_xSpeed = p_xSpeed + 1;
	}

	public void goUp() {
		y += 5;
	}

	public void goDown() {
		y -= 5;
	}

	public void goRight() {
		x += 5;
	}

	public void goLeft() {
		x -= 5;
	}

	public void launch() {
		for (Bullet mybullet : mybullets) {
			if (launchedFlag == false) {
				if (mybullet.isAppear() == false) {
					mybullet.fire(x, y, p_xSpeed);
					launchedFlag = true;
				}
			}
		}
	}

	public void Lancer() {
			if (lancerdFlag == false) {
				if (mylance.isAppear() == false) {
					mylance.lancer(x, y);
					lancerdFlag = true;
				}
			}

	}

	public void Downlife(){
		life -= 1;
	}

	public void breakship(){
		if(life<0){
			setDeadFlag();
		}
	}

	public void Uplife(){
		life += 1;
	}

	public void launched() {
		launchedFlag = true;
	}

	public void notLaunched() {
		launchedFlag = false;
	}

	public void lancered() {
		lancerdFlag = true;
	}

	public void notLancerd() {
		lancerdFlag = false;
	}

	public void setDeadFlag() {
		deadFlag = true;
	}

	public boolean isDead() {
		return deadFlag;
	}


}
