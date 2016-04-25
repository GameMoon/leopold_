package szoftlab;

public class Hand extends Item{
    private Box box;
    private Colonel colonel;
    public Hand(Colonel colonel){
        this.colonel = colonel;
    }
    public void die(){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        if(box != null){
            box.destroy();
            box = null;
        }
    }
    public void grab(Box box){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), box);
        this.box = box;
        colonel.currentPos.getNeighbor(colonel.dir).remove(box);
    }
    public Box free(){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        colonel.currentPos.getNeighbor(colonel.dir).enter(box, colonel.dir);
        return box;
    }
    public boolean hasBox(){
        if(box != null) return true;
        else return false;
    }
}
