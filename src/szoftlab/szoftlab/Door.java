package szoftlab;

public class Door extends Item{
    private boolean status = true;
    public void open(){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
        status = true;
    }
    public void close(){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
        status = false;
    }
    public void collide(Colonel colonel,Direction dir){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),colonel,dir);
        if(!status) colonel.setBlocked(true);
    }
    public void collide(Bullet bullet,Direction dir){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),bullet,dir);
        if(!status) bullet.setBlocked(true);
    }
}
