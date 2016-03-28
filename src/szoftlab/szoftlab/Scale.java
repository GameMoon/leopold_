package szoftlab;

public class Scale extends Item {
    private Door door;

    public Scale(Door door){
        this.door = door;
    }
    public void collide(Colonel colonel,Direction dir){
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),colonel,dir);
        press();
    }
    public void collide(Box box,Direction dir){
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),box,dir);
        press();
    }
    public void press(){
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
        door.open();
    }
    public void release(){
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
        door.close();
    }
}
