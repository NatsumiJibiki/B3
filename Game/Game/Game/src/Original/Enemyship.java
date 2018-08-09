package Original;

import java.util.LinkedList;

public class Enemyship extends Character{
	private Playership myPlayer;
	private int life = 5;
	private int ySpeed = -2;
	private int e_xSpeed = -6;
	private LinkedList<Bullet> mybullets = new LinkedList<Bullet>();

	public void setPlayership(Playership player){
		myPlayer=player;
	}

	public void setBullet(Bullet bullet) {
		mybullets.add(bullet);
	}

	public Enemyship(int ey){
	x = 700;
	y = ey;
	xSize = 70;
	ySize = 70;
	}

	public void Downlife(){
		life -= 1;
	}

	public void breakship(){
		if(life==0){
			myPlayer.scoreUp(500);
			setBreak();
			life--;
		}
	}

	public void setBreak(){
		appearFlag = false;
	}

	public void move(){
		y += ySpeed;
		if (y < 0 || y > 370) {
			ySpeed = -ySpeed;
		}
	}

	public void kill() {
		if (appearFlag == true) {
			if (overlapWith(myPlayer)) {
				myPlayer.Downlife();
				appearFlag = false;
			}
		}
	}

	public void launch() {
		for (Bullet mybullet : mybullets) {
				if (mybullet.isAppear() == false) {
					mybullet.fire(x, y, e_xSpeed);

				}
		}
	}




}
