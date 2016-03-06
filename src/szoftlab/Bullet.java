package szoftlab;

public class Bullet extends Item{
	private boolean isFlying = false;
	private int direction = 0;
	private int type = 0;
	
	public void fire(int speed){
		isFlying = true;
	}
}
