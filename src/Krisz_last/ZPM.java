package szoftlab;

public class ZPM extends Item{
    public void collide(Colonel colonel,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), colonel, dir);
        colonel.addScore(this);
    }
    @Override
    public String debugString() {
    	
    	return "Z";
    }
}
