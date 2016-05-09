package szoftlab;

import java.io.File;
import java.io.IOException;

public class Wall extends Item{
    public Wall(){
        try {
            drawable.loadImage(new File("images/wall.png").getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void collide(Colonel colonel,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), colonel, dir);
        colonel.setBlocked(true);
    }
    public void collide(Bullet bullet,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), bullet, dir);
        bullet.setBlocked(true);
    }
    @Override
    public String debugString() {
    	
    	return "W";
    }
}
