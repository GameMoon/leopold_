package szoftlab;

public class Bullet extends Moving{
    public boolean isBlue;

    public Bullet(Field currentPos,Direction dir,boolean isBlue){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        this.currentPos = currentPos;
        this.dir = dir;
        this.isBlue = isBlue;
        step();
    }
    public void step(){
        while(!blocked) {
            sequencetester.printMethod(Thread.currentThread().getStackTrace());
            currentPos.exit(this,dir);
            currentPos.getNeighbor(dir).enter(this, dir);
        }
        destroy();
    }
    public void destroy(){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
    }
}
