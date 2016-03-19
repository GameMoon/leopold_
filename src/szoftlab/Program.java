
public class Program {
    public static int mapSizeX = 10;
    public static int mapSizeY = 10;
    public Field[][] map = new Field[mapSizeX][mapSizeY];
    public Wormhole wormhole = new Wormhole();
    public Colonel oneil;

    public Program(){
       initMap();
       oneil = new Colonel(map[0][0],Item.Direction.down);
    }
    private void initMap(){
        //Generate fields
        for(int posX = 0;posX<mapSizeX;posX++){
            for(int posY =0;posY<mapSizeY;posY++) {
                map[posX][posY] = new Field();
            }
        }
        //Init field neighbor's
        for(int posX = 0;posX<mapSizeX;posX++){
            for(int posY =0;posY<mapSizeY;posY++) {
                if(posX-1 >= 0) map[posX][posY].setNeighbor(map[posX-1][posY],Item.Direction.left);
                if(posX+1 < mapSizeX) map[posX][posY].setNeighbor(map[posX+1][posY],Item.Direction.right);
                if(posY-1 >= 0) map[posX][posY].setNeighbor(map[posX][posY-1],Item.Direction.up);
                if(posY+1 < mapSizeY) map[posX][posY].setNeighbor(map[posX][posY+1],Item.Direction.down);
            }
        }
    }
    public Field[][] getMap(){ return map;}
}
