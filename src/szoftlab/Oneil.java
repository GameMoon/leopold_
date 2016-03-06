package szoftlab;

public class Oneil extends Item{
	private Box box;
	private int score;
	private int maxscore;
	private int direction;
	public Oneil(int maxscore){ 
		this.maxscore = maxscore;
	}
	public void shoot(int type){
		
	}
	public int getDirection(){
		return direction;
	}
	public int getScore(){
		return score;
	}
	public void death(){
		score = -1;
	}
}
