
package szoftlab;

import java.awt.Color;

public class Portal extends Item{
    private boolean isBlue;
    private Wormhole wormhole;
    private Field field;
    private Direction dir;
    private Color color;
    public Portal(Field field,boolean isBlue,Direction dir,Wormhole wormhole, Color color){
        this.field = field;
        this.isBlue = isBlue;
        this.dir = dir;
        this.wormhole = wormhole;
        this.color = color;
        drawable.loadSprite("images/portals.png",64,false);
    }
    public void open(){
        field.add(this);
        drawable.visible = true;
        if(color == Color.BLUE) drawable.setState(dir,0);
        else if(color == Color.ORANGE) drawable.setState(dir,1);
        else if(color == Color.RED) drawable.setState(dir,2);
        else if(color == Color.GREEN) drawable.setState(dir,3);
    }
    public void close(){
        field.remove(this);
        drawable.visible = false;
    }
    public void collide(Colonel colonel,Direction dir){
        SeqTester.printMethod(this, Thread.currentThread().getStackTrace(), colonel, dir);
        if(this.dir == calculateDir(dir))
        	wormhole.transport(this,colonel,dir);
    }
    private Direction calculateDir(Direction bulletDir){
        if(bulletDir == Direction.down) return Direction.up;
        else if(bulletDir == Direction.right) return Direction.left;
        else if(bulletDir == Direction.left) return Direction.right;
        else return Direction.down;
    }
    public void exit(Colonel col)
    {
    	col.rotate(dir);
    	field.getNeighbor(dir).enter(col, dir);
    }
    @Override
    public String debugString() {
    	String re = "";
    	if(color == Color.BLUE)
    	{
    		re = "k";
    	}
    	else if (color == Color.YELLOW)
    	{
    		re = "s";
    	}
    	else if (color == Color.RED)
    	{
    		re = "p";
    	}
    	else if (color == Color.GREEN)
    	{
    		re = "z";
    	}
    	switch (dir)
    	{
    	case up:
    		re+="�";
    		break;
    	case left:
    		re+="n";
    		break;
    	case right:
    		re+="k";
    		break;
    	case down:
    		re+="d";
    		break;
    	}
    	return re;
    }
    
}
