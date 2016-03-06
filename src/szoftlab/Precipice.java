package szoftlab;

public class Precipice extends Tile{
	public int enter(){
		item.death();
		return 1;
	}
}
