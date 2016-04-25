package szoftlab;

import szoftlab.Item.Direction;

import java.util.Random;

public class Replikator extends Moving{
	private boolean isRandom = true;
	public void setRandom(boolean random){
		isRandom = random;
	}
	public void collide(Bullet bullet,Direction dir){
		currentPos.remove(this);
	}
	public void die(Rift rift){
		currentPos.remove(this);
		currentPos.remove(rift);
	}
	public void step(){
		if(isRandom){
			Random rdm = new Random();
			int rdmValue = rdm.nextInt(3);
			if(rdmValue == 0) rotate(Direction.up);
			else if(rdmValue == 1) rotate(Direction.down);
			else if(rdmValue == 2) rotate(Direction.right);
			else if(rdmValue == 3) rotate(Direction.left);
		}
		else{
			rotate(Direction.left);
		}
		currentPos.exit(this,dir);
		currentPos.getNeighbor(dir).enter(this, dir);
	}
}
