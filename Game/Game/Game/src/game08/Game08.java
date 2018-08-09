package game08;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

class Game08 extends GameBase {

	public static void main(String[] args) {
		new Game08();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage playerImage;
	BufferedImage crowRightImage;
	BufferedImage crowLeftImage;
	BufferedImage princessImage;
	BufferedImage deathValleyImage;
	BufferedImage misileImage;

	// Model 変数定義
	Player player;
	MovingHole movingHole;
	Crow crow;
	Princess princess;
	DeathValley deathValley;

	LinkedList<Misile> misilesOfCrow;
	LinkedList<Misile> misilesOfMovingHole;
	LinkedList<Ground> grounds;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/sky.jpg");
		playerImage = cg.loadImage("/img/player.png");
		crowRightImage = cg.loadImage("/img/crow_right.png");
		crowLeftImage = cg.loadImage("/img/crow_left.png");
		princessImage = cg.loadImage("/img/princess.png");
		deathValleyImage = cg.loadImage("/img/valley.jpg");
		misileImage = cg.loadImage("/img/misile.png");

		// Model オブジェクト生成
		misilesOfCrow = new LinkedList<Misile>();
		misilesOfMovingHole = new LinkedList<Misile>();
		grounds = new LinkedList<Ground>();

		player = new Player(100,20);
		movingHole = new MovingHole(580,5);
		crow = new Crow(0,300);
		princess = new Princess(550,20);
		deathValley = new DeathValley(0,0);

		misilesOfCrow.add(new Misile(-1, -3));
		misilesOfCrow.add(new Misile(0, -3));
		misilesOfCrow.add(new Misile(1, -3));
		misilesOfMovingHole.add(new Misile(0,5));

		grounds.add(new Ground(0, 0, 200, 20));
		grounds.add(new Ground(540, 0, 80, 20));
		grounds.add(new Ground(240, 100, 80, 20));
		grounds.add(new Ground(340, 200, 80, 20));
		grounds.add(new Ground(440, 300, 80, 20));

		princess.setPlayer(player);
		deathValley.setPlayer(player);
		movingHole.setPlayer(player);

		for (Misile misile : misilesOfCrow) {
			crow.setMisile(misile);
			misile.setPlayer(player);
		}
		for (Misile misile : misilesOfMovingHole) {
			movingHole.setMisile(misile);
			misile.setPlayer(player);
		}
		for (Ground ground : grounds) {
			ground.setPlayer(player);
		}

	}

	public void play() {
		// View キー入力
		if (key.isPress(KeyEvent.VK_RIGHT)) {
			player.goRight();
		}
		if (key.isPress(KeyEvent.VK_LEFT)) {
			player.goLeft();
		}
		if (key.isPress(KeyEvent.VK_SPACE)) {
			player.jump();
		}

		// Model 動作
		player.move();
		princess.rescue();

		for (Ground ground : grounds) {
			ground.support();
		}

		deathValley.kill();
		movingHole.move();
		movingHole.fire();
		movingHole.attack();
		crow.move();
		crow.fire();

		for (Misile misile : misilesOfCrow) {
			misile.move();
			misile.attack();
		}
		for (Misile misile : misilesOfMovingHole) {
			misile.move();
			misile.attack();
		}

		// View 画面表示

		// 背景表示
		cg.drawImage(0, 0, backImage);

		// 地面表示
		for (Ground ground : grounds) {
			drawCharacter(ground,new Color(75,35,25));
		}

		// Valley表示
		drawCharacter(deathValley,deathValleyImage);

		// MovingHole表示
		drawCharacter(movingHole,new Color(255,255,255));

		// Crow表示
		drawCharacterX(crow,crowRightImage,crowLeftImage);

		// Misile表示
		for (Misile misile : misilesOfCrow) {
			drawCharacter(misile,misileImage);
		}
		for (Misile misile : misilesOfMovingHole) {
			drawCharacter(misile,misileImage);
		}

		// Player表示
		drawCharacter(player,playerImage);

		// Princess表示
		drawCharacter(princess,princessImage);

		// HitPoint表示
		drawHitPoint(player.getHp());

		// GameClear表示
		if (!player.isDead() && princess.isRescued()) {
			drawGameClear();
		}

		// GameOver表示
		if (player.isDead()) {
			drawGameOver();
		}

	}

	private void drawGameOver() {
		cg.setColor(Color.RED);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
		cg.drawStringCenter(300, 200, "Game Over!");
	}

	private void drawGameClear() {
		cg.setColor(Color.GREEN);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
		cg.drawStringCenter(300, 200, "Game Clear!");
	}

	private void drawHitPoint(int php) {
		cg.setColor(Color.BLUE);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 18));
		cg.drawStringRight(550, 360, "HP");
		cg.drawStringRight(595, 360, "" + php);
	}

	private void drawCharacter(Character c,Color color) {
		int x = c.getX();
		int y = c.getY();
		int xSize = c.getXSize();
		int ySize = c.getYSize();
		cg.setColor(color);
		cg.fillRect(x, y, xSize, ySize);
	}

	private void drawCharacter(Character c,BufferedImage image) {
		int x = c.getX();
		int y = c.getY();
		int xSize = c.getXSize();
		int ySize = c.getYSize();
		cg.drawImage(x, y, xSize, ySize, image);
	}

	private void drawCharacterX(Character c,BufferedImage rightImage,BufferedImage leftImage) {
		int x = c.getX();
		int y = c.getY();
		int xSize = c.getXSize();
		int ySize = c.getYSize();
		int xSpeed = c.getXSpeed();
		if (xSpeed > 0) {
			cg.drawImage(x, y, xSize, ySize, rightImage);
		} else {
			cg.drawImage(x, y, xSize, ySize, leftImage);
		}
	}

}
