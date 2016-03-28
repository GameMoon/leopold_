package szoftlab;

public class Bullet extends Moving{
    public boolean isBlue;

    public Bullet(Field currentPos,Direction dir,boolean isBlue){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),currentPos,dir,isBlue);
        this.currentPos = currentPos;
        this.dir = dir;
        this.isBlue = isBlue;
        step();
    }
    public void step(){
        while(!blocked) {
           sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
            currentPos.exit(this,dir);
            currentPos.getNeighbor(dir).enter(this, dir);
        }
        destroy();
    }
    public void destroy(){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
    }
}
