package szoftlab;


import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import szoftlab.Item.Direction;

import javax.swing.*;

public class Program {
    public static int mapSizeX = 12;
    public static int mapSizeY = 10;
    public Field[][] map;
    public Colonel oneil;
    public Colonel jaffa;
    public Replikator replikator;
    public Program(){
        replikator = null;
        initMap();
        oneil = new Colonel(map[1][1],Item.Direction.down,10,10,new Wormhole(Color.BLUE,Color.orange),this);
        generateTestMap();
       
    }
    public void generateTestMap(){
        for(int x = 0;x < mapSizeX;x++){
            for(int y = 0;y < mapSizeY;y++){
                if(x == 0 || y == 0 || y == mapSizeY-1 || x == mapSizeX-1){
                    map[x][y].add(new Wall());
                }
            }
        }
        map[1][1].add(oneil);
    }
    public void mapLoader(String mapName)
	{
		try
		{
			BufferedReader fr1 = new BufferedReader(new InputStreamReader(new FileInputStream(mapName+"map.txt")));
			int n = Integer.parseInt(fr1.readLine()) + 2;
			map = new Field[n][n];
			mapSizeX = n;
			mapSizeY = n;
			initMap();
			ArrayList<Integer> scalesIndex = new ArrayList<Integer>();
			ArrayList<Scale> scales = new ArrayList<Scale>();
			ArrayList<Integer> doorsIndex = new ArrayList<Integer>();
			ArrayList<Door> doors = new ArrayList<Door>();
			for(int i = 0; i < n; i++)
			{
				map[0][i].add(new Wall());
				map[n - 1][i].add(new Wall());
				map[i][0].add(new Wall());
				map[i][n - 1].add(new Wall());
			}
			for(int i = 0; i < n - 2; i++)
			{
				String line[] = fr1.readLine().split(";");
				for(int j = 0; j < n - 2; j++)
				{
					for(int k = 0; k < line[j].length(); k++)
					{
						switch(line[j].charAt(k))
						{
						case ('R') :
							map[i + 1][j + 1].add(new Rift());
							break;
						case ('W') :
							map[i + 1][j + 1].add(new Wall());
							break;
						case ('P') :
							map[i + 1][j + 1].add(new PortalWall(map[i + 1][j + 1]));
							break;
						case ('<') :
							k++;
							String xD = line[j].substring(k).split(">")[0];
							doorsIndex.add(Integer.parseInt(xD));
							Door door = new Door(doorsIndex.get(doorsIndex.size()-1));
							map[i + 1][j + 1].add(door);
							doors.add(door);
							k += xD.length();
							break;
						case ('-') :
							k += 2;
							String[] xS = line[j].substring(k).split(">")[0].split(",");
							Scale scale = new Scale(Integer.parseInt(xS[1]));
							map[i + 1][j + 1].add(scale);
							scalesIndex.add(Integer.parseInt(xS[0]));
							scales.add(scale);
							k += (xS[0].length() + xS[1].length() + 1);
							break;
						default:
							break;
						}
					}
				}
			}
			for(int i = 0; i < scalesIndex.size(); i++)
			{
				scales.get(i).setDoor(doors.get(doorsIndex.indexOf(scalesIndex.get(i))));
			}
			fr1.close();

			BufferedReader fr2 = new BufferedReader(new InputStreamReader(new FileInputStream(mapName+"items.txt")));
			fr2.readLine(); //�n sz�vesen beolvasom
			int col1W = Integer.parseInt(fr2.readLine());
			int col2W = Integer.parseInt(fr2.readLine());
			int boxW = Integer.parseInt(fr2.readLine());
			for(int i = 0; i < n - 2; i++)
			{
				String line[] = fr2.readLine().split(";");
				for(int j = 0; j < n - 2; j++)
				{
					for(int k = 0; k < line[j].length(); k++)
					{
						switch(line[j].charAt(k))
						{
						case ('O') :
							oneil = new Colonel(map[i + 1][j + 1], Direction.up, 3, col1W,new Wormhole(Color.BLUE, Color.YELLOW),this);
							map[i + 1][j + 1].add(oneil);
							break;
						case ('J') :
							jaffa = new Colonel(map[i + 1][j + 1], Direction.up, 3, col2W,new Wormhole(Color.RED, Color.GREEN),this);
							map[i + 1][j + 1].add(jaffa);
							break;
						case ('R') :
							replikator = new Replikator(map[i + 1][j + 1]);
							map[i + 1][j + 1].add(replikator);
							break;
						case ('B') :
							map[i + 1][j + 1].add(new Box(boxW, map[i + 1][j + 1]));
							break;
						case ('Z') :
							map[i + 1][j + 1].add(new ZPM());
							break;
						default:
							break;
						}
					}
				}
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		
	}
    public void saveMap(String fileName){
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(fileName+".txt"));
            bfw.write(getResult());
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getResult() {
        String output = "";
    	for(int i=0;i< mapSizeX - 2;i++){
    		for(int j=0; j<mapSizeY - 2;j++){
    			String aString = map[i + 1][j + 1].getItemsString();
    			String fieldType = "T";
    			int zpmCount = 0;
    			int boxCount = 0;
    			char oneilHere = 'N', jaffaHere = 'N', repliHere = 'N';
    			char portalColor = 'n', portalDir = '-';
    			for(int k = 0; k < aString.length(); k++)
    			{
    				String number;
    				switch (aString.charAt(k))
    				{
    				case 'R':
    					fieldType = "R";
    					break;
    				case 'W':
    					fieldType = "W";
    					break;
    				case 'P':
    					fieldType = "P";
    					break;
    				case '<':
    					k++;
    					number = aString.substring(k).split(">")[0];
    					fieldType = "<".concat(number).concat(">");
    					k += number.length();
    					break;
    				case '+':
    					k += 2;
    					number = aString.substring(k).split(">")[0];
    					fieldType = "+<".concat(number).concat(">");
    					k += number.length();
    					break;
    				case '-':
    					k += 2;
    					number = aString.substring(k).split(">")[0];
    					fieldType = "-<".concat(number).concat(">");
    					k += number.length();
    					break;
    				case 'Z':
    					zpmCount++;
    					break;
    				case 'B':
    					boxCount++;
    					break;
    				case 'o':
    					oneilHere = 'I';
    					break;
    				case 'j':
    					jaffaHere = 'I';
    					break;
    				case 'r':
    					repliHere = 'I';
    					break;
    				case 'p':
    				case 'z':
    				case 'k':
    				case 's':
    					portalColor = aString.charAt(k);
    					portalDir = aString.charAt(++k);
    					break;
    				default:
    					break;
    				}
    			}
    			String finalString="<"+fieldType+","+zpmCount+","+boxCount+","+jaffaHere+","+oneilHere+","+repliHere+","+portalColor+","+portalDir+">";
    			System.out.print(finalString);
                output += finalString;
    		}
            output += "\n";
    		System.out.println();
    	}
        return output;
    }
    private void initMap(){
        map = new Field[mapSizeX][mapSizeY];
        //Generate fields
        for(int posX = 0;posX<mapSizeX;posX++){
            for(int posY =0;posY<mapSizeY;posY++) {
                map[posX][posY] = new Field();
            }
        }
        //Init field neighbor's
        for(int posY = 0;posY<mapSizeX;posY++){
            for(int posX =0;posX<mapSizeY;posX++) {
                if(posY-1 >= 0) map[posY][posX].setNeighbor(map[posY-1][posX],Item.Direction.up);
                if(posY+1 < mapSizeX) map[posY][posX].setNeighbor(map[posY+1][posX],Item.Direction.down);
                if(posX-1 >= 0) map[posY][posX].setNeighbor(map[posY][posX-1],Item.Direction.left);
                if(posX+1 < mapSizeY) map[posY][posX].setNeighbor(map[posY][posX+1],Item.Direction.right);
            }
        }
    }
    public void createRandomZPM(){
    	Random rdm = new Random();
        int x = rdm.nextInt(mapSizeX-1);
        int y = rdm.nextInt(mapSizeY-1);
        Field field = map[x][y];
        while(field.getItems().size() != 0){
            x = rdm.nextInt(mapSizeX-1);
            y = rdm.nextInt(mapSizeY-1);
           field = map[x][y];
       }
        field.add(new ZPM());
    };
    public Field[][] getMap(){ return map;}
    public void prototester(){
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
                if(player.dir == Item.Direction.up && line[1].equals("right")) player.rotate(Item.Direction.right);
                else if(player.dir == Item.Direction.up && line[1].equals("left")) player.rotate(Item.Direction.left);
                else if(player.dir == Item.Direction.right && line[1].equals("right")) player.rotate(Item.Direction.down);
                else if(player.dir == Item.Direction.right && line[1].equals("left")) player.rotate(Item.Direction.up);
                else if(player.dir == Item.Direction.down && line[1].equals("right")) player.rotate(Item.Direction.left);
                else if(player.dir == Item.Direction.down && line[1].equals("left")) player.rotate(Item.Direction.right);
                else if(player.dir == Item.Direction.left&& line[1].equals("right")) player.rotate(Item.Direction.up);
                else if(player.dir == Item.Direction.left && line[1].equals("left")) player.rotate(Item.Direction.down);
            }
            else if(line[0].equals("setrandom")){
				if(line[1].equals("replicator")) game.replikator.setRandom(Boolean.parseBoolean(line[2]));
			}
            else if(line[0].equals("loadmap") || line[0].equals("loaditems")){game.mapLoader(line[1]);}
            else if(line[0].equals("showmap")){game.getResult();}
            else if(line[0].equals("savemap") || line[0].equals("saveitems")){ game.saveMap(line[1]);}
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
                    field.add(new PortalWall(field));
                }
                else if(type.equals("Portal")){
                    Color color;
                    if(line[5].equals("blue")) color = Color.BLUE;
                    else if(line[5].equals("orange")) color = Color.ORANGE;
                    else if(line[5].equals("green")) color = Color.green;
                    else if(line[5].equals("red")) color = Color.red;
                    else color = Color.blue;
                    field.add(new Portal(field, Boolean.parseBoolean(line[4]),player.dir, player.worm,color));
                }
                else if(type.equals("Replikator")){
                    field.add(new Replikator(field));
                }
                else if(type.equals("Box")){
                    field.add(new Box(Integer.parseInt(line[4]),field));
                }
                else if(type.equals("ZPM")){
                    field.add(new ZPM());
                }
                else if(type.equals("Rift")){
                    field.add(new Rift());
                }
                else if(type.equals("Door")){
                    field.add(new Door(Integer.parseInt(line[4])));
                }
                else if(type.equals("Scale")){
                    field.add(new Scale(Integer.parseInt(line[4])));
                }
            }
            else if(line[0].equals("pass")){
                if(isOneilActive) isOneilActive = false;
                else isOneilActive = true;
            }
            else if(line[0].equals("steup_replicator")){
                game.replikator.step();
            }
            else{
                System.out.println("Command not found");
            }


        }
    }
	public static void main(String[] args){
		Program game = new Program();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initGUI(game);
			}
		});
	}
	private static void initGUI(Program game){
		JFrame window = new JFrame("leopold_");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        View view = new View(game);
        view.addKeyListener(new Controller(game,view));
        view.setFocusable(true);

		window.add(view);
		window.pack();
		window.setVisible(true);
	}
}
