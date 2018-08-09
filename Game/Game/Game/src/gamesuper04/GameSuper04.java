package gamesuper04;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class GameSuper04 extends GameBase {

	public static void main(String[] args) {
		new GameSuper04();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage brockGroundImage;
	BufferedImage playerImage;
	BufferedImage dragonImage;
	BufferedImage boardImage;
	BufferedImage lever_leftImage;
	BufferedImage lever_rightImage;
	BufferedImage cageImage;
	BufferedImage princessImage;

	// Model 変数定義
	PlayerSuper player;
	Dragon dragon;
	Board board;
	Lever lever;
	Cage cage;
	Princess princess;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/underground.jpg");
		brockGroundImage = cg.loadImage("/img/blockground.jpg");
		playerImage = cg.loadImage("/img/player.png");
		dragonImage = cg.loadImage("/img/dragon.png");
		boardImage = cg.loadImage("/img/board.png");
		lever_leftImage = cg.loadImage("/img/lever_left.png");
		lever_rightImage = cg.loadImage("/img/lever_right.png");
		cageImage = cg.loadImage("/img/cage.png");
		princessImage = cg.loadImage("/img/princess.png");


		// Model オブジェクト生成
		player = new PlayerSuper();
		dragon = new Dragon();
		board = new Board();
		lever = new Lever();
		cage = new Cage();
		princess = new Princess();

		// Model オブジェクト関連付け
		player.setLever(lever);
		lever.setboard(board);
		board.setDragon(dragon);
		dragon.setCage(cage);
		player.setPrincess(princess);
		dragon.setPlayerSuper(player);
		cage.setPlayerSuper(player);
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
		player.move();
		lever.move();
		board.move();
		cage.move();
		dragon.kill();
		cage.kill();

		// View 画面表示

		// 背景表示
		cg.drawImage(0, 0, backImage);
		cg.drawImage(0, 0, 200, 150, brockGroundImage);
		cg.drawImage(600, 0, 200, 150, brockGroundImage);

		// ドラゴン表示
		int dx = dragon.getX();
		int dy = dragon.getY();
		int dxSize = dragon.getXSize();
		int dySize = dragon.getYSize();
		cg.drawImage(dx, dy, dxSize, dySize, dragonImage);

		// ボード表示
		int bx = board.getX();
		int by = board.getY();
		int bxSize = board.getXSize();
		int bySize = board.getYSize();
		cg.drawImage(bx, by, bxSize, bySize, boardImage);

		// レバー表示
		int lx = lever.getX();
		int ly = lever.getY();
		int lxSize = lever.getXSize();
		int lySize = lever.getYSize();
		if(lever.isOff()){
			cg.drawImage(lx, ly, lxSize, lySize, lever_rightImage);
		}else{
			cg.drawImage(lx, ly, lxSize, lySize, lever_leftImage);
		}

		// ケージ表示
		int cx = cage.getX();
		int cy = cage.getY();
		int cxSize = cage.getXSize();
		int cySize = cage.getYSize();
		cg.drawImage(cx, cy, cxSize, cySize, cageImage);

		// ケージ表示
		int px = princess.getX();
		int py = princess.getY();
		int pxSize = princess.getXSize();
		int pySize = princess.getYSize();
		cg.drawImage(px, py, pxSize, pySize, princessImage);

		// プレーヤ表示
		int x = player.getX();
		int y = player.getY();
		int xSize = player.getXSize();
		int ySize = player.getYSize();
		cg.drawImage(x, y, xSize, ySize, playerImage);

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

		// GameOver表示
		if(player.isDead()){
			cg.setColor(Color.BLUE);
			cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
			cg.drawStringCenter(300, 200, "Game Over");
		}

		// GameClear表示
		if(princess.isRescued()){
			cg.setColor(Color.BLUE);
			cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
			cg.drawStringCenter(300, 200, "Game Clear");
		}
	}
}
