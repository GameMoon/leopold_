package szoftlab;

import java.io.File;

public class Bullet extends Moving{
    public boolean isBlue;
    Wormhole worm;

    public Bullet(Field currentPos,Direction dir,boolean isBlue,Wormhole worm){
        this.currentPos = currentPos;
        this.dir = dir;
        this.isBlue = isBlue;
        this.worm=worm;
        step();
    }
    public void step(){
        while(!blocked) {
            currentPos.exit(this,dir);
            currentPos.getNeighbor(dir).enter(this, dir);
        }
        destroy();
    }
    public void destroy(){
        currentPos.remove(this);
    }
    public Wormhole getWormhole(){return worm;}
}
