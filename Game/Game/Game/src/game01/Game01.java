package game01;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class Game01 extends GameBase {

	public static void main(String[] args) {
		new Game01();
	}

	// 変数定義
	BufferedImage backImage;
	BufferedImage playerImage;
	Player cloud;

	// 初期設定
	public void initialize() {
		backImage = cg.loadImage("/img/sky.jpg");
		playerImage = cg.loadImage("/img/player.png");

		cloud = new Player();

	}

	// 処理
	public void play() {
		if(key.isPress(KeyEvent.VK_RIGHT)){
			cloud.goRight();
		}
		if(key.isPress(KeyEvent.VK_LEFT)){
			cloud.goLeft();
		}

		cg.drawImage(0, 0, backImage);

		int x = cloud.getX();
		int y = cloud.getY();
		int xs = cloud.getXsize();
		int ys = cloud.getYsize();
		cg.drawImage(x, y,xs,ys, playerImage);

	}
}
