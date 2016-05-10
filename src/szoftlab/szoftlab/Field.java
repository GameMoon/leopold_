package szoftlab;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Field {
	private ArrayList<Item> items = new ArrayList<>();
    private Field[] neighbor = new Field[4];
    public Drawable drawable = new Drawable();

    public Field(){
        drawable.loadImage("images/floor.png");
    }
    public void clearItems(){
        items.clear();
    }
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
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), item);
        items.add(item);
    }
    public void remove(Item item){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), item);
        items.remove(item);
        for(int i=0; i<items.size();i++){
        	items.get(i).release(item);
        }
    }
    public void enter(Colonel colonel, Item.Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), colonel, dir);
        for(int k = 0;k<items.size();k++){
           if(items.get(k) != null) items.get(k).collide(colonel,dir);
        }
        colonel.relocate(this);
        colonel.blocked = false;
    }
    public void enter(Replikator replikator, Item.Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), replikator, dir);
        for(int k = 0;k<items.size();k++){
            if(items.get(k) != null) items.get(k).collide(replikator,dir);
        }
        replikator.relocate(this);
        replikator.setBlocked(false);
    }
    public void enter(Bullet bullet, Item.Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), bullet, dir);
        for(int k = 0;k<items.size();k++){
            if(items.get(k) != null) items.get(k).collide(bullet,dir);
        }
        bullet.relocate(this);
    }
    public void enter(Hand hand, Item.Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), hand, dir);
        for(int k = 0;k<items.size();k++){
            if(items.get(k) != null) items.get(k).collide(hand,dir);
        }
    }
    public void enter(Box box, Item.Direction dir){
        this.add(box);
        box.currentPos = this;
        for(int k = 0;k<items.size();k++){
            if(items.get(k) != null) items.get(k).collide(box,dir);
        }
    }
    public void exit(Item item,Item.Direction dir){
        for(int k = 0;k<items.size();k++){
            if(items.get(k) != null) items.get(k).release(item);
        }
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public String getItemsString()
    {
    	String re = "";
    	for(int i = 0; i < items.size(); i++)
    	{
    		String lol = items.get(i).debugString();
    		re += lol;
    	}
    	return re;
    }
}
