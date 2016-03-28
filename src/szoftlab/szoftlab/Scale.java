package szoftlab;

public class Scale extends Item {
    private Door door;

    public Scale(Door door){
        this.door = door;
    }
    public void collide(Colonel colonel,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), colonel, dir);
        press();
    }
    public void collide(Box box,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), box, dir);
        press();
    }
    public void press(){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        door.open();
    }
    public void release(){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        door.close();
    }
}
