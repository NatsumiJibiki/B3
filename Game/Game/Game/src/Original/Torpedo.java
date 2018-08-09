package Original;

public class Torpedo extends Character{

	protected Playership myPlayer;

	public void setPlayership(Playership player){
		myPlayer=player;
	}

	public Torpedo(int ty){
		x = 900;
		y = ty;
		xSize = 80;
		ySize = 48;
		xSpeed = -3;
	}

	public void bullet_up() {
		if (appearFlag == true) {
			if (overlapWith(myPlayer)) {
				myPlayer.bulletUp();
				appearFlag = false;
			}
		}
	}

	public void move(){
		x += xSpeed;
		if(x<0){
			appearFlag = false;
		}
	}

	public void appear(){
		appearFlag = true;
		y = (int)(Math.random()*350)+1;
		x = 900;
		xSpeed = -3;
	}

}
