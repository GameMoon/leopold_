package szoftlab;

public class Box extends Item{
	Field startPos;
	Field currentPos;
    public Box(int w,Field f ){
    	weight=w;
    	startPos=currentPos=f;
        drawable.loadImage("images/box.png");
    }
    public void collide(Hand hand,Direction dir){
        hand.grab(this);
    }
    public void collide(Replikator replikator,Direction dir){
        replikator.setBlocked(true);
    }
    public void collide(Colonel colonel,Direction dir){
        colonel.setBlocked(true);
    }
    public void destroy(){
        currentPos.remove(this);
        currentPos = startPos;
        currentPos.add(this);
    }
    @Override
    public String debugString() {
    	return "B";
    }
}
