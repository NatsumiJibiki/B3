package game06;

public class Ground extends Character{
	private Player myPlayer;

	public Ground(int gx,int gy,int gxSize,int gySize){
		x = gx;
		y = gy;
		xSize = gxSize;
		ySize = gySize;
	}

	public void setPlayer(Player player){
		myPlayer = player;
	}

	public void support(){
		if(overlapWith(myPlayer)){
			myPlayer.standAt(y+ySize);
		}
	}
}
