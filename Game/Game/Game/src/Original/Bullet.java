package Original;

import java.util.LinkedList;

public class Bullet extends Character{

	public Bullet(){
		x = 0;
		y = 0;
		xSize = 70;
		ySize = 70;
		appearFlag = false;
	}

	private LinkedList<Gull> mygulls = new LinkedList<Gull>();
	private LinkedList<Bullet> e_bullets = new LinkedList<Bullet>();
	private Enemyship myenemy;
	private Playership myplayer;


	public void setGull(Gull gull) {
		mygulls.add(gull);
	}

	public void setE_bullet(Bullet bullet) {
		e_bullets.add(bullet);
	}

	public void setEnemyship(Enemyship enemy) {
		myenemy = enemy;
	}

	public void setPlayership(Playership player) {
		myplayer = player;
	}

	public void kill_gull() {
		if (appearFlag == true) {
			for (Gull mygull : mygulls) {
				if (overlapWith(mygull)) {
					if (mygull.isAppear()) {
						mygull.dead();
						appearFlag = false;
					}
				}
			}
		}
	}

	public void kill_enemy() {
		if (appearFlag == true) {
				if (overlapWith(myenemy)) {
					if (myenemy.isAppear()) {
						myenemy.Downlife();
						appearFlag = false;
					}
				}
		}
	}

	public void kill_player() {
		if (appearFlag == true) {
				if (overlapWith(myplayer)) {
					if (myplayer.isAppear()) {
						myplayer.Downlife();
						appearFlag = false;
					}
				}
		}
	}

	public void fire(int bx, int by, int bxSpeed) {
		if (appearFlag == false) {
			x = bx;
			y = by;
			xSpeed = bxSpeed;
			appearFlag = true;
		}
	}

	public void move() {
		if (appearFlag == true) {
			x = x + xSpeed;
			if (x > 1300) {
				appearFlag = false;
			}
			if(x<0){
				appearFlag = false;
			}
		}
	}


}
