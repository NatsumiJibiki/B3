package Original;

public class Lance extends Character{

	public Lance(){
		x = 0;
		y = 0;
		xSize = 70;
		ySize = 90;
		appearFlag = false;
	}

	private Whale mywhale;

	public void setWhale(Whale whale) {
		mywhale = whale;
	}


	public void lancer(int bx, int by) {
		if (appearFlag == false) {
			x = bx+70;
			y = by;
			appearFlag = true;
		}
	}

	public void get_whale() {
		if (appearFlag == true) {
				if (overlapWith(mywhale)) {
					if (mywhale.isAppear()) {
						mywhale.goal();
					}
				}
		}
	}


}
