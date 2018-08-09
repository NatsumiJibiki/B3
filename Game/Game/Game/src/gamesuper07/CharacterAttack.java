package gamesuper07;

public class CharacterAttack extends Character {

	private PlayerSuper myPlayer;

	public CharacterAttack() {
		super();
	}

	public void setPlayerSuper(PlayerSuper player) {
		myPlayer = player;
	}

	public void attack() {
		if (appearFlag == true) {
			if (overlapWith(myPlayer)) {
				myPlayer.setDeadFlag();
			}
		}
	}

}