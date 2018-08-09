package gamesuper02;

public class Cloud {
	private int x = 200;
	private int y = 200;
	private int xSize = 30;
	private int ySize = 15;
	private int ySpeed = -1;

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

	public int getYSpeed(){
		return ySpeed;
	}

	public void move(){
		y = y + ySpeed;

		if(y+ySize > 250){
			ySpeed = -ySpeed;
		}
		if(y < 100){
			ySpeed = -ySpeed;
		}
	}

}
