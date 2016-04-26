package szoftlab;

public class Colonel extends Moving {
    public Bullet bullet;
    private int score;
    private int maxscore;
    private boolean isBlue;
    private Hand hand;
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
        if(isBlue) isBlue = false;
        else isBlue = true;
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
       hand.die();
    }
    public void addScore(ZPM zpm){
       SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), zpm);
        score++;
        //Új ZPM keletkezik, ha felvesz két ZPM-et
        if(score%2==0){
        // Macht etwas....
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
