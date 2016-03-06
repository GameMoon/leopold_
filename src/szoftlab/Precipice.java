package szoftlab;

public class Precipice extends Tile{
	public int enter(int directon){
		item.death();
		return 1;
	}
}
