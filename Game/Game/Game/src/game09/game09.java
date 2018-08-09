package game09;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

class game09 extends GameBase {
	public static void main(String[] args) {
		new game09();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage playerImage;
	BufferedImage jewelBlueImage;

	// Model 変数定義
	Player player;
	Jewel jewel;

	public void initialize() {
		// View 画像ファイル読み込み
		backImage = cg.loadImage("/img/field_scroll.jpg");
		playerImage = cg.loadImage("/img/player.png");
		jewelBlueImage = cg.loadImage("/img/jewel_blue.png");

		// Model オブジェクト生成
		player = new Player(0, 0, 48, 48);
		jewel = new Jewel(300, 0, 48, 48);

		// Model オブジェクトの設定

		// Model オブジェクトの関連設定
	}

	public void play() {
		// キー入力
		if (key.isPress(KeyEvent.VK_RIGHT)) {
			player.goRight();
		}
		if (key.isPress(KeyEvent.VK_LEFT)) {
			player.goLeft();
		}
		if (key.isPress(KeyEvent.VK_UP)) {
			player.goUp();
		}
		if (key.isPress(KeyEvent.VK_DOWN)) {
			player.goDown();
		}
		if (key.getCode() == 0) {
			player.stop();
		}

		// マウス入力
		//   左ボタンをダブルクリックしたら、
		//   クリックした座標に宝石を移動
		if (mouse.getLeftClick() == 2) {
			int jx = mouse.getX();
			int jy = mouse.getY();
			jewel.warpTo(jx, jy);

			// なお、画面スクロール可能な状態なら、
			// 以下のように、プレーヤのX座標やY座標を
			// パラメータに追加する。
			// int jx = mouse.getX(player.getX());
			// int jy = mouse.getY(player.getY());
		}

		// Model 動作
		player.move();

		// View 表示
		drawBack();
		drawCharacter(player, playerImage);
		drawCharacter(jewel, jewelBlueImage);

	}

	private void drawBack() {
		// スクロールさせる時は
		// プレーヤのX座標とY座標を
		// パラメータの最後に追加する。
		int px = player.getX();
		int py = player.getY();
		cg.drawImage(0, 0, backImage, px, py);
	}

	private void drawCharacter(Character c, BufferedImage image) {
		// スクロールさせる時は
		// プレーヤのX座標とY座標を
		// パラメータの最後に追加する。
		int x = c.getX();
		int y = c.getY();
		int xSize = c.getXSize();
		int ySize = c.getYSize();
		int px = player.getX();
		int py = player.getY();
		cg.drawImage(x, y, xSize, ySize, image, px, py);
	}
}
