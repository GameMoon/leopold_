package szoftlab;

public class PortalWall extends Wall {
    private Wormhole wormhole;
    private Field field;

    public PortalWall(Field field,Wormhole wormhole){
        this.field = field;
        this.wormhole = wormhole;
    }
    public void collide(Bullet bullet,Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        wormhole.open(field,dir,bullet.isBlue);
        bullet.setBlocked(true);
    }
}
//10-12
