package gamesuper07;

import java.util.LinkedList;

public class Ghost extends CharacterAttack{

	private LinkedList<Coin> myCoins = new LinkedList<Coin>();


	public void setMyCoins(LinkedList<Coin> myCoins) {
		this.myCoins = myCoins;
	}


	public Ghost() {
		x = 750;
		y = 200;
		xSize = 50;
		ySize = 50;
	}


	public void disappear(){
		int count = 0;
		for(Coin coin:myCoins){
			if(!coin.isAppear()){
				count++;
			}
			if(count == myCoins.size()){
				appearFlag = false;
			}
		}
	}

}
