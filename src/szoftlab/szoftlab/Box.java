package szoftlab;

public class Box extends Item{
    public void destroy(){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
    }
    public void collide(Hand hand,Direction dir){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), hand, dir);
        hand.grab(this);
    }
}
