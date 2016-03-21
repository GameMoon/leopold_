package szoftlab;

public class Hand extends Item{
    private Box box;
    private Colonel colonel;
    public Hand(Colonel colonel){
        this.colonel = colonel;
    }
    public void grab(Box box){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        this.box = box;
        colonel.currentPos.getNeighbor(colonel.dir).remove(box);
    }
    public Box free(){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        colonel.currentPos.getNeighbor(colonel.dir).add(box);
        return box;
    }
}
