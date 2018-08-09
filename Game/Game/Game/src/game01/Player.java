package game01;

public class Player {
	private int x = 0;
	private int y = 0;
	private int xSize = 48;
	private int ySize = 48;

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getXsize(){
		return xSize;
	}

	public int getYsize(){
		return ySize;
	}

	public void goRight(){
		x = x+3;
	}

	public void goLeft(){
		x = x-3;
	}

}
