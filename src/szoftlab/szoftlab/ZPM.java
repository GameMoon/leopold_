package szoftlab;

public class ZPM extends Item{
    public void collide(Colonel colonel,Direction dir){
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),colonel,dir);
        colonel.addScore(this);
    }
}
