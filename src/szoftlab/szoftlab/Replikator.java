package szoftlab;

import szoftlab.Item.Direction;

public class Replikator extends Moving{
	public void collide(Bullet bullet,Direction dir){};
	public void collide(Box box,Direction dir){};
	public Replikator(Field f){this.currentPos=f;}


	@Override
    public String debugString() {
    	
    	return "r";
    }
}
