package game05;

public class DeathValley extends Character{
	private Player myPlayer;

	public DeathValley(){
		x = 0;
		y = 0;
		xSize = 50;
		ySize = 20;
	}


	public void setPlayer(Player player){
		myPlayer=player;
	}

	public void kill(){
		int px=myPlayer.getX();
		if( px <x+xSize){
			myPlayer.setDeadFlag();
		}
	}



}
