package szoftlab;

public class Rift extends Item{
    public void collide(Colonel colonel,Direction dir){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),colonel,dir);
       colonel.setBlocked(true);
       colonel.die();
    }
}
