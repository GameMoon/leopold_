package szoftlab;

import java.io.File;
import java.io.IOException;

public class Scale extends Item {
    private Door door;
    private int minWeight;
    private int currentWeight=0;
    public Scale(int min){
        this.minWeight=min;
        drawable.loadImage("images/scale.png");
    }
    public void collide(Colonel colonel,Direction dir){
        press(colonel);
    }
    public void collide(Box box,Direction dir){
        press(box);
    }
    public void collide(Replikator replikator,Direction dir){
        replikator.setBlocked(true);
    }
    public void press(Item i){
        currentWeight+=i.getWeight();
        if(currentWeight>=minWeight){
        	door.open();
        }
    }
    @Override
    public void release(Item i){
        currentWeight-=i.getWeight();
        if (currentWeight<minWeight){
        	 door.close();
        }
    }
    public void setDoor(Door door){
    	this.door=door;
    }
    @Override
    public String debugString() {
    	
    	return "-<"+door.Getserialnumber()+">";
    }
}
