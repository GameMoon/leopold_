package szoftlab;

public class Rift extends Item{
    public void collide(Colonel colonel,Direction dir){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), colonel, dir);
       colonel.setBlocked(true);
       colonel.die();
    }
    @Override
    public String debugString() {
    	
    	return "R";
    }
}
