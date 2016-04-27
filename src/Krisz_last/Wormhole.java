package szoftlab;

import java.awt.Color;

public class Wormhole {
    private Portal firstPortal;
    private Portal secondPortal;
    private boolean isFirstColor=true;
    private Color firstColor;
    private Color secondColor;
    public Wormhole(Color first, Color second){
        firstPortal = null;
        secondPortal = null;
        firstColor = first;
        secondColor = second;
    }
    public void open(Field field,Item.Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), field, dir, isFirstColor);

        if(isFirstColor){
            if(firstPortal != null){
                firstPortal.close();
            }
            firstPortal = new Portal(field,isFirstColor,calculateDir(dir),this, firstColor);
            firstPortal.open();
        }
        else{
            if(secondPortal != null){
                secondPortal.close();
            }
            secondPortal = new Portal(field,isFirstColor,calculateDir(dir),this, secondColor);
            secondPortal.open();
        }
        

    }
    private Item.Direction calculateDir(Item.Direction bulletDir){
        if(bulletDir == Item.Direction.down) return Item.Direction.up;
        else if(bulletDir == Item.Direction.right) return Item.Direction.left;
        else if(bulletDir == Item.Direction.left) return Item.Direction.right;
        else return Item.Direction.down;
    }
    public void transport(Portal from,Colonel colonel, Item.Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), from, colonel, dir);
        if(firstPortal != null && secondPortal != null){
            colonel.setBlocked(false);
            if(from == firstPortal){
            	secondPortal.exit(colonel);
            }
            else if(from == secondPortal){
            	firstPortal.exit(colonel);
            }
            colonel.setBlocked(true);
        }

    }
    public void changeColor(){isFirstColor=!isFirstColor;}
}
