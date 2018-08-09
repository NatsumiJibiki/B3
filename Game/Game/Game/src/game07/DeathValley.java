package game07;

public class DeathValley extends Character{

	private Player myPlayer;

	public DeathValley(){
		x = 0;
		y = 0;
		xSize = 50;
		ySize = 21;
	}

	public void setPlayer(Player player){
		myPlayer=player;
	}

	public void kill(){
		if( overlapWith(myPlayer)){
			myPlayer.setDeadFlag();
		}
	}

}
