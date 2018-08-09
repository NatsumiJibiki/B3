package game06;

public class MovingHole extends Character{
	private int xSpeed=-2;
	private Player myPlayer;

	public MovingHole(){
		x = 580;
		y = 5;
		xSize = 15;
		ySize = 16;
	}

	public void setPlayer(Player player){
		myPlayer = player;
	}


	public void move(){
		x = x + xSpeed;
		if( x< 0){
			x=600;
		}
	}

	public void attack(){
		if(overlapWith(myPlayer)){
			myPlayer.addDamage(2);
		}
	}
}
