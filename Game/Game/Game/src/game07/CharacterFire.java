package game07;

import java.util.LinkedList;

public class CharacterFire extends Character {

	private LinkedList<Misile> myMisiles = new LinkedList<Misile>();

	public CharacterFire() {
		super();
	}

	public void setMisile(Misile misile) {
		//myMisile=misile;
		myMisiles.add(misile);
	}

	public void fire() {
		//myMisile.fire(x,y);
		for(Misile misile:myMisiles){
			misile.fire(x, y);
		}
	}

}