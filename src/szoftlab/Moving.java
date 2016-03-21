package szoftlab;

public class Moving extends Item{
    protected Field currentPos;
    protected Direction dir;
    protected boolean blocked;

    public void setBlocked(boolean status){
        blocked = status;
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
    }
    public void relocate(Field newField){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        if(!blocked){
            currentPos.remove(this);
            currentPos = newField;
            currentPos.add(this);
        }
    }
    public void rotate(Direction dir){
        this.dir = dir;
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
    }
    public void step(){}
}
