package game06;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class Game06 extends GameBase {

	public static void main(String[] args) {
		new Game06();
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
	Misile misile;
	Ground ground;
	Ground ground2;
	Ground ground3;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/sky.jpg");
		playerImage = cg.loadImage("/img/player.png");
		crowRightImage = cg.loadImage("/img/crow_right.png");
		crowLeftImage = cg.loadImage("/img/crow_left.png");
		princessImage=cg.loadImage("/img/princess.png");
		deathValleyImage=cg.loadImage("/img/valley.jpg");
		misileImage=cg.loadImage("/img/misile.png");

		// Model オブジェクト生成
		player = new Player();
		movingHole = new MovingHole();
		crow=new Crow();
		princess=new Princess();
		deathValley=new DeathValley();
		misile=new Misile();
		ground = new Ground(0,0,200,20);
		ground2 = new Ground(280,0,320,20);
		ground3 = new Ground(0,80,50,20);

		player.setPrincess(princess);
		deathValley.setPlayer(player);
		movingHole.setPlayer(player);
		crow.setMisile(misile);
		misile.setPlayer(player);
		ground.setPlayer(player);
		ground2.setPlayer(player);
		ground3.setPlayer(player);
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
		player.rescue();

		ground3.support();
		ground.support();
		ground2.support();
		deathValley.kill();
		movingHole.move();
		movingHole.attack();
		crow.move();
		crow.attack();
		misile.move();
		misile.attack();


		// View 画面表示

		// 背景表示
		cg.drawImage(0, 0, backImage);

		// 地面表示
		drawGround(ground);
		drawGround(ground2);
		drawGround(ground3);

		// Valley表示
		int dx = deathValley.getX();
		int dy = deathValley.getY();
		int dxSize = deathValley.getXSize();
		int dySize = deathValley.getYSize();
		cg.drawImage(dx, dy, dxSize, dySize, deathValleyImage);

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

		// Misile表示
		int mx = misile.getX();
		int my = misile.getY();
		int mxSize = misile.getXSize();
		int mySize = misile.getYSize();
		cg.drawImage(mx, my, mxSize, mySize, misileImage);

		// Player表示
		int px = player.getX();
		int py = player.getY();
		int pxSize = player.getXSize();
		int pySize = player.getYSize();
		cg.drawImage(px, py, pxSize, pySize, playerImage);

		// Princess表示
		int prx = princess.getX();
		int pry = princess.getY();
		int prxSize = princess.getXSize();
		int prySize = princess.getYSize();
		cg.drawImage(prx, pry, prxSize, prySize, princessImage);

		// HitPoint表示
		int php = player.getHp();
		cg.setColor(Color.BLUE);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 18));
		cg.drawStringRight(550, 360, "HP");
		cg.drawStringRight(595, 360, "" + php);

		// GameClear表示
		if( princess.isRescued()==true){
			cg.setColor(Color.GREEN);
			cg.setFont(new Font("MS明朝",Font.PLAIN,48));
			cg.drawStringCenter(300, 200, "Game Clear!");
		}

		// GameOver表示
		if( player.isDead()==true){
			cg.setColor(Color.RED);
			cg.setFont(new Font("MS明朝",Font.PLAIN,48));
			cg.drawStringCenter(300, 200, "Game Over!");
		}

	}

	public void drawGround(Ground ground){
		int gx = ground.getX();
		int gy = ground.getY();
		int gxSize = ground.getXSize();
		int gySize = ground.getYSize();
		cg.setColor(new Color(75, 35, 25));
		cg.fillRect(gx, gy, gxSize, gySize);
	}

}
