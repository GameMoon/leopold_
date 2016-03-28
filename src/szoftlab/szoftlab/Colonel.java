package szoftlab;

public class Colonel extends Moving {
    public Bullet bullet;
    private int score;
    private int maxscore;
    private boolean isBlue;
    private Hand hand;

    public Colonel(Field field,Direction dir,int numberOfZPM){
        this.currentPos = field;
        this.dir = dir;
        isBlue = false;
        maxscore = numberOfZPM;
        hand = new Hand(this);
    }
    public void shoot(){
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
        bullet = new Bullet(currentPos,dir,isBlue);
    }
    public void step(){
        sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
        currentPos.exit(this,dir);
        currentPos.getNeighbor(dir).enter(this, dir);
    }
    public void changeColor(){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
        if(isBlue) isBlue = false;
        else isBlue = true;
    }
    public void pickUp(){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
        currentPos.getNeighbor(dir).enter(hand,dir);
    }
    public void putDown(){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
        currentPos.getNeighbor(dir).enter(hand,dir);
        hand.free();
    }
    public void die(){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
       hand.die();
    }
    public void addScore(ZPM zpm){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace(),zpm);
        score++;
        if(score == maxscore) win();
        currentPos.remove(zpm);
    }
    public void win(){
       sequencetester.printMethod(this,Thread.currentThread().getStackTrace());
    }

}
