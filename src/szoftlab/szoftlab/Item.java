package szoftlab;

abstract public class Item {
    protected enum Direction{
        up,left,right,down
    }
    int weight=0;
    public int getWeight(){return weight;}
    public void collide(Bullet bullet,Direction dir){}
    public void collide(Colonel colonel,Direction dir){}
    public void collide(Hand hand,Direction dir){}
    public void collide(Box box,Direction dir){}
    public void release(Item i){}
    
    public String debugString() {return "";}
}
