package szoftlab;

public class Wall extends Item{
    public void collide(Colonel colonel,Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        colonel.setBlocked(true);
    }
    public void collide(Bullet bullet,Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        bullet.setBlocked(true);
    }
}
