package game05;

public class Princess extends Character{
	private boolean rescuedFlag=false;

	public Princess(){
		x = 550;
		y = 20;
		xSize = 48;
		ySize = 48;
	}

	public void setRescuedFlag(){
		rescuedFlag=true;
	}

	public boolean isRescued(){
		return rescuedFlag;
	}


}
