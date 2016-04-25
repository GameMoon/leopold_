package szoftlab;

public class Scale extends Item {
    private Door door;
    private int minWeight;
    private int currentWeight;
    public Scale(Door door,int min){
        this.door = door;
        this.minWeight=min;
    }
    public void collide(Colonel colonel,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), colonel, dir);
        press(colonel);
    }
    public void collide(Box box,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), box, dir);
        press(box);
    }
    public void press(Item i){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        currentWeight+=i.getWeight();
        if(currentWeight>=minWeight){
        	door.open();
        }
    }
    public void release(Item i){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace());
        currentWeight-=i.getWeight();
        if (currentWeight<=minWeight){
        	 door.close();
        }     
    }
}
