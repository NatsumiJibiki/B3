package game08;

import java.util.LinkedList;

public class World {

	Player player;
	MovingHole movingHole;
	Crow crow;
	Princess princess;
	DeathValley deathValley;

	LinkedList<Misile> misilesOfCrow = new LinkedList<Misile>();
	LinkedList<Misile> misilesOfMovingHole = new LinkedList<Misile>();
	LinkedList<Ground> grounds = new LinkedList<Ground>();

	public World(){
		//misilesOfCrow = new LinkedList<Misile>();
		//misilesOfMovingHole = new LinkedList<Misile>();
		//grounds = new LinkedList<Ground>();
		player = new Player(100,20);
		movingHole = new MovingHole(580,5);
		crow = new Crow(0,300);
		princess = new Princess(550,20);
		deathValley = new DeathValley(0,0);

		misilesOfCrow.add(new Misile(-1, -3));
		misilesOfCrow.add(new Misile(0, -3));
		misilesOfCrow.add(new Misile(1, -3));
		misilesOfMovingHole.add(new Misile(0,5));

		grounds.add(new Ground(0, 0, 200, 20));
		grounds.add(new Ground(540, 0, 80, 20));
		grounds.add(new Ground(240, 100, 80, 20));
		grounds.add(new Ground(340, 200, 80, 20));
		grounds.add(new Ground(440, 300, 80, 20));

		princess.setPlayer(player);
		deathValley.setPlayer(player);
		movingHole.setPlayer(player);

		for (Misile misile : misilesOfCrow) {
			crow.setMisile(misile);
			misile.setPlayer(player);
		}
		for (Misile misile : misilesOfMovingHole) {
			movingHole.setMisile(misile);
			misile.setPlayer(player);
		}
		for (Ground ground : grounds) {
			ground.setPlayer(player);
		}
	}

	public void move(){
		player.move();
		princess.rescue();

		for (Ground ground : grounds) {
			ground.support();
		}

		deathValley.kill();
		movingHole.move();
		movingHole.fire();
		movingHole.attack();
		crow.move();
		crow.fire();

		for (Misile misile : misilesOfCrow) {
			misile.move();
			misile.attack();
		}
		for (Misile misile : misilesOfMovingHole) {
			misile.move();
			misile.attack();
		}
	}

	public LinkedList<Character> getAllCharacters(){
	 	LinkedList<Character> characters = new LinkedList<Character>();
		characters.addAll(grounds);
		characters.add(deathValley);
		characters.add(movingHole);
		characters.add(crow);
		characters.addAll(misilesOfCrow);
		characters.addAll(misilesOfMovingHole);
		characters.add(princess);
		characters.add(player);
		return characters;
	}

	public void movePlayerToRight(){
		player.goRight();
	}

	public void movePlayerToleft(){
		player.goLeft();
	}

	public void jumpPlayer(){
		player.jump();
	}

	public int getHitPointOfPlayer(){
		return player.getHp();
	}

	public boolean isClear(){
		if(!player.isDead() && princess.isRescued()){
			return true;
		}else{
			return false;
		}
	}

	public boolean isOver(){
		if(!player.isDead()){
			return true;
		}else{
			return false;
		}
	}

	}


