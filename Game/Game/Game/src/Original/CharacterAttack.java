package Original;

public class CharacterAttack extends Character{
	private Playership myPlayer;
	private Enemyship myenemy;
	protected int xSpeed = 0;

	public CharacterAttack() {
		super();
	}

	public void setPlayership(Playership player) {
		myPlayer = player;
	}

	public void setEnemyship(Enemyship enemy) {
		myenemy = enemy;
	}

	public void e_attack() {
		if (appearFlag == true) {
			if (overlapWith(myPlayer)) {
				myPlayer.Downlife();
			}
		}
	}

	public void p_attack() {
		if (appearFlag == true) {
			if (overlapWith(myenemy)) {
				myenemy.Downlife();
			}
		}
	}
	
	


}
