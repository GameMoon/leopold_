package szoftlab;

public class Controller {
	Oneil player;
	Map map;
	public Controller(){
		map = new Map(20,30);
		player = new Oneil(3);
	}
	public void step(){
		if(player.getScore() == -1){
			reset();
		}
	}
	public Item pickup(Tile tile){ return new Box(1);}
	public void reset(){}
}
