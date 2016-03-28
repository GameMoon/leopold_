package szoftlab;

public class Wall extends Item{
    public void collide(Colonel colonel,Direction dir){
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),colonel,dir);
        colonel.setBlocked(true);
    }
    public void collide(Bullet bullet,Direction dir){
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),bullet,dir);
        bullet.setBlocked(true);
    }
}
