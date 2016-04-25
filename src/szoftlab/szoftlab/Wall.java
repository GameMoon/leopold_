package szoftlab;

public class Wall extends Item{
    public void collide(Colonel colonel,Direction dir){
        colonel.setBlocked(true);
    }
    public void collide(Bullet bullet,Direction dir){
        bullet.setBlocked(true);
    }
    public void collide(Replikator rep,Direction dir){
        rep.setBlocked(true);
    }
}
