package gamesuper04;

public class Lever {
	private int x = 650;
	private int y = 150;
	private int xSize = 36;
	private int ySize = 36;
	private boolean offFlag = false;
	private Board myboard;

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

	public void setOffFlag(){
		offFlag = true;
	}

	public boolean isOff(){
		return offFlag;
	}

	public void setboard(Board board){
		myboard = board;
	}

	public void move(){
		if(offFlag){
			myboard.setSmallFlag();
		}
	}
}
