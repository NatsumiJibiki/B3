package game09;

public class Jewel extends Character {

	public Jewel(int jx, int jy, int jxSize, int jySize) {
		x = jx;
		y = jy;
		xSize = jxSize;
		ySize = jySize;
	}

	public void warpTo(int jx, int jy) {
		x = jx;
		y = jy;
	}
}
