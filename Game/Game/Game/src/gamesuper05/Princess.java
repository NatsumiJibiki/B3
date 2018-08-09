package gamesuper05;

public class Princess extends Character{

	private boolean rescuedFlag = false;

	public Princess(){
		x = 750;
		y = 150;
		xSize = 24;
		ySize = 24;
	}

	// ====================
	// フラグ
	// ====================
	public void setRescuedFlag() {
		rescuedFlag = true;
	}

	public boolean isRescued() {
		return rescuedFlag;
	}
}
