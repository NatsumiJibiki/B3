package Original;

public class Supplyship extends Character{
	private Playership myPlayer;
	private int xSpeed = -5;

	public Supplyship(int sy){
		x = 900;
		y = sy;
		xSize = 70;
		ySize = 70;
	}

	public void setPlayership(Playership player) {
		myPlayer = player;
	}

	public void lifeup(){
		if(appearFlag == true){
			if(overlapWith(myPlayer)){
				myPlayer.Uplife();
				appearFlag = false;
			}
		}
	}

	public void move(){
		x += xSpeed;
	}
}
