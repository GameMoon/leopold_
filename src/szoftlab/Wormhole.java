
public class Wormhole {
    private Portal bluePortal;
    private Portal orangePortal;

    public Wormhole(){
        bluePortal = null;
        orangePortal = null;
    }
    public void open(Field field,Item.Direction dir,boolean isBlue){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());

        if(isBlue && bluePortal == null) bluePortal = new Portal(field,isBlue,calculateDir(dir),this);
        else if(!isBlue && orangePortal == null) orangePortal = new Portal(field,isBlue,calculateDir(dir),this);
    }
    private Item.Direction calculateDir(Item.Direction bulletDir){
        if(bulletDir == Item.Direction.down) return Item.Direction.up;
        else if(bulletDir == Item.Direction.right) return Item.Direction.left;
        else if(bulletDir == Item.Direction.left) return Item.Direction.right;
        else return Item.Direction.down;
    }
    public void transport(){

    }
}
