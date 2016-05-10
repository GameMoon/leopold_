package szoftlab;

public class Rift extends Item{
    public Rift(){
        drawable.loadImage("images/rift.png");
    }
    public void collide(Colonel colonel,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), colonel, dir);
        colonel.setBlocked(true);
        colonel.die();
    }
    public void collide(Box box ,Direction dir){
        box.destroy();
    }
    public void collide(Replikator replikator,Direction dir){
        replikator.setBlocked(true);
        replikator.die(this);
    }
    @Override
    public String debugString() {
    	
    	return "R";
    }
}
