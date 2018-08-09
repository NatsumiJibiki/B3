package game03;

public class Player {
	private int x = 100;
	private int y = 20;
	private int xSize = 48;
	private int ySize = 48;
	private int hp = 200;
	private Princess myPrincess;
	private boolean deadFlag = false;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXSize() {
		return xSize;
	}

	public int getYSize() {
		return ySize;
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

	public void setPrincess(Princess princess){
		myPrincess = princess;
	}

	public void addDamage(int damage){
		hp = hp - damage;
	}

	public void move(){
		int rX = myPrincess.getX();
		if(rX < x){
			myPrincess.setRescuedFlag();
		}
	}

	public void setDeadFlag(){
		deadFlag = true;
	}

	public boolean isDead(){
		return deadFlag;
	}



}
