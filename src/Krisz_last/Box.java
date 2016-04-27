package szoftlab;

public class Box extends Item{
	Field startPos;
	Field currentPos;
	public void destroy(){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
    }
    public Box(int w,Field f ){
    	weight=w;
    	startPos=currentPos=f;
    }
    public void collide(Hand hand,Direction dir){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), hand, dir);
        hand.grab(this);
    }
     @Override
    public String debugString() {
    	
    	return "B";
    }
}
