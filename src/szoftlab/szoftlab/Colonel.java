package szoftlab;

public class Colonel extends Moving {
    public Bullet bullet;
    public int score;
    public int maxscore;
    private boolean isBlue;
    private Field startField;
    public Hand hand;
    Wormhole worm;
    Program map;
    public int spriteType = 0;
    public Colonel(Field field,Direction dir,int numberOfZPM,int weight,Wormhole worm,Program p){
        this.currentPos = field;
        this.dir = dir;
        isBlue = false;
        maxscore = numberOfZPM;
        hand = new Hand(this);
        this.weight=weight;
        this.worm=worm;
        map = p;
        startField = field;
        drawable.loadSprite("images/player.png",32,true);
    }
    public void rotate(Direction dir){
        this.dir = dir;
        drawable.setState(dir,spriteType);
    }
    public void shoot(){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        bullet = new Bullet(currentPos,dir,isBlue,worm);
    }
    public void step(){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
       // currentPos.exit(this,dir);
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
        hand.die();
       currentPos.remove(this);
       currentPos = startField;
       score = 0;
       startField.add(this);
    }
    public void addScore(ZPM zpm){
        score++;
        if(score%2==0){
            map.createRandomZPM();
        }
        if(score == maxscore) win();
        currentPos.remove(this);

    }
    public void collide(Replikator replikator,Direction dir){
        replikator.setBlocked(true);
    }
    public void win(){

    }
    @Override
    public String debugString() {
    	if(this==map.oneil) return "o";
    	else return "j";

    }

}
