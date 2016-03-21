package szoftlab;

public class ZPM extends Item{
    public void collide(Colonel colonel,Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        colonel.addScore(this);
    }
}
