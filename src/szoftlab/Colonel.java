
public class Colonel extends Moving {
    public Bullet bullet;
    private int score;
    private int maxscore;
    private boolean isBlue;
    public Box box;

    public Colonel(Field field,Direction dir){
        this.currentPos = field;
        this.dir = dir;
        isBlue = false;
    }
    public void shoot(){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        bullet = new Bullet(currentPos,dir,isBlue);
    }
    public void step(){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        currentPos.exit(this,dir);
        currentPos.getNeighbor(dir).enter(this, dir);
    }
    public void changeColor(){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        if(isBlue) isBlue = false;
        else isBlue = true;
    }
    public void die(){

    }
    public void setBox(Box box){
        this.box = box;
    }

}
