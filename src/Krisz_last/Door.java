package szoftlab;

public class Door extends Item{
    private boolean status = false; //true is open
    private int serialnumber;
    public Door(int s){
    	serialnumber=s;
    }
    public int Getserialnumber(){
    	return serialnumber;
    }
    public void open(){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        status = true;
    }
    public void close(){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        status = false;
    }
    public void collide(Colonel colonel,Direction dir){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), colonel, dir);
        if(!status) colonel.setBlocked(true);
    }
    public void collide(Bullet bullet,Direction dir){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), bullet, dir);
        if(!status) bullet.setBlocked(true);
    }
    @Override
    public String debugString() {
    	if(status){
    	return "+<"+serialnumber+">";
    	}
    	else return "<"+serialnumber+">";
    }
}
