package gamesuper05;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class GameSuper05 extends GameBase {

	public static void main(String[] args) {
		new GameSuper05();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage brockGroundImage;
	BufferedImage princessImage;
	BufferedImage dragonImage;
	BufferedImage boardImage;
	BufferedImage leverRightImage;
	BufferedImage leverLeftImage;
	BufferedImage cageImage;
	BufferedImage playerImage; 
	BufferedImage fireImage;

	// Model 変数定義
	PlayerSuper player;
	Princess princess;
	Dragon dragon;
	Board board;
	Lever lever;
	Cage cage;
	Fire fire;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/underground.jpg");
		brockGroundImage = cg.loadImage("/img/blockground.jpg");
		princessImage = cg.loadImage("/img/princess.png");
		dragonImage = cg.loadImage("/img/dragon.png");
		boardImage = cg.loadImage("/img/board.png");
		leverRightImage = cg.loadImage("/img/lever_right.png");
		leverLeftImage = cg.loadImage("/img/lever_left.png");
		cageImage = cg.loadImage("/img/cage.png");
		playerImage = cg.loadImage("/img/player.png");
		fireImage = cg.loadImage("/img/fire.png");

		// Model オブジェクト生成
		player = new PlayerSuper();
		princess = new Princess();
		dragon = new Dragon();
		board = new Board();
		lever = new Lever();
		cage = new Cage();
		fire = new Fire();

		// Model オブジェクト関連付け
		dragon.setPlayerSuper(player);
		lever.setBoard(board);
		cage.setPlayerSuper(player);
		board.setDragon(dragon);
		dragon.setCage(cage); 
		player.setLever(lever);
		player.setPrincess(princess);
		fire.setPlayerSuper(player);
		dragon.setFire(fire);
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
		dragon.move();
		dragon.kill();
		lever.move();
		board.move();
		cage.move();
		cage.kill();
		player.move();
		fire.move();
		fire.kill();
		dragon.fire();

		// View 画面表示

		// 背景表示
		cg.drawImage(0, 0, backImage);

		// ブロック表示
		cg.drawImage(0, 0, 200, 150, brockGroundImage);
		cg.drawImage(600, 0, 200, 150, brockGroundImage);

		// 檻表示
		int cx = cage.getX();
		int cy = cage.getY();
		int cxSize = cage.getXSize();
		int cySize = cage.getYSize();
		cg.drawImage(cx, cy, cxSize, cySize, cageImage);

		// レバー表示
		int lx = lever.getX();
		int ly = lever.getY();
		int lxSize = lever.getXSize();
		int lySize = lever.getYSize();
		if (lever.isOff()) {
			cg.drawImage(lx, ly, lxSize, lySize, leverRightImage);
		} else {
			cg.drawImage(lx, ly, lxSize, lySize, leverLeftImage);
		}

		// ボード表示
		int bx = board.getX();
		int by = board.getY();
		int bxSize = board.getXSize();
		int bySize = board.getYSize();
		cg.drawImage(bx, by, bxSize, bySize, boardImage);

		// ドラゴン表示
		int dx = dragon.getX();
		int dy = dragon.getY();
		int dxSize = dragon.getXSize();
		int dySize = dragon.getYSize();
		cg.drawImage(dx, dy, dxSize, dySize, dragonImage);

		// プリンセス表示
		int rx = princess.getX();
		int ry = princess.getY();
		int rxSize = princess.getXSize();
		int rySize = princess.getYSize();
		cg.drawImage(rx, ry, rxSize, rySize, princessImage);

		// Fire表示
		int fx = fire.getX();
		int fy = fire.getY();
		int fxSize = fire.getXSize();
		int fySize = fire.getYSize();
		cg.drawImage(fx, fy, fxSize, fySize, fireImage);

		// プレーヤ表示
		int px = player.getX();
		int py = player.getY();
		int pxSize = player.getXSize();
		int pySize = player.getYSize();
		cg.drawImage(px, py, pxSize, pySize, playerImage);

		// ステータス表示
		cg.setColor(Color.BLACK);
		cg.fillRect(655, 340, 135, 46);

		// スコア表示
		int score = player.getScore();
		cg.setColor(Color.GREEN);
		cg.setFont(new Font("SansSerif", Font.BOLD, 20));
		cg.drawStringLeft(660, 365, "Score");
		cg.drawStringRight(785, 365, "" + score);

		// タイムリミット表示
		int timeLimit = player.getTimeLimit();
		cg.setColor(Color.RED);
		cg.setFont(new Font("SansSerif", Font.BOLD, 20));
		cg.drawStringLeft(660, 345, "Limit");
		cg.drawStringRight(785, 345, "" + timeLimit);


		if (player.isDead()) {
			// Game Over表示
			cg.setColor(Color.RED);
			cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
			cg.drawStringCenter(400, 200, "Game Over !!");
		}else if (princess.isRescued()) {
			// Game Clear表示
			cg.setColor(Color.BLUE);
			cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
			cg.drawStringCenter(400, 200, "Game Clear !!");
		}

	}
}
