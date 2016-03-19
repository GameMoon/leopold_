
public class Moving extends Item{
    protected Field currentpos;
    protected Direction dir;
    protected boolean blocked;

    public void setBlocked(boolean status){
        blocked = status;
    }
    public void relocate(Field newField){
        currentpos = newField;
    }
    public void rotate(Direction dir){
        this.dir = dir;
    }
    public void step(){}
}
