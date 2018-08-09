package Original;

public class Fish extends Character{

	protected Playership myPlayer;

	public void setPlayership(Playership player){
		myPlayer=player;
	}

	public Fish(int fy){
		x = 900;
		y = fy;
		xSize = 48;
		ySize = 48;
		xSpeed = -2;
	}

	public void score_up() {
		if (appearFlag == true) {
			if (overlapWith(myPlayer)) {
				myPlayer.scoreUp(50);
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
		xSpeed = -2;
	}
}
