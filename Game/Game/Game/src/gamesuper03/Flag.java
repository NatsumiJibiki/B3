package gamesuper03;

public class Flag {
	private int x = 612;
	private int y = 20;
	private int xSize = 40;
	private int ySize = 20;
	private int ySpeed = 2;
	private boolean raisingFlag = false;
	private Castle myCastle;

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

	public void setRaisingFlag(){
		raisingFlag = true;
	}

	public boolean isRaising(){
		return raisingFlag;
	}

	public void move(){
		if(y>130){
			raisingFlag = false;
			myCastle.setAppearFlag();
		}

		if(raisingFlag){
			y = y + ySpeed;
		}

	}

	public void setCastle(Castle castle){
		myCastle = castle;
	}
}
