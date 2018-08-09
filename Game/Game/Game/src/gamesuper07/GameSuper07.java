package gamesuper07;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

class GameSuper07 extends GameBase {

	public static void main(String[] args) {
		new GameSuper07();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage bridgeImage;
	BufferedImage blockImage;
	BufferedImage dogRightImage;
	BufferedImage dogLeftImage;
	BufferedImage coinImage;
	BufferedImage cloudImage;
	BufferedImage poleImage;
	BufferedImage flagImage;
	BufferedImage castleImage;
	BufferedImage playerImage;
	BufferedImage pipeImage;
	BufferedImage ghostImage;
	BufferedImage bulletImage;
	BufferedImage flowerImage;

	// Model 変数定義
	PlayerSuper player;
	Dog dog;
	Cloud cloud;
	Pole pole;
	Flag flag;
	Castle castle;
	Ghost ghost;
	Bullet bullet;
	Flower flower;

	LinkedList<Coin> coins;
	LinkedList<Bridge> bridges;
	LinkedList<Block> blocks;
	LinkedList<Pipe> pipes;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/sea.jpg");
		blockImage = cg.loadImage("/img/block.gif");
		bridgeImage = cg.loadImage("/img/bridge.png");
		dogRightImage = cg.loadImage("/img/dog_right.png");
		dogLeftImage = cg.loadImage("/img/dog_left.png");
		coinImage = cg.loadImage("/img/coin.png");
		cloudImage = cg.loadImage("/img/cloud.png");
		poleImage = cg.loadImage("/img/pole.gif");
		flagImage = cg.loadImage("/img/flag.gif");
		castleImage = cg.loadImage("/img/castle.png");
		playerImage = cg.loadImage("/img/player.png");
		pipeImage = cg.loadImage("/img/pipe.png");
		ghostImage = cg.loadImage("/img/ghost.png");
		bulletImage = cg.loadImage("/img/bullet.png");
		flowerImage = cg.loadImage("/img/flower.png");

		// Model オブジェクト生成
		coins = new LinkedList<Coin>();
		bridges = new LinkedList<Bridge>();
		blocks = new LinkedList<Block>();
		pipes = new LinkedList<Pipe>();

		dog = new Dog();
		cloud = new Cloud();
		castle = new Castle();
		pole = new Pole();
		flag = new Flag();
		player = new PlayerSuper();
		ghost = new Ghost();
		bullet = new Bullet();
		flower = new Flower();

		coins.add(new Coin(300, 300));
		coins.add(new Coin(420, 300));
		coins.add(new Coin(535, 300));
		coins.add(new Coin(630, 300));
		bridges.add(new Bridge(0, 0));
		bridges.add(new Bridge(200, 0));
		bridges.add(new Bridge(400, 0));
		bridges.add(new Bridge(500, 0));
		bridges.add(new Bridge(600, 0));
		bridges.add(new Bridge(700, 180));
		blocks.add(new Block(330, 80));
		blocks.add(new Block(354, 80));
		pipes.add(new Pipe(420, 130,45,60));
		pipes.add(new Pipe(540, 145,35,50));
		pipes.add(new Pipe(640, 160,25,40));

		// Model オブジェクト関連付け
		cloud.setPlayerSuper(player);
		pole.setPlayerSuper(player);
		flag.setPole(pole);
		castle.setFlag(flag);
		castle.setPlayerSupper(player);
		dog.setPlayerSuper(player);
		ghost.setPlayerSuper(player);
		castle.setMyGhost(ghost);
		bullet.setPlayerSuper(player);
		flower.setPlayerSuper(player);

		for (Coin coin : coins) {
			coin.setPlayerSuper(player);
			ghost.setMyCoins(coins);
		}
		for (Bridge bridge : bridges) {
			bridge.setPlayerSuper(player);
		}
		for (Block block : blocks) {
			block.setPlayerSuper(player);
		}
		for (Pipe pipe : pipes) {
			pipe.setPlayerSuper(player);
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

		dog.move();
		dog.attack();

		for (Coin coin : coins) {
			coin.taked();
		}

		pole.move();
		flag.move();
		castle.appear();
		castle.welcome();
		bullet.move();
		bullet.attack();
		flower.move();
		flower.attack();

		cloud.move();
		cloud.support();

		ghost.attack();
		ghost.disappear();
		for (Bridge bridge : bridges) {
			bridge.support();
		}
		for (Block block : blocks) {
			block.support();
		}
		for (Pipe pipe : pipes) {
			pipe.support();
		}

		// View 画面表示
		drawBack();
		drawDog(dog);
		drawCharacter(flag, flagImage);
		drawCharacter(pole, poleImage);
		drawCharacter(castle, castleImage);
		drawCharacter(cloud, cloudImage);
		drawCharacter(ghost, ghostImage);
		drawCharacter(bullet, bulletImage);
		drawCharacter(flower, flowerImage);

		for(Coin coin :coins){
			drawCharacter(coin, coinImage);
		}
		for (Bridge bridge : bridges) {
			drawCharacter(bridge, bridgeImage);
		}
		for (Block block : blocks) {
			drawCharacter(block, blockImage);
		}
		for (Pipe pipe : pipes) {
			drawCharacter(pipe, pipeImage);
		}

		drawCharacter(player, playerImage);

		drawStatus();
		if (player.isDead()) {
			drawGameOver();
		} else if (castle.isGoal()) {
			drawGameClear();
		}
	}

	// =============================================
	// Draw Characters
	// =============================================
	private void drawBack() {
		cg.drawImage(0, 0, backImage);
	}

	private void drawCharacter(Character c, BufferedImage image) {
		if (c.isAppear()) {
			int x = c.getX();
			int y = c.getY();
			int xSize = c.getXSize();
			int ySize = c.getYSize();
			cg.drawImage(x, y, xSize, ySize, image);
		}
	}

	private void drawDog(Dog dog) {
		int x = dog.getX();
		int y = dog.getY();
		int xSize = dog.getXSize();
		int ySize = dog.getYSize();
		int xSpeed = dog.getXSpeed();
		if (xSpeed > 0) {
			cg.drawImage(x, y, xSize, ySize, dogRightImage);
		} else {
			cg.drawImage(x, y, xSize, ySize, dogLeftImage);
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
}
