package szoftlab;

public class Wall extends Item{
    public void collide(Colonel colonel,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), colonel, dir);
        colonel.setBlocked(true);
    }
    public void collide(Bullet bullet,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), bullet, dir);
        bullet.setBlocked(true);
    }
    @Override
    public String debugString() {
    	
    	return "W";
    }
}
