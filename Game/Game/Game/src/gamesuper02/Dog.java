package gamesuper02;

public class Dog {
	private int x = 540;
	private int y = 20;
	private int xSize = 50;
	private int ySize = 25;
	private int xSpeed = -3;

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
		if(x > 400){
			xSpeed = -xSpeed;
		}
		if(x+xSize < 600){
			xSpeed = -xSpeed;
		}

	}
}
