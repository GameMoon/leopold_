
abstract public class Item {
    protected enum Direction{
        up,left,right,down
    }
    public void collide(Bullet bullet,Direction dir){}
    public void collide(Colonel colonel,Direction dir){}
    public void collide(Hand hand,Direction dir){}
    public void release(){}
}
