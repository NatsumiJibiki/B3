package game07;

public class Princess extends Character {
	private boolean rescuedFlag = false;
	private Player myPlayer;

	public Princess() {
		x = 550;
		y = 20;
		xSize = 48;
		ySize = 48;
	}

	public void setPlayer(Player player){
		myPlayer=player;
	}

	public boolean isRescued() {
		return rescuedFlag;
	}

	public void rescue() {
		if (overlapWith(myPlayer)) {
			rescuedFlag=true;
		}
	}

}
