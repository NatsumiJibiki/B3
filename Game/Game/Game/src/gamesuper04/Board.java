package gamesuper04;

public class Board {
	private int x = 200;
	private int y = 140;
	private int xSize = 400;
	private int ySize = 10;
	private boolean smallFlag = false;
	private Dragon mydragon;

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getXSize(){
		return xSize;
	}

	public int getYSize(){
		return ySize;
	}

	public void setSmallFlag(){
		smallFlag = true;
	}

	public boolean isSmall(){
		return smallFlag;
	}

	public void setDragon(Dragon dragon){
		mydragon = dragon;
	}

	public void move(){
		if(xSize<0){
			xSize = 0;
			mydragon.setFallFlag();
		}
		if(smallFlag){
			xSize = xSize-5;
		}
	}

}
