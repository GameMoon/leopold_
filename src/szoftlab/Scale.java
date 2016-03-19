
public class Scale extends Item {
    private Door door;

    public Scale(Door door){
        this.door = door;
    }
    public void collide(Colonel colonel,Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        press();
    }
    public void collide(Box box,Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        press();
    }
    public void press(){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        door.open();
    }
    public void release(){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        door.close();
    }
}
