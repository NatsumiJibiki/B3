package gamesuper06;

public class Block extends Character{
	private PlayerSuper myPlayer;

	public Block(int bx,int by,int bxSize,int bySize){
		x = bx;
		y = by;
		xSize = bxSize;
		ySize = bySize;
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
