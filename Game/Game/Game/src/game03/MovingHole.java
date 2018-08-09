package game03;

public class MovingHole {
	private int x = 580;
	private int y = 5;
	private int xSize = 15;
	private int ySize = 15;
	private int xSpeed=-2;
	private Player myPlayer;

	public void setPlayer(Player player){
		myPlayer = player;
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

	public void move(){
		x = x + xSpeed;
		if( x< 0){
			x=600;
		}
		int px = myPlayer.getX();
		if(x<px && px<x+xSize){
			myPlayer.addDamage(2);
		}
	}

}
