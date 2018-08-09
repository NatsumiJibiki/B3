package Original;

public class Whale extends Character{
	private int ySpeed = -2;
	private boolean goalFlag = false;

	public Whale(){
		x = 900;
		y = 150;
		xSize = 100;
		ySize = 80;
	}

	public void move(){
		y += ySpeed;
		if (y < 0 || y > 370) {
			ySpeed = -ySpeed;
		}
	}

	public void goal() {
		goalFlag=true;
	}

	public boolean isGoal() {
		return goalFlag;
	}

	public void stop(){
		ySpeed = 0;
	}

}
