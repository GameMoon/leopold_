package szoftlab;

public class Moving extends Item{
    protected Field currentPos;
    protected Direction dir;
    protected boolean blocked;

    public void setBlocked(boolean status){
        blocked = status;
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),status);
    }
    public void relocate(Field newField){
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),newField);
        if(!blocked){
            currentPos.remove(this);
            currentPos = newField;
            currentPos.add(this);
        }
    }
    public void rotate(Direction dir){
        this.dir = dir;
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),dir);
    }
    public void step(){}
}
