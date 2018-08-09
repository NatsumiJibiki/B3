package gamesuper03;

public class Castle {
	private int x = 650;
	private int y = 20;
	private int xSize = 150;
	private int ySize = 150;
	private boolean appearFlag = false;
	private PlayerSuper myPlayerSuper;
	
	void setPlayerSuper(PlayerSuper playerSuper){
		myPlayerSuper = playerSuper;
	}
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

	public void setAppearFlag(){
		appearFlag = true;
	}

	public boolean isAppear(){
		return appearFlag;
	}

	

	public void move(){
		if(appearFlag && myPlayerSuper.getX()>x+75){
			myPlayerSuper.setGoalFlag();
		}
	}
}
