package gamesuper06;

public class Cloud extends Character{
	private int ySpeed = -1;
	private PlayerSuper myPlayer;

	public Cloud(){
		x = 200;
		y = 200;
		xSize = 30;
		ySize = 15;
	}

	public void move() {
		y = y + ySpeed;
		if (y < 150 || y+ySize > 250) {
			ySpeed = -ySpeed;
		}
	}

	public void setPlayerSuper(PlayerSuper player){
		myPlayer = player;
	}

	public void support(){
		if(overlapWith(myPlayer)){
			myPlayer.standAt(y+ySize);
		}
	}
}
