package szoftlab;

public class PortalWall extends Wall {
    private Field field;

    public PortalWall(Field field){
        this.field = field;
    }
    public void collide(Bullet bullet,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), bullet, dir);
        bullet.getWormhole().open(field, dir); //dir ellentétes
        bullet.setBlocked(true);
    }
}
//10-12
