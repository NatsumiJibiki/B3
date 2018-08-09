package gamesuper05;

public class Fire extends Character{

	public Fire(){
		x = 450;
		y = 400;
		xSize = 48;
		ySize = 48;
	}
	private int xSpeed = -5;
	private int ySpeed = -5;
	private PlayerSuper myPlayer;
	private boolean activeFlag = false;



	public void move(){
		if(activeFlag){
			x = x + xSpeed;
			y = y + ySpeed;
			if(y<0){
				activeFlag = false;
			}
		}
	}

	public void setPlayerSuper(PlayerSuper player){
		myPlayer = player;
	}

	public void kill(){
		if(activeFlag){
			int px = myPlayer.getX();
			int py = myPlayer.getY();
			int pxSize = myPlayer.getXSize();
			int pySize = myPlayer.getYSize();
			if (x <= px + pxSize && px <= x + xSize) {
				if (y <= py + pySize && py <= y + ySize) {
					myPlayer.setDeadFlag();
					activeFlag = false;
				}
			}
		}
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		activeFlag = true;
	}

	public void setXY(int dragonx,int dragony){
		if(activeFlag == false){
			x = dragonx;
			y = dragony;
			activeFlag = true;
		}
	}

}
