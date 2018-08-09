package game05;

public class Player extends Character{
	private int hp = 200;
	private boolean deadFlag=false;
	private Princess myPrincess;

	public Player(){
		x = 100;
		y = 20;
		xSize = 48;
		ySize = 48;
	}
	public void setPrincess(Princess princess){
		myPrincess=princess;
	}

	public void goRight() {
		x += 3;
	}

	public void goLeft() {
		x -= 3;
	}

	public int getHp() {
		return hp;
	}

	public void rescue(){
		int princessX=myPrincess.getX();
		if( princessX < x ){
			myPrincess.setRescuedFlag();
		}
	}

	public void setDeadFlag(){
		deadFlag=true;
	}

	public boolean isDead(){
		return deadFlag;
	}

	public void addDamage(int damage){
		hp=hp-damage;
	}

}
