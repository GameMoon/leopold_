package szoftlab;

public class Box extends Item{
    public void destroy(){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
    }
    public void collide(Hand hand,Direction dir){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),hand,dir);
        hand.grab(this);
    }
}
