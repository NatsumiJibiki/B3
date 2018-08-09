package gamesuper06;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class GameSuper06 extends GameBase {

	public static void main(String[] args) {
		new GameSuper06();
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
	BufferedImage blockImage;


	// Model 変数定義
	PlayerSuper player;
	Dog dog;
	Coin coin;
	Cloud cloud;
	Pole pole;
	Flag flag;
	Castle castle;
	Bridge bridge;
	Bridge bridge2;
	Bridge bridge3;
	Bridge bridge4;
	Bridge bridge5;
	Bridge bridge6;
	Block block;
	Block block2;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/sea.jpg");
		bridgeImage = cg.loadImage("/img/bridge.png");
		dogRightImage = cg.loadImage("/img/dog_right.png");
		dogLeftImage = cg.loadImage("/img/dog_left.png");
		coinImage = cg.loadImage("/img/coin.png");
		cloudImage = cg.loadImage("/img/cloud.png");
		poleImage = cg.loadImage("/img/pole.gif");
		flagImage = cg.loadImage("/img/flag.gif");
		castleImage = cg.loadImage("/img/castle.png");
		playerImage = cg.loadImage("/img/player.png");
		blockImage = cg.loadImage("/img/block.gif");

		// Model オブジェクト生成
		dog = new Dog();
		coin = new Coin();
		cloud = new Cloud();
		castle = new Castle();
		pole = new Pole();
		flag = new Flag();
		player = new PlayerSuper();
		bridge = new Bridge(0,0,100,20);
		bridge2 = new Bridge(200,0,100,20);
		bridge3 = new Bridge(400,0,100,20);
		bridge4 = new Bridge(500,0,100,20);
		bridge5 = new Bridge(600,0,100,20);
		bridge6 = new Bridge(700,0,100,20);
		block = new Block(330,80,24,24);
		block2 = new Block(354,80,24,24);


		// Model オブジェクト関連付け
		player.setFlag(flag);
		flag.setCastle(castle);
		castle.setPlayerSupper(player);
		bridge.setPlayerSuper(player);
		bridge2.setPlayerSuper(player);
		bridge3.setPlayerSuper(player);
		bridge4.setPlayerSuper(player);
		bridge5.setPlayerSuper(player);
		bridge6.setPlayerSuper(player);
		block.setPlayerSuper(player);
		block2.setPlayerSuper(player);
		cloud.setPlayerSuper(player);
		coin.setMyPlayer(player);



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
		dog.move();
		cloud.move();
		flag.move();
		castle.move();
		player.move();

		bridge.support();
		bridge2.support();
		bridge3.support();
		bridge4.support();
		bridge5.support();
		bridge6.support();
		block.support();
		block2.support();
		cloud.support();
		coin.taked();



		// View 画面表示

		// 背景表示
		cg.drawImage(0, 0, backImage);

		// Bridge 表示
		drawBridge(bridge);
		drawBridge(bridge2);
		drawBridge(bridge3);
		drawBridge(bridge4);
		drawBridge(bridge5);
		drawBridge(bridge6);

		// Block 表示
		drawBlock(block);
		drawBlock(block2);


		// Pole 表示
		int polex = pole.getX();
		int poley = pole.getY();
		int polexSize = pole.getXSize();
		int poleySize = pole.getYSize();
		cg.drawImage(polex, poley, polexSize, poleySize, poleImage);

		// Flag 表示
		int flagx = flag.getX();
		int flagy = flag.getY();
		int flagxSize = flag.getXSize();
		int flagySize = flag.getYSize();
		cg.drawImage(flagx, flagy, flagxSize, flagySize, flagImage);

		// Castle表示
		if (castle.isAppear()) {
			int castlex = castle.getX();
			int castley = castle.getY();
			int castlexSize = castle.getXSize();
			int castleySize = castle.getYSize();
			cg.drawImage(castlex, castley, castlexSize, castleySize, castleImage);
		}

		// Dog表示
		int dogx = dog.getX();
		int dogy = dog.getY();
		int dogxSize = dog.getXSize();
		int dogySize = dog.getYSize();
		int dogxSpeed = dog.getXSpeed();
		if (dogxSpeed > 0) {
			cg.drawImage(dogx, dogy, dogxSize, dogySize, dogRightImage);
		} else {
			cg.drawImage(dogx, dogy, dogxSize, dogySize, dogLeftImage);
		}

		// Coin表示
		if(coin.isAppear()){
		int coinx = coin.getX();
		int coiny = coin.getY();
		int coinxSize = coin.getXSize();
		int coinySize = coin.getYSize();
		cg.drawImage(coinx, coiny, coinxSize, coinySize, coinImage);
		}

		// Cloud表示
		int cloudx = cloud.getX();
		int cloudy = cloud.getY();
		int cloudxSize = cloud.getXSize();
		int cloudySize = cloud.getYSize();
		cg.drawImage(cloudx, cloudy, cloudxSize, cloudySize, cloudImage);

		// Player表示
		int playerx = player.getX();
		int playery = player.getY();
		int playerxSize = player.getXSize();
		int playerySize = player.getYSize();
		cg.drawImage(playerx, playery, playerxSize, playerySize, playerImage);

		// Status表示
		drawStatus();
		if (player.isDead()) {
			drawGameOver();
		} else if (player.isGoal()) {
			drawGameClear();
		}
	}


	// =============================================
	// Draw Status
	// =============================================
	private void drawStatus() {
		cg.setColor(Color.BLACK);
		cg.fillRect(655, 340, 135, 46);

		drawScore();
		drawTimeLimit();
	}

	private void drawScore() {
		int score = player.getScore();
		cg.setColor(Color.GREEN);
		cg.setFont(new Font("SansSerif", Font.BOLD, 20));
		cg.drawStringLeft(660, 365, "Score");
		cg.drawStringRight(785, 365, "" + score);
	}

	private void drawTimeLimit() {
		int timeLimit = player.getTimeLimit();
		cg.setColor(Color.RED);
		cg.setFont(new Font("SansSerif", Font.BOLD, 20));
		cg.drawStringLeft(660, 345, "Limit");
		cg.drawStringRight(785, 345, "" + timeLimit);
	}

	private void drawGameClear() {
		cg.setColor(Color.BLUE);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
		cg.drawStringCenter(400, 200, "Game Clear !!");
	}

	private void drawGameOver() {
		cg.setColor(Color.RED);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
		cg.drawStringCenter(400, 200, "Game Over !!");
	}

	public void drawBridge(Bridge bridge){
		int bx = bridge.getX();
		int by = bridge.getY();
		int bxSize = bridge.getXSize();
		int bySize = bridge.getYSize();
		cg.drawImage(bx, by, bxSize, bySize, bridgeImage);
	}

	public void drawBlock(Block block){
		int bx = block.getX();
		int by = block.getY();
		int bxSize = block.getXSize();
		int bySize = block.getYSize();
		cg.drawImage(bx, by, bxSize, bySize, blockImage);
	}
}
