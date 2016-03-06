package szoftlab;

import java.util.ArrayList;

public class Tile {
	protected Item item;
	public int enter(){ return 1;}
	public void leave(){}
	public void addItem(Item item){ this.item = item;}
	public void removeItem(){ item = null;}
}
