package szoftlab;

import java.io.File;
import java.io.IOException;

public class PortalWall extends Wall {
    private Field field;

    public PortalWall(Field field){
        this.field = field;
        drawable.loadImage("images/portalwall.png");
    }
    public void collide(Bullet bullet,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), bullet, dir);
        bullet.getWormhole().open(field, dir); //dir ellent�tes
        bullet.setBlocked(true);
    }
    @Override
    public String debugString() {
    	
    	return "P";
    }
}
//10-12
