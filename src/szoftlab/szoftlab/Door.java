package szoftlab;

import java.io.File;
import java.io.IOException;

public class Door extends Item{
    private boolean status = false; //true is open
    private int serialnumber;
    public Door(int s){
    	serialnumber=s;
        try {
            drawable.loadImage(new File("images/door.png").getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int Getserialnumber(){
    	return serialnumber;
    }
    public void open(){
        drawable.visible = false;
        status = true;
    }
    public void close(){
        drawable.visible = true;
        status = false;
    }
    public void collide(Colonel colonel,Direction dir){
        if(!status) colonel.setBlocked(true);
    }
    public void collide(Replikator replikator,Direction dir){
        if(!status) replikator.setBlocked(true);
    }
    public void collide(Bullet bullet,Direction dir){
        if(!status) bullet.setBlocked(true);
    }
    @Override
    public String debugString() {
    	if(status){
    	return "+<"+serialnumber+">";
    	}
    	else return "<"+serialnumber+">";
    }
}
