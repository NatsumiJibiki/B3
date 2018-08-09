package gamesuper04;

public class Cage {
	private int x = 730;
	private int y = 150;
	private int xSize = 60;
	private int ySize = 60;
	private boolean upFlag = false;
	private PlayerSuper myplayer;

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

	public void setUpFlag(){
		upFlag = true;
	}

	public boolean isUp(){
		return upFlag;
	}

	public void setPlayerSuper(PlayerSuper player){
		myplayer = player;
	}

	public void move(){
		if(upFlag){
			y = y + 2;
		}
	}

	public void kill(){
		if((x <= myplayer.getX() + myplayer.getXSize())&&(myplayer.getX() <= x + xSize)&&(y <= myplayer.getY() + myplayer.getYSize())&&(myplayer.getY() <= y + ySize)){
			myplayer.setDeadFlag();
		}
	}

}
