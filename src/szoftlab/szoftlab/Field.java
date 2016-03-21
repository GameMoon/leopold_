package szoftlab;

import java.util.ArrayList;

public class Field {
    private ArrayList<Item> items = new ArrayList<>();
    private Field[] neighbor = new Field[4];
    public void setNeighbor(Field n,Item.Direction dir){
        if(dir == Item.Direction.left ) neighbor[0] = n;
        else if(dir == Item.Direction.right ) neighbor[1] = n;
        else if(dir == Item.Direction.up ) neighbor[2] = n;
        else if(dir == Item.Direction.down ) neighbor[3] = n;
    }
    public Field getNeighbor(Item.Direction dir){
        if(dir == Item.Direction.left ) return neighbor[0];
        else if(dir == Item.Direction.right ) return neighbor[1];
        else if(dir == Item.Direction.up ) return neighbor[2];
        else return neighbor[3];
    }
    public void add(Item item){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        items.add(item);
    }
    public void remove(Item item){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        items.remove(item);
    }
    public void enter(Colonel colonel, Item.Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        for(int k = 0;k<items.size();k++){
           if(items.get(k) != null) items.get(k).collide(colonel,dir);
        }
        colonel.relocate(this);
    }
    public void enter(Bullet bullet, Item.Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        for(int k = 0;k<items.size();k++){
            if(items.get(k) != null) items.get(k).collide(bullet,dir);
        }
        bullet.relocate(this);
    }
    public void enter(Hand hand, Item.Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        for(int k = 0;k<items.size();k++){
            if(items.get(k) != null) items.get(k).collide(hand,dir);
        }
    }
    public void exit(Item item,Item.Direction dir){
        sequencetester.printMethod(Thread.currentThread().getStackTrace());
        for(int k = 0;k<items.size();k++){
            if(items.get(k) != null) items.get(k).release();
        }
    }
}
