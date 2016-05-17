package szoftlab;

import java.io.File;
import java.io.IOException;

public class Wall extends Item{
    public Wall(){
        drawable.loadImage("images/wall.png");
    }
    public void collide(Colonel colonel,Direction dir){
        colonel.setBlocked(true);
    }
    public void collide(Replikator replikator,Direction dir){
        replikator.setBlocked(true);
    }
    public void collide(Bullet bullet,Direction dir){
        bullet.setBlocked(true);
    }
    public void collide(Hand hand,Direction dir){
        hand.setBlocked(true);
    }
    @Override
    public String debugString() {
    	
    	return "W";
    }
}
