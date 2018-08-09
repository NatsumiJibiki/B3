package gamesuper02;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import gamesuper02.Cloud;
import gamesuper02.Coin;
import gamesuper02.Dog;
import gamesuper02.PlayerSuper;

class GameSuper02 extends GameBase {

	public static void main(String[] args) {
		new GameSuper02();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage bridgeImage;
	BufferedImage playerImage;
	BufferedImage cloudImage;
	BufferedImage dogRightImage;
	BufferedImage dogLeftImage;
	BufferedImage coinImage;

	// Model 変数定義
	PlayerSuper player;
	Cloud cloud;
	Dog dog;
	Coin coin;


	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/sea.jpg");
		bridgeImage = cg.loadImage("/img/bridge.png");
		playerImage = cg.loadImage("/img/player.png");
		cloudImage = cg.loadImage("/img/cloud.png");
		dogRightImage = cg.loadImage("/img/dog_right.png");
		dogLeftImage = cg.loadImage("/img/dog_left.png");
		coinImage = cg.loadImage("/img/coin.png");

		// Model オブジェクト生成
		player = new PlayerSuper();
		cloud = new Cloud();
		dog = new Dog();
		coin = new Coin();
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
		cloud.move();
		dog.move();

		// View 画面表示
		drawBack();
		drawGround();
		drawPlayer();
		drawStatus();
		drawCloud();
		drawDog();
		drawCoin();
	}

	//=============================================
	// Draw Characters
	//=============================================
	private void drawBack() {
		cg.drawImage(0, 0, backImage);
	}

	private void drawGround() {
		for (int x = 0; x < 640; x+=100) {
			cg.drawImage(x,0,100,20,bridgeImage);
		}
	}

	private void drawPlayer(){
		int x = player.getX();
		int y = player.getY();
		int xSize = player.getXSize();
		int ySize = player.getYSize();
		cg.drawImage(x, y, xSize, ySize, playerImage);
	}

	private void drawCloud(){
		int x = cloud.getX();
		int y = cloud.getY();
		int xSize = cloud.getXSize();
		int ySize = cloud.getYSize();
		cg.drawImage(x, y, xSize, ySize, cloudImage);
	}

	private void drawDog(){
		int x = dog.getX();
		int y = dog.getY();
		int xSize = dog.getXSize();
		int ySize = dog.getYSize();
		int xSpeed = dog.getXSpeed();
		if(xSpeed > 0){
			cg.drawImage(x,y,xSize,ySize,dogRightImage);
		}else{
			cg.drawImage(x,y,xSize,ySize,dogLeftImage);
		}
	}

	private void drawCoin(){
		int x = coin.getX();
		int y = coin.getY();
		int xSize = coin.getXSize();
		int ySize = coin.getYSize();
		cg.drawImage(x, y, xSize, ySize, coinImage);
	}

	//=============================================
	// Draw  Status
	//=============================================
	private void drawStatus() {
		cg.setColor(Color.BLACK);
		cg.fillRect(455, 340, 135, 46);

		drawScore();
		drawTimeLimit();
	}

	private void drawScore() {
		int score = player.getScore();
		cg.setColor(Color.GREEN);
		cg.setFont(new Font("SansSerif", Font.BOLD, 20));
		cg.drawStringLeft(460,365,"Score");
		cg.drawStringRight(585,365,""+score);
	}

	private void drawTimeLimit() {
		int timeLimit = player.getTimeLimit();
		cg.setColor(Color.RED);
		cg.setFont(new Font("SansSerif", Font.BOLD, 20));
		cg.drawStringLeft(460,345,"Limit");
		cg.drawStringRight(585,345,""+timeLimit);
	}

}
