package szoftlab;

public class PortalWall extends Wall {
    private Wormhole wormhole;
    private Field field;

    public PortalWall(Field field,Wormhole wormhole){
        this.field = field;
        this.wormhole = wormhole;
    }
    public void collide(Bullet bullet,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), bullet, dir);
        wormhole.open(field,dir,bullet.isBlue);
        bullet.setBlocked(true);
    }
}
//10-12
