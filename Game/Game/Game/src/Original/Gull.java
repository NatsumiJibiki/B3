package Original;

public class Gull extends Character{
	protected Playership myPlayer;

	public void setPlayership(Playership player){
		myPlayer=player;
	}

	public Gull(int gy,int gs){
		x = 900;
		y = gy;
		xSize = 70;
		ySize = 70;
		xSpeed = gs;
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

	public void dead() {
		myPlayer.scoreUp(100);
		appearFlag = false;
	}

	public void appear(int gs){
		appearFlag = true;
		y = (int)(Math.random()*350)+1;
		x = 900;
		xSpeed = gs;
	}
}
