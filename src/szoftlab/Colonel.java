
public class Colonel extends Moving {
    public Bullet bullet;
    private int score;
    private int maxscore;
    public Box box;

    public Colonel(Field field){
        this.currentpos = field;
    }
    public void die(){

    }
    public void setBox(Box box){
        this.box = box;
    }
    public void shot(){
    }
    public void step(){
        currentpos.exit(this,dir);
        currentpos.getNeighbor(dir).enter(this,dir);
    }
    public void relocate(Field newField){
        sequencetester.printMethod(
                Thread.currentThread().getStackTrace()[1].getClassName(),
                Thread.currentThread().getStackTrace()[1].getMethodName()
        );
        if(!blocked){
            currentpos.remove(this);
            currentpos = newField;
            currentpos.add(this);
        }
    }
}
