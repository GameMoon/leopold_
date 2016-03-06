package szoftlab;

public class Door extends Tile{
	private boolean status;
	public void open(){
		status = true;
	}
	public void close(){
		status = false;
	}
	public Door(){
		status = false;
	}
	public int enter(int directon){ return 1;}
}
