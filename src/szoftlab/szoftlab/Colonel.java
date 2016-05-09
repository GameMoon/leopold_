package szoftlab;

import java.io.File;
import java.io.IOException;

public class Colonel extends Moving {
    public Bullet bullet;
    private int score;
    private int maxscore;
    private boolean isBlue;
    public Hand hand;
    Wormhole worm;
    Program map;
    
    public Colonel(Field field,Direction dir,int numberOfZPM,int w,Wormhole worm,Program p){
        this.currentPos = field;
        this.dir = dir;
        isBlue = false;
        maxscore = numberOfZPM;
        hand = new Hand(this);
        weight=w;
        this.worm=worm;
        map = p;
        try {
            drawable.loadCharacter(new File("images/player.png").getCanonicalPath(),dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void rotate(Direction dir){
        this.dir = dir;
        try {
            drawable.loadCharacter(new File("images/player.png").getCanonicalPath(),dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void shoot(){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        bullet = new Bullet(currentPos,dir,isBlue,worm);
    }
    public void step(){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        currentPos.exit(this,dir);
        currentPos.getNeighbor(dir).enter(this, dir);
    }
    public void changeColor(){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
       worm.changeColor();
    }
    public void pickUp(){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        currentPos.getNeighbor(dir).enter(hand,dir);
    }
    public void putDown(){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        currentPos.getNeighbor(dir).enter(hand,dir);
        hand.free();
      
        
    }
    public void die(){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
       currentPos.remove(this);
       currentPos=null;
    }
    public void addScore(ZPM zpm){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), zpm);
        score++;
        //�j ZPM keletkezik, ha felvesz k�t ZPM-et
        if(score%2==0){
            map.createRandomZPM();
        }
        if(score == maxscore) win();
        currentPos.remove(zpm);
    }
    public void win(){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
    }
    @Override
    public String debugString() {
    	if(this==map.oneil) return "o";
    	else return "j";

    }

}
