package gamesuper01;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class GameSuper01<cloud> extends GameBase {

	public static void main(String[] args) {
		new GameSuper01();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage playerImage;
	BufferedImage bridgeImage;

	// Model 変数定義
	PlayerSuper cloud;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/sea.jpg");
		playerImage = cg.loadImage("/img/player.png");
		bridgeImage = cg.loadImage("/img/bridge.png");


		// Model オブジェクト生成
		cloud = new PlayerSuper();

	}

	public void play() {
		// View キー入力
		if(key.isPress(KeyEvent.VK_RIGHT)){
			cloud.goRight();
		}
		if(key.isPress(KeyEvent.VK_LEFT)){
			cloud.goLeft();
		}

		// Model 動作
		int x = cloud.getX();
		int y = cloud.getY();
		int xs = cloud.getXsize();
		int ys = cloud.getYsize();
		int score = cloud.getscore();
		int limit = cloud.getlimit();

		// View 画面表示
		cg.drawImage(0, 0, backImage);
		for(int i=0;i<600;i+=100){
			cg.drawImage(i, 0,100,20,bridgeImage);
		}
		cg.drawImage(300, 0,300,20,bridgeImage);
		cg.drawImage(x, y,xs,ys, playerImage);

		cg.drawRect(455, 340, 135, 45);
		cg.fillRect(455, 340, 135, 45);
		cg.setColor(new Color(153,255,0));
		cg.setFont(new Font("SansSerif",Font.BOLD,20));
		cg.drawStringLeft(455, 360, "Score           "+score++);
		cg.setColor(new Color(255,0,0));
		cg.setFont(new Font("SansSerif",Font.BOLD,20));
		cg.drawStringLeft(455, 340, "Limit       "+limit++);
	}

}
