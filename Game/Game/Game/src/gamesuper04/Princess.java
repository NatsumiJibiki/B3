package gamesuper04;

public class Princess {
	private int x = 750;
	private int y = 150;
	private int xSize = 24;
	private int ySize = 24;
	private boolean rescuedFlag = false;

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

	public void setRescuedFlag(){
		rescuedFlag = true;
	}

	public boolean isRescued(){
		return rescuedFlag;
	}
}
