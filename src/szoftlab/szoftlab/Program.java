package szoftlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    public static int mapSizeX = 10;
    public static int mapSizeY = 10;
    public Field[][] map = new Field[mapSizeX][mapSizeY];
    public Wormhole oneilWormhole = new Wormhole();
    public Wormhole jaffaWormhole = new Wormhole();
    public Colonel oneil;
    public Colonel jaffa;

    public Program(){
       initMap();
       oneil = new Colonel(map[0][0],Item.Direction.down,10,10,oneilWormhole);
       jaffa = new Colonel(map[0][3],Item.Direction.down,10,10,jaffaWormhole);
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
    public void clearMap(){
        for(int posX = 0;posX<mapSizeX;posX++){
            for(int posY =0;posY<mapSizeY;posY++) {
                map[posX][posY].clearItems();
            }
        }
    }
    public void showMap(){

    }
    public static void main(String[] args){
        Program game = new Program();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String line[] = null;
        boolean isRunning = true;
        boolean isOneilActive = true;
        Colonel player;
        while(isRunning){
            if(isOneilActive) player = game.oneil;
            else player = game.jaffa;
            try {
                line = bfr.readLine().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(line[0].equals("move")){player.step();}
            else if(line[0].equals("shoot")){player.shoot();}
            else if(line[0].equals("showMap")){}
            else if(line[0].equals("changecolor")){player.changeColor();}
            else if(line[0].equals("interact")){
                if(player.hand.hasBox()){
                    player.putDown();
                }
                else{
                    player.pickUp();
                }
            }
            else if(line[0].equals("turn")){
                if(player.dir == Item.Direction.up) player.rotate(Item.Direction.right);
                else if(player.dir == Item.Direction.right) player.rotate(Item.Direction.down);
                else if(player.dir == Item.Direction.down) player.rotate(Item.Direction.left);
                else if(player.dir == Item.Direction.left) player.rotate(Item.Direction.up);
            }
            else if(line[0].equals("setrandom")){}
            else if(line[0].equals("loadmap")){}
            else if(line[0].equals("loaditems")){}
            else if(line[0].equals("savemap")){}
            else if(line[0].equals("saveitems")){}
            else if(line[0].equals("giveup")){ isRunning = false;}
            else if(line[0].equals("createItem")){
                String type = line[1];
                int posX = Integer.parseInt(line[2]);
                int posY = Integer.parseInt(line[3]);
                Field field = game.map[posX][posY];
                if(type.equals("Wall")){
                    field.add(new Wall());
                }
                else if(type.equals("PortalWall")){
                        field.add(new PortalWall(field,player.wormhole));
                }
                else if(type.equals("Portal")){
                    field.add(new Portal(field, Boolean.parseBoolean(line[4]),player.dir, player.wormhole));
                }
                else if(type.equals("Replikator")){
                    field.add(new Replikator());
                }
                else if(type.equals("Box")){
                    field.add(new Box(Integer.parseInt(line[4])));
                }
                else if(type.equals("ZPM")){
                    field.add(new ZPM());
                }
                else if(type.equals("Rift")){
                    field.add(new Rift());
                }
                else if(type.equals("Scale")){
                    int pos2X = Integer.parseInt(line[4]);
                    int pos2Y = Integer.parseInt(line[5]);
                    Field field2 = game.map[pos2X][pos2Y];
                    Door door = new Door();
                    field2.add(door);
                    field.add(new Scale(door,Integer.parseInt(line[6])));
                }
            }
            else if(line[0].equals("pass")){
                if(isOneilActive) isOneilActive = false;
                else isOneilActive = true;
            }
        }
    }
    //uj zpm letrehozasa
    public void createRandomZPM(){
    	//Macht etwas
    };
    public Field[][] getMap(){ return map;}
}
