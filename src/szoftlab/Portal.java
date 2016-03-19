
public class Portal {
    private boolean isBlue;
    private Item.Direction dir;
    private Wormhole wormhole;
    private Field field;

    public Portal(Field field,boolean isBlue,Item.Direction dir,Wormhole wormhole){
        this.field = field;
        this.isBlue = isBlue;
        this.dir = dir;
        this.wormhole = wormhole;
    }
}
