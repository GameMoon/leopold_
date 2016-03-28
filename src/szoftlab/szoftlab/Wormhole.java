package szoftlab;

public class Wormhole {
    private Portal bluePortal;
    private Portal orangePortal;

    public Wormhole(){
        bluePortal = null;
        orangePortal = null;
    }
    public void open(Field field,Item.Direction dir,boolean isBlue){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), field, dir, isBlue);

        if(isBlue){
            if(bluePortal != null){
                bluePortal.close();
                bluePortal = null;
            }
            bluePortal = new Portal(field,isBlue,calculateDir(dir),this);
            bluePortal.open();
        }
        else{
            if(orangePortal != null){
                orangePortal.close();
                orangePortal = null;
            }
            orangePortal = new Portal(field,isBlue,calculateDir(dir),this);
            orangePortal.open();
        }


    }
    private Item.Direction calculateDir(Item.Direction bulletDir){
        if(bulletDir == Item.Direction.down) return Item.Direction.up;
        else if(bulletDir == Item.Direction.right) return Item.Direction.left;
        else if(bulletDir == Item.Direction.left) return Item.Direction.right;
        else return Item.Direction.down;
    }
    public void transport(Portal portal,Colonel colonel, Item.Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), portal, colonel, dir);
        if(bluePortal != null && orangePortal != null && dir == calculateDir(portal.dir)){
            colonel.setBlocked(false);
            if(portal == bluePortal){
                //colonel.currentPos.exit(colonel,dir);
                colonel.rotate(orangePortal.dir);
                orangePortal.field.getNeighbor(colonel.dir).enter(colonel, colonel.dir);
            }
            else if(portal == orangePortal){
               // colonel.currentPos.exit(colonel,dir);
                colonel.rotate(bluePortal.dir);
                bluePortal.field.getNeighbor(colonel.dir).enter(colonel,colonel.dir);
            }
            colonel.setBlocked(true);
        }

    }
}
