package szoftlab;

public class ZPM extends Item{
    private Field field;
    public ZPM(Field field){
        drawable.loadImage("images/zpm.png");
        this.field = field;
    }
    public void collide(Colonel colonel,Direction dir){
        field.remove(this);
        colonel.addScore(this);
    }
    @Override
    public String debugString() {
    	
    	return "Z";
    }
}
