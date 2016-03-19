
public class Bullet extends Moving{
    public boolean isBlue;

    public Bullet(Field currentPos,Direction dir,boolean isBlue){
        this.isBlue = isBlue;
        create(currentPos,dir);
    }
    private void create(Field currentPos,Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        this.currentPos = currentPos;
        this.dir = dir;
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
