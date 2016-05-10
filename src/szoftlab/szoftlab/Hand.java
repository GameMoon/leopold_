package szoftlab;

public class Hand extends Item{
    public Box box;
    private Colonel colonel;
    public Hand(Colonel colonel){
        this.colonel = colonel;
    }
    public void die(){
        if(box != null){
            box.destroy();
            box = null;
        }
    }
    public void grab(Box box){
        this.box = box;
        colonel.currentPos.getNeighbor(colonel.dir).remove(box);
    }
    public Box free(){
        colonel.currentPos.getNeighbor(colonel.dir).enter(box, colonel.dir);
        box=null;
        return box;
    }
    public boolean hasBox(){
        if(box != null) return true;
        else return false;
    }
}
