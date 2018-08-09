package game05;

public class Misile extends Character{
	private Player myPlayer;
	private boolean activeFlag = false;

	public Misile(){
		x = 300;
		y = 400;
		xSize = 20;
		ySize = 40;
	}

	public void setPlayer(Player player){
		myPlayer = player;
	}

	public void move(){
		if(activeFlag){
			y = y-3;
			if(y < 0){
				y = 400;
				activeFlag = false;
			}
		}
	}

	public void attack(){
		if(activeFlag){
			int px = myPlayer.getX();
			int py = myPlayer.getY();
			int pxSize = myPlayer.getXSize();
			int pySize = myPlayer.getYSize();
			if(x <= px + pxSize && px <= x+xSize){
				if(y <= py + pySize && py <= y+ySize){
					myPlayer.setDeadFlag();
					activeFlag = false;
				}
			}
		}
	}
	
	public void fire(int mx,int my){
		if(activeFlag == false){
			x = mx;
			y = my;
			activeFlag = true;
		}
	}

	public void setActiveFlag(){
		activeFlag = true;
	}

	public boolean isActive(){
		return activeFlag;
	}
}
