package Original;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

class Original extends GameBase {

	public static void main(String[] args) {
		new Original();
	}

	// View 変数定義
	BufferedImage backImage;
	BufferedImage rockImage;
	BufferedImage gullImage;
	BufferedImage supplyImage;
	BufferedImage bullet_leftImage;
	BufferedImage bullet_rightImage;
	BufferedImage enemyImage;
	BufferedImage whaleImage;
	BufferedImage lanceImage;
	BufferedImage playerImage;
	BufferedImage torpedoImage;
	BufferedImage fishImage;


	// Model 変数定義
	Playership player;
	Enemyship enemy;
	Supplyship supply;
	Whale whale;
	Lance lance;
	Torpedo torpedo;
	Fish fish;

	LinkedList<Gull> gulls;
	LinkedList<Rock> rocks;
	LinkedList<Bullet> p_bullets;
	LinkedList<Bullet> e_bullets;

	public void initialize() {
		img();

		object_generate();

		object_linkage();
	}

	public void play() {
		key_input();

		motioncontrol();

		view();

	}


	// =============================================
	// Initialize
	// =============================================
	public void img(){
		// View 画像ファイル読み込み
		bullet_leftImage = cg.loadImage("/Original_img/bullet_left.png");
		bullet_rightImage = cg.loadImage("/Original_img/bullet_right.png");
		enemyImage = cg.loadImage("/Original_img/enemyship.png");
		gullImage = cg.loadImage("/Original_img/gull.png");
		lanceImage = cg.loadImage("/Original_img/lance.png");
		playerImage = cg.loadImage("/Original_img/playership.png");
		rockImage = cg.loadImage("/Original_img/rock.png");
		backImage = cg.loadImage("/Original_img/sea_original.jpg");
		supplyImage = cg.loadImage("/Original_img/supplyship.png");
		whaleImage = cg.loadImage("/Original_img/whale.png");
		torpedoImage = cg.loadImage("/Original_img/torpedo.png");
		fishImage = cg.loadImage("/Original_img/fish.png");
	}

	public void object_generate(){
		// Model オブジェクト生成

		gulls = new LinkedList<Gull>();
		int gulls0x = (int)(Math.random()*350)+1;
		gulls.add(new Gull(gulls0x,-7));
		int gulls1x = (int)(Math.random()*350)+1;

		while(gulls1x < gulls0x + 150 && gulls1x > gulls0x-150){
			gulls1x = (int)(Math.random()*350)+1;
		}
		gulls.add(new Gull(gulls1x,-6));


		rocks = new LinkedList<Rock>();
		int rocks0x = (int)(Math.random()*350)+1;
		rocks.add(new Rock(rocks0x,-2));
		int rocks1x = (int)(Math.random()*350)+1;

		while(rocks1x < rocks0x + 170 && rocks1x > rocks0x-100){
			rocks1x = (int)(Math.random()*350)+1;
		}
		rocks.add(new Rock(rocks1x,-1));


		p_bullets = new LinkedList<Bullet>();
		e_bullets = new LinkedList<Bullet>();
		player = new Playership();
		enemy = new Enemyship(((int) (Math.random() * 250) + 1));
		supply = new Supplyship(((int) (Math.random() * 100) + 1));
		whale = new Whale();
		lance = new Lance();
		torpedo = new Torpedo((int)(Math.random()*350)+1);
		fish = new Fish((int)(Math.random()*350)+1);
		for(int i=0;i<5;i++){
			p_bullets.add(new Bullet());
		}
		for(int i=0;i<3;i++){
			e_bullets.add(new Bullet());
		}

	}

	public void object_linkage() {
		// Model オブジェクト関連付け
		supply.setPlayership(player);

		enemy.setPlayership(player);

		lance.setWhale(whale);

		player.setLance(lance);

		torpedo.setPlayership(player);

		fish.setPlayership(player);

		for (Bullet bullet : p_bullets) {
			player.setBullet(bullet);
			for (Gull gull : gulls) {
				bullet.setGull(gull);
			}
			bullet.setEnemyship(enemy);
		}

		for (Bullet bullet : e_bullets) {
			enemy.setBullet(bullet);
			bullet.setPlayership(player);
			bullet.setE_bullet(bullet);
		}

		for (Gull gull : gulls) {
			gull.setPlayership(player);
		}

		for (Rock rock : rocks) {
			rock.setPlayership(player);
		}
	}


	// =============================================
	// Play
	// =============================================
	public void key_input() {
		// View キー入力
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

		if (key.isPress(KeyEvent.VK_SPACE)) {
			player.launch();
		} else {
			player.notLaunched();
		}

		if (key.isPress(KeyEvent.VK_ENTER)) {
			player.Lancer();
		}else{
			player.notLancerd();
		}
	}

	public void motioncontrol() {
		// Model 動作
		if(!enemy.isAppear()){
			whale.move();
		}
		if(whale.isGoal()){
			whale.stop();
		}

		for (Gull gull : gulls) {
			gull.move();
			gull.kill();
		}
		for (Rock rock : rocks) {
			rock.move();
			rock.kill();
		}
		for (Bullet bullet : p_bullets) {
			bullet.move();
			bullet.kill_gull();
			bullet.kill_enemy();
		}

		supply.move();
		supply.lifeup();
		torpedo.move();
		torpedo.bullet_up();
		fish.move();
		fish.score_up();

		if(enemy.isAppear()){
			enemy.move();
			enemy.kill();
			enemy.launch();
			for (Bullet bullet : e_bullets) {
				bullet.move();
				bullet.kill_player();
			}

		}
		enemy.breakship();
		player.breakship();
		lance.get_whale();

		//岩、かもめ画面外
		if(!gulls.get(0).isAppear()){
			gulls.get(0).appear(-7);
		}
		if(!gulls.get(1).isAppear()){
			gulls.get(1).appear(-6);
		}

		if(!rocks.get(0).isAppear()){
			rocks.get(0).appear(-2);
		}
		if(!rocks.get(1).isAppear()){
			rocks.get(1).appear(-1);
		}
		if(!torpedo.isAppear()){
			torpedo.appear();
		}
		if(!fish.isAppear()){
			fish.appear();
		}

	}

	public void view() {
		// View 画面表示
		drawBack();

		for (Rock rock : rocks) {
			drawCharacter(rock, rockImage);
		}

		for (Gull gull : gulls) {
			drawCharacter(gull, gullImage);
		}

		for (Bullet bullet : p_bullets) {
			drawCharacter(bullet, bullet_rightImage);
		}

		for (Bullet bullet : e_bullets) {
			drawCharacter(bullet, bullet_leftImage);
		}

		drawCharacter(supply,supplyImage);

		drawCharacter(enemy,enemyImage);

		drawCharacter(lance,lanceImage);

		drawCharacter(torpedo,torpedoImage);

		drawCharacter(fish,fishImage);

		drawCharacter(whale,whaleImage);

		drawCharacter(player,playerImage);

		if(player.isDead()){
			drawGameOver();
		}else if(whale.isGoal()){
			drawGameClear();
		}

		drawStatus();
	}


	// =============================================
	// Draw Characters
	// =============================================
	private void drawBack() {
		cg.drawImage(0, 0, backImage, player.getX(), player.getY());
	}

	private void drawCharacter(Character character, BufferedImage characterImage) {
		if (character.isAppear() == true) {
			int x = character.getX();
			int y = character.getY();
			int xSize = character.getXSize();
			int ySize = character.getYSize();
			cg.drawImage(x, y, xSize, ySize, characterImage, player.getX(), player.getY());
		}
	}

	// =============================================
	// Draw Status
	// =============================================
	private void drawStatus() {
		cg.setColor(Color.BLACK);
		cg.fillRect(X_LENGTH - 145, 340, 135, 46);

		drawScore(player.getScore());
		drawLife(player.getLife());
	}

	private void drawScore(int score) {
		cg.setColor(Color.RED);
		cg.setFont(new Font("SansSerif", Font.BOLD, 20));
		cg.drawStringLeft(X_LENGTH - 140, 345, "Score");
		cg.drawStringRight(X_LENGTH - 15, 345, "" + score);
	}

	private void drawLife(int life) {
		cg.setColor(Color.GREEN);
		cg.setFont(new Font("SansSerif", Font.BOLD, 20));
		cg.drawStringLeft(X_LENGTH - 140, 365, "Life");
		cg.drawStringRight(X_LENGTH - 15, 365, "" +life++);
	}


	private void drawGameOver() {
		cg.setColor(Color.RED);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
		cg.drawStringCenter(X_LENGTH / 2, 200, "Game Over !!");
	}

	private void drawGameClear() {
		cg.setColor(Color.YELLOW);
		cg.setFont(new Font("MS明朝", Font.PLAIN, 48));
		cg.drawStringCenter(X_LENGTH / 2, 200, "Game Clear !");
	}

}
