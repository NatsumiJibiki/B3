package game02;

public class Crow {
	private int x = 0;
	private int y = 300;
	private int xSize = 80;
	private int ySize = 40;
	private int xSpeed = 3;

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
	
	public int getXSpeed(){
		return xSpeed;
	}
	
	public void move(){
		x = x + xSpeed;
		if(x < 0){
			xSpeed = -xSpeed;
		}
		if(x > 600){
			xSpeed = -xSpeed;
		}
	}
}
