package gamesuper08;

public class Lever extends CharacterWithPlayer{
	public Lever(int cx, int cy) {
		x=cx;
		y=cy;
		xSize=36;
		ySize=36;
	}

	private boolean offFlag=false;

	public void change(){
		if(overlapWith(myPlayer)){
			offFlag=true;
		}
	}

	public boolean isOff(){
		return offFlag;
	}
}
