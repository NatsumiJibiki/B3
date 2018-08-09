package game08;

import java.util.LinkedList;

public class CharacterFire extends Character {

	private LinkedList<Misile> myMisiles = new LinkedList<Misile>();

	public CharacterFire() {
		super();
	}

	public void setMisile(Misile misile) {
		myMisiles.add(misile);
	}

	public void fire() {
		for (Misile myMisile : myMisiles) {
			myMisile.fire(x, y);
		}
	}

}