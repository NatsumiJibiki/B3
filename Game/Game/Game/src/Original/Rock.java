package Original;

public class Rock extends Character{
	protected Playership myPlayer;

	public void setPlayership(Playership player){
		myPlayer=player;
	}

	public Rock(int cy,int cs){
		x = 900;
		y = cy;
		xSize = 48;
		ySize = 48;
		xSpeed = cs;
	}

	public void move(){
		x += xSpeed;
		if(x<0){
			appearFlag = false;
		}
	}

	public void kill() {
		if (appearFlag == true) {
			if (overlapWith(myPlayer)) {
				myPlayer.Downlife();
				appearFlag = false;
			}
		}
	}

	public void appear(int gs){
		appearFlag = true;
		y = (int)(Math.random()*350)+1;
		x = 900;
		xSpeed = gs;
	}
}
