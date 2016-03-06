package szoftlab;

import java.util.ArrayList;

public class Map {
	private ArrayList<Tile> cells = new ArrayList<>();
	private int sizeX;
	private int sizeY;
	
	public Map(int sizeX,int sizeY){
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
}
