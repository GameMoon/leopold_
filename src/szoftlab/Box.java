
public class Box extends Item{
    public void destroy(){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
    }
    public void collide(Hand hand,Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        hand.grab(this);
    }
}
