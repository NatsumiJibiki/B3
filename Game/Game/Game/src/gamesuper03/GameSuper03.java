package gamesuper03;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class GameSuper03 extends GameBase {

	public static void main(String[] args) {
		new GameSuper03();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage bridgeImage;
	BufferedImage dogRightImage;
	BufferedImage dogLeftImage;
	BufferedImage coinImage;
	BufferedImage cloudImage;
	BufferedImage poleImage;
	BufferedImage flagImage;
	BufferedImage castleImage;

	BufferedImage playerImage;

	// Model 変数定義
	PlayerSuper player;
	Dog dog;
	Coin coin;
	Cloud cloud;
	Flag flag;
	Castle castle;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/sea.jpg");
		bridgeImage = cg.loadImage("/img/bridge.png");
		dogRightImage = cg.loadImage("/img/dog_right.png");
		dogLeftImage = cg.loadImage("/img/dog_left.png");
		coinImage = cg.loadImage("/img/coin.png");
		cloudImage = cg.loadImage("/img/cloud.png");
		playerImage = cg.loadImage("/img/player.png");
		poleImage = cg.loadImage("/img/pole.gif");
		flagImage = cg.loadImage("/img/flag.gif");
		castleImage = cg.loadImage("/img/castle.png");

		// Model オブジェクト生成
		player = new PlayerSuper();
		dog = new Dog();
		coin = new Coin();
		cloud = new Cloud();
		flag = new Flag();
		castle = new Castle();

		player.setFlag(flag);
		flag.setCastle(castle);
		castle.setPlayerSuper(player);

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
		dog.move();
		cloud.move();
		player.move();
		flag.move();
		castle.move();

		// View 画面表示

		// 背景表示
		cg.drawImage(0, 0, backImage);

		//ポール表示
		cg.drawImage(600, 20, 20,150,poleImage);

		// 橋表示
		for (int x = 0; x < 800; x += 100) {
			cg.drawImage(x, 0, 100, 20, bridgeImage);
		}

		// 旗表示
		int flagx = flag.getX();
		int flagy = flag.getY();
		int flagxSize = flag.getXSize();
		int flagySize = flag.getYSize();
		cg.drawImage(flagx, flagy, flagxSize, flagySize, flagImage);

		// 城表示
		int cx = castle.getX();
		int cy = castle.getY();
		int cxSize = castle.getXSize();
		int cySize = castle.getYSize();
		if(castle.isAppear()){
			cg.drawImage(cx, cy, cxSize, cySize, castleImage);
		}


		// 犬表示
		int dx = dog.getX();
		int dy = dog.getY();
		int dxSize = dog.getXSize();
		int dySize = dog.getYSize();
		int dxSpeed = dog.getXSpeed();
		if (dxSpeed > 0) {
			cg.drawImage(dx, dy, dxSize, dySize, dogRightImage);
		} else {
			cg.drawImage(dx, dy, dxSize, dySize, dogLeftImage);
		}

		// コイン表示
		int coinx = coin.getX();
		int coiny = coin.getY();
		int coinxSize = coin.getXSize();
		int coinySize = coin.getYSize();
		cg.drawImage(coinx, coiny, coinxSize, coinySize, coinImage);

		// 雲表示
		int cloudx = cloud.getX();
		int cloudy = cloud.getY();
		int cloudxSize = cloud.getXSize();
		int cloudySize = cloud.getYSize();
		cg.drawImage(cloudx, cloudy, cloudxSize, cloudySize, cloudImage);

		// プレーヤ表示
		int px = player.getX();
		int py = player.getY();
		int pxSize = player.getXSize();
		int pySize = player.getYSize();
		cg.drawImage(px, py, pxSize, pySize, playerImage);

		// GameClear表示
		if(player.isGoal()){
			cg.setColor(Color.BLUE);
			cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
			cg.drawStringCenter(300, 200, "Game Clear");
		}

		// ステータス
		cg.setColor(Color.BLACK);
		cg.fillRect(655, 340, 135, 46);

		int score = player.getScore();
		cg.setColor(Color.GREEN);
		cg.setFont(new Font("SansSerif", Font.BOLD, 20));
		cg.drawStringLeft(660, 365, "Score");
		cg.drawStringRight(785, 365, "" + score);

		int timeLimit = player.getTimeLimit();
		cg.setColor(Color.RED);
		cg.setFont(new Font("SansSerif", Font.BOLD, 20));
		cg.drawStringLeft(660, 345, "Limit");
		cg.drawStringRight(785, 345, "" + timeLimit);
	}
}
