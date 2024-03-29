package szoftlab;

import szoftlab.Item.Direction;

import java.util.Random;

public class Replikator extends Moving{
	public Replikator(Field f){
		this.currentPos=f;
		drawable.loadSprite("images/replikator.png",64,false);
	}
	private boolean isRandom = true;
	public void setRandom(boolean random){
		isRandom = random;
	}
	public void collide(Bullet bullet,Direction dir){
		currentPos.remove(this);
        currentPos = null;
	}
    public void collide(Colonel colonel,Direction dir){
        colonel.setBlocked(true);
    }
	public void die(Rift rift){
        currentPos.remove(this);
        currentPos.getNeighbor(dir).remove(rift);
        currentPos = null;
	}
	public void step(){
        if(currentPos == null) return;
		if(isRandom){
			Random rdm = new Random();
			int rdmValue = rdm.nextInt(4);
			if(rdmValue == 0) rotate(Direction.up);
			else if(rdmValue == 1) rotate(Direction.down);
			else if(rdmValue == 2) rotate(Direction.right);
			else if(rdmValue == 3) rotate(Direction.left);
		}
		else{
			rotate(Direction.left);
		}
        drawable.setState(dir,0);
		currentPos.exit(this,dir);
		currentPos.getNeighbor(dir).enter(this, dir);
	}

	@Override
    public String debugString() {
    	
    	return "r";
    }
}
