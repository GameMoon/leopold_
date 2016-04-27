package szoftlab;

public class Bullet extends Moving{
    public boolean isBlue;
    Wormhole worm;

    public Bullet(Field currentPos,Direction dir,boolean isBlue,Wormhole worm){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), currentPos, dir, isBlue);
        this.currentPos = currentPos;
        this.dir = dir;
        this.isBlue = isBlue;
        this.worm=worm;
        step();
    }
    public void step(){
        while(!blocked) {
           SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
            currentPos.exit(this,dir);
            currentPos.getNeighbor(dir).enter(this, dir);
        }
        destroy();
    }
    public void destroy(){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
    }
    public Wormhole getWormhole(){return worm;}
}
