package game03;

public class DeathValley {
	private int x = 0;
	private int y = 0;
	private int xSize = 50;
	private int ySize = 20;
	private Player myPlayer;

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

	public void setPlayer(Player player){
		myPlayer = player;
	}

	public void kill(){
		int px = myPlayer.getX();
		if(px < x+xSize){
			myPlayer.setDeadFlag();
		}
	}

}
