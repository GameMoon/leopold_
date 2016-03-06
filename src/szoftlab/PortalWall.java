package szoftlab;

public class PortalWall extends Wall{
	private int type;
	private int direction;
	
	public void activate(int type,int direction){
		this.direction = direction;
		this.type = type;
	}
	public int enter(){ return 1;}
	
}
