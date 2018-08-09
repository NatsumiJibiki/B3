package game03;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class Game03 extends GameBase {

	public static void main(String[] args) {
		new Game03();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage playerImage;
	BufferedImage crowRightImage;
	BufferedImage crowLeftImage;
	BufferedImage princessImage;
	BufferedImage deathValleyImage;

	// Model 変数定義
	Player player;
	MovingHole movingHole;
	Crow crow;
	Princess princess;
	DeathValley deathValley;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/sky.jpg");
		playerImage = cg.loadImage("/img/player.png");
		crowRightImage = cg.loadImage("/img/crow_right.png");
		crowLeftImage = cg.loadImage("/img/crow_left.png");
		princessImage = cg.loadImage("/img/princess.png");
		deathValleyImage = cg.loadImage("/img/valley.jpg");

		// Model オブジェクト生成
		player = new Player();
		movingHole = new MovingHole();
		crow = new Crow();
		princess = new Princess();
		deathValley = new DeathValley();

		player.setPrincess(princess);
		deathValley.setPlayer(player);
		movingHole.setPlayer(player);
	}

	public void play() {
		// View キー入力
		if (key.isPress(KeyEvent.VK_RIGHT)) {
			player.goRight();
		}
		if (key.isPress(KeyEvent.VK_LEFT)) {
			player.goLeft();
		}

		// Model 動作
		movingHole.move();
		crow.move();
		deathValley.kill();
		player.move();


		// View 画面表示

		// 背景表示
		cg.drawImage(0, 0, backImage);

		// 地面表示
		cg.setColor(new Color(75, 35, 25));
		cg.fillRect(0, 0, 620, 20);

		// MovingHole表示
		int mhx = movingHole.getX();
		int mhy = movingHole.getY();
		int mhxSize = movingHole.getXSize();
		int mhySize = movingHole.getYSize();
		cg.setColor(new Color(255, 255, 255));
		cg.fillRect(mhx,mhy,mhxSize, mhySize);

		// Crow表示
		int cx = crow.getX();
		int cy = crow.getY();
		int cxSize = crow.getXSize();
		int cySize = crow.getYSize();
		int cxSpeed= crow.getXSpeed();
		if( cxSpeed > 0){
			cg.drawImage(cx, cy, cxSize, cySize,crowRightImage);
		}else{
			cg.drawImage(cx, cy, cxSize, cySize,crowLeftImage);
		}

		// Princess表示
		int rx = princess.getX();
		int ry = princess.getY();
		int rxSize = princess.getXSize();
		int rySize = princess.getYSize();
		cg.drawImage(rx, ry, rxSize, rySize, princessImage);

		// DeathValley表示
		int vx = deathValley.getX();
		int vy = deathValley.getY();
		int vxSize = deathValley.getXSize();
		int vySize = deathValley.getYSize();
		cg.drawImage(vx, vy, vxSize, vySize, deathValleyImage);

		// Player表示
		int px = player.getX();
		int py = player.getY();
		int pxSize = player.getXSize();
		int pySize = player.getYSize();
		cg.drawImage(px, py, pxSize, pySize, playerImage);

		// HitPoint表示
		int php = player.getHp();
		cg.setColor(Color.BLUE);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 18));
		cg.drawStringRight(550, 360, "HP");
		cg.drawStringRight(595, 360, "" + php);

		// GameClear表示
		if(princess.isRescued()){
			cg.setColor(Color.BLUE);
			cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
			cg.drawStringCenter(300, 200, "Game Clear!!");
		}

		// GameOver表示
		if(player.isDead()){
			cg.setColor(Color.RED);
			cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
			cg.drawStringCenter(300, 200, "Game Over!!");
		}
	}

}
