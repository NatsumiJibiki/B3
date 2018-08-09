package gamesuper04;

public class Dragon {
	private int x = 450;
	private int y = 200;
	private int xSize = 120;
	private int ySize = 120;
	private int ySpeed = 5;
	private boolean fallFlag = false;
	private Cage mycage;
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

	public int getYSpeed(){
		return ySpeed;
	}

	public void setFallFlag(){
		fallFlag = true;
	}

	public boolean isFall(){
		return fallFlag;
	}

	public void setCage(Cage cage){
		mycage = cage;
	}

	public void setPlayerSuper(PlayerSuper player){
		myplayer = player;
	}

	public void move() {
		System.out.println(y);
		y = y + ySpeed;
		if (y < 150) {
			ySpeed = -ySpeed;
		}
		if (y > 400-ySize) {
			ySpeed = -ySpeed;
		}

		if(fallFlag){
			ySpeed = -20;
		}

		if(y+ySize<0){
			mycage.setUpFlag();
		}
	}

	public void kill(){
		if((x <= myplayer.getX() + myplayer.getXSize())&&(myplayer.getX() <= x + xSize)&&(y <= myplayer.getY() + myplayer.getYSize())&&(myplayer.getY() <= y + ySize)){
			myplayer.setDeadFlag();
		}
	}

}
