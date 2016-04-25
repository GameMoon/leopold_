package szoftlab;

public class Portal extends Item{
    private boolean isBlue;
    private Wormhole wormhole;
    public Field field;
    public Direction dir;

    public Portal(Field field,boolean isBlue,Direction dir,Wormhole wormhole){
        this.field = field;
        this.isBlue = isBlue;
        this.dir = dir;
        this.wormhole = wormhole;
    }
    public void open(){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        field.add(this);
    }
    public void close(){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        field.remove(this);
    }
    public void collide(Colonel colonel,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), colonel, dir);
        wormhole.transport(this,colonel,dir);
    }

}
