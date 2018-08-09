package gamesuper01;

public class PlayerSuper {
	private int x = 0;
	private int y = 20;
	private int xSize = 24;
	private int ySize = 24;
	private int score = 0;
	private int timeLimit = 1500;

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
		x = x+5;
	}

	public void goLeft(){
		x = x-5;
	}
	
	public int getscore(){
		return score;
	}
	
	public int getlimit(){
		return timeLimit;
	}

}
