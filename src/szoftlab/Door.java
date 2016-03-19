
public class Door extends Item{
    private boolean status = true;
    public void open(){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        status = true;
    }
    public void close(){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        status = false;
    }
    public void collide(Colonel colonel,Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        if(!status) colonel.setBlocked(true);
    }
    public void collide(Bullet bullet,Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        if(!status) bullet.setBlocked(true);
    }
}
