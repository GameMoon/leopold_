package szoftlab;

public class Wormhole {
    private Portal firstPortal;
    private Portal secondPortal;

    public Wormhole(){
        firstPortal = null;
        secondPortal = null;
    }
    public void open(Field field,Item.Direction dir,boolean isBlue){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), field, dir, isBlue);

        if(isBlue){
            if(firstPortal != null){
                firstPortal.close();
                secondPortal = null;
            }
            firstPortal = new Portal(field,isBlue,calculateDir(dir),this);
            secondPortal.open();
        }
        else{
            if(secondPortal != null){
                secondPortal.close();
                secondPortal = null;
            }
            secondPortal = new Portal(field,isBlue,calculateDir(dir),this);
            secondPortal.open();
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
        if(firstPortal != null && secondPortal != null && dir == calculateDir(portal.dir)){
            colonel.setBlocked(false);
            if(portal == firstPortal){
                //colonel.currentPos.exit(colonel,dir);
                colonel.rotate(secondPortal.dir);
                secondPortal.field.getNeighbor(colonel.dir).enter(colonel, colonel.dir);
            }
            else if(portal == secondPortal){
               // colonel.currentPos.exit(colonel,dir);
                colonel.rotate(firstPortal.dir);
                secondPortal.field.getNeighbor(colonel.dir).enter(colonel,colonel.dir);
            }
            colonel.setBlocked(true);
        }

    }
}
