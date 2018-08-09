package game03;

public class Princess {
	private int x = 560;
	private int y = 20;
	private int xSize = 48;
	private int ySize = 48;
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
