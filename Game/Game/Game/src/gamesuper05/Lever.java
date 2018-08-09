package gamesuper05;

public class Lever extends Character{
	Board myBoard;

	public Lever(){
		x = 650;
		y = 150;
		xSize = 36;
		ySize = 36;
	}

	private boolean offFlag=false;

	public void setBoard(Board board){
		myBoard=board;
	}

	public void move(){
		if( offFlag==true){
			myBoard.setSmallFlag();
		}
	}

	// ====================
	// フラグ
	// ====================
	public void setOffFlag(){
		offFlag=true;
	}

	public boolean isOff(){
		return offFlag;
	}
}
