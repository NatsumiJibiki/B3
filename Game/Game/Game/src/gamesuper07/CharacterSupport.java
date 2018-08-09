package gamesuper07;

public class CharacterSupport extends Character {

	private PlayerSuper myPlayer;

	public CharacterSupport() {
		super();
	}

	public void setPlayerSuper(PlayerSuper player) {
		myPlayer = player;
	}

	public void support() {
		if (overlapWith(myPlayer)) {
			myPlayer.standAt(y + ySize);
		}
	}

}