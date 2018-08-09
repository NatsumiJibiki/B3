package game02;

import game02.Player;
import game02.MovingHole;
import game02.Crow;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class Game02 extends GameBase {

	public static void main(String[] args) {
		new Game02();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage playerImage;
	BufferedImage crowRightImage;
	BufferedImage crowLeftImage;

	// Model 変数定義
	Player player;
	MovingHole movingHole;
	Crow crow;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/sky.jpg");
		playerImage = cg.loadImage("/img/player.png");
		crowRightImage = cg.loadImage("/img/crow_right.png");
		crowLeftImage = cg.loadImage("/img/crow_left.png");

		// Model オブジェクト生成
		player = new Player();
		movingHole = new MovingHole();
		crow = new Crow();
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

		// View 画面表示

		// 背景表示
		cg.drawImage(0, 0, backImage);

		// 地面表示
		cg.setColor(new Color(75, 35, 25));
		cg.fillRect(0, 0, 620, 20);


		//動く穴表示
		int mx=movingHole.getX();
		int my=movingHole.getY();
		int mxsize=movingHole.getXSize();
		int mysize=movingHole.getYSize();
		cg.setColor(new Color(0,0,0));
		cg.fillRect(mx, my, mxsize, mysize);

		//Crow表示
		int cx = crow.getX();
		int cy = crow.getY();
		int cxSize = crow.getXSize();
		int cySize = crow.getYSize();
		int cxSpeed = crow.getXSpeed();
		if(cxSpeed > 0){
			cg.drawImage(cx,cy,cxSize,cySize,crowRightImage);
		}else{
			cg.drawImage(cx,cy,cxSize,cySize,crowLeftImage);
		}

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
	}
}
