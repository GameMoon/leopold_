package szoftlab;

public class Rift extends Item{
    public void collide(Colonel colonel,Direction dir){
       sequencetester.printMethod(Thread.currentThread().getStackTrace());
       colonel.setBlocked(true);
       colonel.die();
    }
}
