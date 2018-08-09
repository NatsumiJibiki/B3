package gamesuper07;

public class Pole extends Character{

	private boolean activeFlag=false;
	private PlayerSuper myPlayer;

	public Pole(){
		x = 620;
		y = 20;
		xSize = 20;
		ySize = 150;
	}

	public void setPlayerSuper(PlayerSuper player) {
		myPlayer = player;
	}

	public boolean isActive() {
		return activeFlag;
	}

	public void move(){
		if(overlapWith(myPlayer)){
			activeFlag=true;
		}
	}

}
